package com.example.FruitFlow.service.impl;

import com.example.FruitFlow.dto.*;
import com.example.FruitFlow.entity.Admin;
import com.example.FruitFlow.entity.Customer;
import com.example.FruitFlow.entity.Trader;
import com.example.FruitFlow.enums.RoleEnum;
import com.example.FruitFlow.repository.AdminRepository;
import com.example.FruitFlow.repository.CustomerRepository;
import com.example.FruitFlow.repository.TraderRepository;
import com.example.FruitFlow.service.AuthenticationService;
import com.example.FruitFlow.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.*;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TraderRepository traderRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String username, RoleEnum role) {
        if(role.equals(RoleEnum.ROLE_CUSTOMER)){
            CustomerDTO customerDTO=getCustomerByUsername(username);
            List<SimpleGrantedAuthority>authorities=this.addAuthority(customerDTO.getRole());
            return new UsernamePasswordAuthenticationToken(customerDTO.getUsername(),customerDTO.getPassword(),authorities);
        } else if (role.equals(RoleEnum.ROLE_TRADER)) {
            TraderDTO traderDTO=getTraderByUsername(username);
            List<SimpleGrantedAuthority>authorities=addAuthority(traderDTO.getRole());
            return new UsernamePasswordAuthenticationToken(traderDTO.getUsername(),traderDTO.getPassword(),authorities);
        }
        else {
            AdminDTO adminDTO=getAdminByUsername(username);
            List<SimpleGrantedAuthority>authorities=addAuthority(adminDTO.getRole());
            return new UsernamePasswordAuthenticationToken(adminDTO.getUsername(),adminDTO.getPassword(),authorities);
        }

    }

    private AdminDTO getAdminByUsername(String username) {
        Admin admin=adminRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return modelMapper.map(admin,AdminDTO.class);
    }

    private TraderDTO getTraderByUsername(String username) {
        Trader trader=traderRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return modelMapper.map(trader,TraderDTO.class);
    }

    private List<SimpleGrantedAuthority> addAuthority(RoleEnum role) {
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        if(Objects.nonNull(role)){
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return authorities;
    }

    private CustomerDTO getCustomerByUsername(String username) {
        Customer customer=this.customerRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return modelMapper.map(customer,CustomerDTO.class);
    }






    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
       String username=loginRequestDTO.getUsername();
       String password=loginRequestDTO.getPassword();
       Optional<Admin>admin=adminRepository.findByUsername(username);
       Optional<Customer>customer=customerRepository.findByUsername(username);
       Optional<Trader>trader=traderRepository.findByUsername(username);
       if(customer.isPresent()){
           return loginAsCustomer(username,password);
       } else if (admin.isPresent()) {
           return loginAsAdmin(username,password);
       } else if (trader.isPresent()) {
           return loginAsTrader(username,password);
       }
       else {
           throw new RuntimeException("User not found");
       }
    }

    private LoginResponseDTO  loginAsCustomer(String username, String password) {
        CustomerDTO customerDTO=getCustomerByUsername(username);
        return authenticate(customerDTO,password,customerDTO.getRole());
    }



    private LoginResponseDTO loginAsTrader(String username, String password) {
        TraderDTO traderDTO=getTraderByUsername(username);
        return authenticate(traderDTO,password,traderDTO.getRole());
    }

    private LoginResponseDTO loginAsAdmin(String username, String password) {
        AdminDTO adminDTO=getAdminByUsername(username);
        return authenticate(adminDTO,password,adminDTO.getRole());
    }
    private LoginResponseDTO authenticate(UserDTO userDTO, String rawPassword, RoleEnum role) throws UsernameNotFoundException{
        checkPassword(rawPassword,userDTO.getPassword());
        List<SimpleGrantedAuthority> authorities=addAuthority(role);
        Authentication usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDTO.getUsername(),
                userDTO.getPassword(),authorities);
        String accessToken=jwtUtil.generateToken(usernamePasswordAuthenticationToken.getName(),
                generateRoles(usernamePasswordAuthenticationToken.getAuthorities()));
        userDTO.setPassword(null);
        return new LoginResponseDTO(accessToken,userDTO);
    }

    private void checkPassword(String rawPassword, String encodedPassword) {
        if(!passwordEncoder.matches(rawPassword,encodedPassword))
            throw new BadCredentialsException("PasswordIncorrect");
    }

    private List<String> generateRoles(Collection<? extends GrantedAuthority> authorities) {
        List<String>roles=new ArrayList<>();
        authorities.forEach(grantedAuthority -> roles.add(grantedAuthority.toString()))
        ;
        return roles;
    }

    @Override
    public void createAdmin() {
        Admin admin=new Admin();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setFullName("Ayush Thapa");
        admin.setAddress("Kathmandu");
        adminRepository.save(admin);

    }
    @Override
    public CustomerDTO registerAsCustomer(CustomerDTO customerDTO) {
        Customer customer=modelMapper.map(customerDTO,Customer.class);
        if(userNameExists(customer.getUsername())){
            log.error("Username {} already taken",customer.getUsername());
            throw new RuntimeException("Username already exists");
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setAddress(customer.getAddress());
        customer.setFullName(customer.getFullName());
        customerRepository.save(customer);
        customer.setPassword(null);
        return modelMapper.map(customer,CustomerDTO.class);

    }



    @Override
    public TraderDTO registerAsTrader(TraderDTO traderDTO) {
        Trader trader=modelMapper.map(traderDTO,Trader.class);
        if(userNameExists(trader.getUsername())){
            log.error("Username {} already taken", trader.getUsername());
            throw new RuntimeException("Username already exists");
        }
        trader.setPassword(passwordEncoder.encode(trader.getPassword()));
        trader.setAddress(trader.getAddress());
        trader.setFullName(trader.getFullName());
        traderRepository.save(trader);
        trader.setPassword(null);
        return modelMapper.map(trader,TraderDTO.class);
    }

    private boolean userNameExists(String username) {
     Optional<Admin>savedAdmin=adminRepository.findByUsername(username);
     Optional<Customer>savedCustomer=customerRepository.findByUsername(username);
     Optional<Trader>savedTrader=traderRepository.findByUsername(username);
     return savedTrader.isPresent()||savedAdmin.isPresent()||savedCustomer.isPresent();
    }
}
