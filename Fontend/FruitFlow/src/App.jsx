import React, { useState } from 'react'
import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'
import Homepage from './pages/Homepage'
import Navigation from './pages/Navigation'
import FruitPage from './pages/FruitPage'
import Cartpage from './pages/Cartpage'
import Profilepage from './pages/Profilepage'
import Notificationpage from './pages/Notificationpage'
import Searchpage from './pages/Searchpage'
import Aboutpage from './pages/Aboutpage'
import Loginpage from './pages/Login-Page/Loginpage'
import Registerpage from './pages/Login-Page/Registerpage'
import RoleChoose from './pages/Login-Page/RoleChoose'
import Cookies from 'js-cookie'
import AdminDashboard from './pages/AdminDashboardFolder/AdminDashboard'
import TraderDashboard from './pages/TraderDashboardFolder/TraderDashboard'

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/'
          element={<Navigation />}>
          <Route path='/home' element={<Homepage />} />
          <Route path='/fruits' element={<FruitPage />} />
          <Route path='/cart' element={<Cartpage />} />
          <Route path='/notification' element={<Notificationpage />} />

          <Route path='/profile'
            element={
              <Profilepage />
            }

          />

          <Route path='/search' element={<Searchpage />} />
          <Route path='/aboutus' element={<Aboutpage />} />
        </Route>

        <Route
          path='/login'
          element={


            <Loginpage />
          }
        />

        <Route path='/register/:role' element={<Registerpage />} />
        <Route path='chooserole' element={<RoleChoose />} />
        <Route path='adminDashboard' element={<AdminDashboard />} />
        <Route path='traderDashboard' element={<TraderDashboard />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App