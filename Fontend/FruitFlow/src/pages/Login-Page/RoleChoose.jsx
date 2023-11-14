import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function RoleChoose() {
    const [selectedRole, setSelectedRole] = useState(null);
    const navigate = useNavigate();

    const handleRoleSelection = (role) => {
        setSelectedRole(role);
        // Navigate to the registration page with the selected role
        navigate(`/register/${role}`);
    };

    return (
        <>
            <div className='h-screen flex flex-col justify-center items-center text-3xl gap-7'>
                <div>
                    <button
                        className={`border-2 p-7 border-solid border-gray-500 rounded hover:bg-gray-100
                            ${selectedRole === '0' ? 'bg-gray-100' : ''}`}
                        onClick={() => handleRoleSelection('0')}
                    >
                        Customer
                    </button>
                </div>

                <div>
                    <button
                        className={`border-2 px-12 p-7 border-solid border-gray-500 rounded hover:bg-gray-100
                             ${selectedRole === '1' ? 'bg-gray-100' : ''} `}
                        onClick={() => handleRoleSelection('1')}
                    >
                        Trader
                    </button>
                </div>
            </div>
        </>
    );
}

export default RoleChoose;
