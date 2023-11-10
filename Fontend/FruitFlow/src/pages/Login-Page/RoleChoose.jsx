import React from 'react';
import { Link } from 'react-router-dom';

function RoleChoose() {
    return (
        <>
            <div className='h-screen flex flex-col justify-center items-center text-3xl gap-7'>
                <div>
                    <form>
                        <Link to={'/register'}>
                            <button

                                className='border-2 p-7 border-solid  border-gray-500 rounded hover:bg-gray-100'
                                type='submit'
                            >
                                Customer
                            </button>
                        </Link>
                    </form>
                </div>
                <div>
                    <form>
                        <Link to={'/register'}>
                            <button
                                className='border-2 px-12 p-7 border-solid border-gray-500 rounded hover:bg-gray-100'
                                type='submit'

                            >
                                Trader
                            </button>
                        </Link>
                    </form>
                </div>
            </div >
        </>
    );
}

export default RoleChoose;
