import Cookies from 'js-cookie';
import React from 'react';
import { useNavigate } from 'react-router';

function Profilepage() {
    const navigate = useNavigate();

    const handleLogout = () => {
        Cookies.remove('access_token');
        Cookies.remove('user');
        navigate('/home');
        window.location.reload();
    };

    const userDetail = Cookies.get('user');
    const userObject = userDetail ? JSON.parse(userDetail) : null;

    return (
        <div className="container mx-auto mt-8 p-4 bg-gray-100 shadow-md max-w-md rounded-md">
            {userObject ? (
                <div>
                    <h1 className="text-2xl font-bold mb-4">User Profile</h1>
                    <p>
                        <span className="font-semibold">User name:</span> {userObject.username}
                    </p>
                    <p>
                        <span className="font-semibold">Full name:</span> {userObject.fullName}
                    </p>
                    <p>
                        <span className="font-semibold">Address:</span> {userObject.address}
                    </p>
                </div>
            ) : (
                <p className="text-red-500">No information available.</p>
            )}

            <button
                onClick={handleLogout}
                className="mt-4 bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
            >
                Logout
            </button>
        </div>
    );
}

export default Profilepage;
