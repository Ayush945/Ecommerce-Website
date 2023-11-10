import React from 'react'
import Navbar from '../components/Navbar'
import { Outlet } from 'react-router'

function Navigation() {
    return (
        <>
            <Navbar />
            <Outlet />
        </>
    )
}

export default Navigation