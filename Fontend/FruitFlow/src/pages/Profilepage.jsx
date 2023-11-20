import Cookies from 'js-cookie'
import React from 'react'
import { useNavigate } from 'react-router';

function Profilepage({ setAuthenticated }) {
    const navigate = useNavigate();


    const handleLogout = () => {
        Cookies.remove('access_token');
        Cookies.remove('user');
        setAuthenticated(false);
        navigate("/home")
    }
    return (
        <>
            <button onClick={handleLogout}>
                Logout
            </button>
        </>
    )
}

export default Profilepage