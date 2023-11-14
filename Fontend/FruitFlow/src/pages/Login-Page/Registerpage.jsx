import React, { useState } from 'react'
import axios from 'axios';
import { useLocation, useParams } from 'react-router-dom';
import baseUrl from '../CorsConfigure/BaseUrl'

function Registerpage() {
    const { selectedRole } = useParams();

    const [formData, setFormData] = useState({
        username: '',
        fullname: '',
        email: '',
        password: '',
        role: selectedRole,
    })

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({ ...prevData, [name]: value }));
    }
    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(selectedRole)


        const apiEndpoint = selectedRole === '0' ? `${baseUrl}api/register-customer` : `${baseUrl}api/register-trader`;
        console.log(apiEndpoint);
        try {
            const response = await axios.post(apiEndpoint, formData);
            console.log(response.data);
        }
        catch (error) {
            console.error("Error: ", error)
        }

    }

    return (
        <>
            <div className='flex h-screen justify-center items-center'>
                <form
                    className='bg-gray-300 flex flex-col p-5 text-xl'
                    onSubmit={handleSubmit}>
                    <label>Username</label>
                    <input
                        type='text'
                        placeholder='Username'
                        className='mb-1 p-1'
                        name='username'
                        value={formData.username}
                        onChange={handleChange}
                    />

                    <label>Full Name</label>
                    <input
                        type='text'
                        placeholder='Full Name'
                        className='mb-1 p-1'
                        name='fullname'
                        value={formData.fullname}
                        onChange={handleChange}
                    />

                    <label>Email</label>
                    <input
                        type='text'
                        placeholder='Email'
                        className='mb-1 p-1'
                        name='email'
                        value={formData.email}
                        onChange={handleChange}
                    />

                    <label>Password</label>
                    <input
                        type='text'
                        placeholder='Password'
                        className='mb-1 p-1'
                        name='password'
                        value={formData.password}
                        onChange={handleChange}
                    />
                    <button type='submit'
                    >Register</button>

                </form>
            </div>
        </>
    )
}

export default Registerpage