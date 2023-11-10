import React from 'react'

function Registerpage() {
    return (
        <>
            <div className='flex h-screen justify-center items-center'>
                <form className='bg-gray-300 flex flex-col p-5 text-xl'>
                    <label>Username</label>
                    <input type='text' placeholder='Username' className='mb-1 p-1' />
                    <label>Full Name</label>
                    <input type='text' placeholder='Full Name' className='mb-1 p-1' />
                    <label>Email</label>
                    <input type='text' placeholder='Email' className='mb-1 p-1' />
                    <label>Password</label>
                    <input type='text' placeholder='Password' className='mb-1 p-1' />
                    <button type='submit'>Register</button>

                </form>
            </div>
        </>
    )
}

export default Registerpage