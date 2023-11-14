import React from 'react'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
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

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Navigation />}>
          <Route path='/home' element={<Homepage />} />
          <Route path='/fruits' element={<FruitPage />} />
          <Route path='/cart' element={<Cartpage />} />
          <Route path='/notification' element={<Notificationpage />} />
          <Route path='/profile' element={<Profilepage />} />
          <Route path='search' element={<Searchpage />} />
          <Route path='aboutus' element={<Aboutpage />} />
        </Route>

        <Route path='/login' element={<Loginpage />} />
        <Route path='/register' element={<Registerpage />} />
        <Route path='chooserole' element={<RoleChoose />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App