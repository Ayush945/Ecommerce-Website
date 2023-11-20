import Cookies from 'js-cookie'
import React from 'react'
import { useNavigate } from 'react-router';

function Profilepage() {
    const navigate = useNavigate();


    const handleLogout = () => {
        Cookies.remove('access_token');
        Cookies.remove('user');
        navigate("/home");
        console.log("Logout", Cookies.get('access_token'));
        window.location.reload();
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