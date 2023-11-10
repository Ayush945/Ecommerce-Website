import React from 'react'
import { Link } from 'react-router-dom'

function Loginpage() {
    return (
        <>
            <div className='h-screen flex flex-col gap-6 items-center justify-center'>
                <form className=' bg-gray-300 p-4 flex flex-col text-xl gap-4'>
                    <label>Username</label>
                    <input
                        type='text'
                        placeholder='Username'
                        className='mb-3 p-1'
                    />
                    <label>Password</label>
                    <input
                        type='text'
                        placeholder='Password'
                        className='mb-3 p-1'
                    />
                    <button
                        type='submit'
                        className=' bg-grey-400'
                    >Login</button>
                </form>
                <div className=''>
                    <p>Not a Register User? <Link to={'/choserole'} className='text-green-500 hover:underline hover:text-green-800'>Register Now</Link></p>
                </div>
            </div>

        </>
    )
}

export default Loginpage