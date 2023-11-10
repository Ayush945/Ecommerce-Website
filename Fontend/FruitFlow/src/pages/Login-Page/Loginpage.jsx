import React from 'react'

function Loginpage() {
    return (
        <>
            <div className='h-screen flex items-center justify-center'>
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
            </div>
        </>
    )
}

export default Loginpage