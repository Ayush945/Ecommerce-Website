import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import baseUrl from './../CorsConfigure/BaseUrl';
import axios from 'axios';

function Loginpage() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [loginMessage, setLoginMessage] = useState(null);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post(baseUrl + 'api/login', {
                username,
                password,
            });

            // Assuming your backend sends a success message
            setLoginMessage('Login successful!');
        } catch (error) {
            // Assuming your backend sends an error message
            setLoginMessage('Login failed. Please check your credentials.');
            console.error('Error:', error);
        }
    };

    return (
        <>
            <div className='h-screen flex flex-col gap-6 items-center justify-center'>
                <form
                    className=' bg-gray-300 p-4 flex flex-col text-xl gap-4'
                    onSubmit={handleSubmit}
                >
                    <label>Username</label>
                    <input
                        type='text'
                        placeholder='Username'
                        className='mb-3 p-1'
                        onChange={(e) => setUsername(e.target.value)}
                    />
                    <label>Password</label>
                    <input
                        type='password'
                        placeholder='Password'
                        className='mb-3 p-1'
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <button type='submit' className='bg-grey-400'>
                        Login
                    </button>
                </form>
                {loginMessage && (
                    <div className={`mt-4 ${loginMessage.includes('failed') ? 'text-red-500' : 'text-green-500'}`}>
                        {loginMessage}
                    </div>
                )}
                <div className=''>
                    <p>
                        Not a Registered User?{' '}
                        <Link
                            to={'/chooserole'}
                            className='text-green-500 hover:underline hover:text-green-800'
                        >
                            Register Now
                        </Link>
                    </p>
                </div>
            </div>
        </>
    );
}

export default Loginpage;
