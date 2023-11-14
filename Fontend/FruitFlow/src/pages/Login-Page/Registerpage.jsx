import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import baseUrl from '../CorsConfigure/BaseUrl';

function Registerpage() {
    const { role: urlRole } = useParams(); // Use a different name to avoid conflicts
    const [role, setRole] = useState(urlRole || 'defaultRole');
    const [registationStatus, setRegistrationStatus] = useState(false);
    const [failedStatus, setFailedStatus] = useState(false)
    const [formData, setFormData] = useState({
        username: '',
        fullname: '',
        email: '',
        password: '',
        role: role,
    });

    useEffect(() => {
        // Update role in the state when the URL parameter changes
        setRole(urlRole || 'defaultRole');
    }, [urlRole]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({ ...prevData, [name]: value, role: role }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log({ role });
        const apiEndpoint = `${baseUrl}api/register-${role === '0' ? 'customer' : 'trader'}`;
        console.log(apiEndpoint);

        try {
            const response = await axios.post(apiEndpoint, formData);
            console.log(response.data);
            setRegistrationStatus(true);
        } catch (error) {
            console.error("Error: ", error);
            setFailedStatus(true);
        }
    };

    return (
        <>
            <div className='flex h-screen justify-center items-center'>
                <form
                    className='bg-gray-300 flex flex-col p-5 text-xl'
                    onSubmit={handleSubmit}
                >
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
                        type='password'
                        placeholder='Password'
                        className='mb-1 p-1'
                        name='password'
                        value={formData.password}
                        onChange={handleChange}
                    />

                    <button type='submit'>Register</button>
                    {registationStatus && (
                        <div className='text-green-600 mt-2'>
                            Registration Sucess
                        </div>
                    )}
                    {failedStatus && (
                        <div className='text-red-600' mt-2>
                            Registration Failed
                        </div>
                    )}
                </form>
            </div>
        </>
    );
}

export default Registerpage;
