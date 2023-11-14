import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function RoleChoose() {
    const [selectedRole, setSelectedRole] = useState(null);

    const handleRoleSelection = (role) => {
        setSelectedRole(role);
    };

    return (
        <>
            <div className='h-screen flex flex-col justify-center items-center text-3xl gap-7'>
                <div>
                    <Link to={`/register?role=0`}>
                        <button
                            className={`border-2 p-7 border-solid  border-gray-500 rounded hover:bg-gray-100
                                ${selectedRole === '0' ? 'bg-gray-100' : ''}`}
                            onClick={() => handleRoleSelection('0')}
                        >
                            Customer
                        </button>
                    </Link>
                </div>

                <div>
                    <Link to={`/register?role=1`}>
                        <button
                            className={`border-2 px-12 p-7 border-solid border-gray-500 rounded hover:bg-gray-100
                                 ${selectedRole === '1' ? 'bg-gray-100' : ''} `}
                            onClick={() => handleRoleSelection('1')}
                        >
                            Trader
                        </button>
                    </Link>
                </div>
            </div>
        </>
    );
}

export default RoleChoose;
