import { faBell, faPerson, faSearch, faShoppingBag, faUser } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React from 'react'
import { Link } from 'react-router-dom'

function Navbar() {
    return (
        <>
            <div className=' flex justify-between bg-green-300 p-5 items-center cursor-pointer md:justify-around'>
                <div className='font-bold ml-10 text-2xl'>
                    <Link to={'/home'}><p className=' text-gray-600 hover:text-white'>FRUIT FLOW</p></Link>
                </div>
                <div className='flex  gap-10 mr-10 text-2xl text-gray-600 font-semibold '>
                    <Link to={'/fruits'}><p className='hover:text-white'>Fruits</p></Link>
                    <Link to={'/search'} ><p className='hover:text-white'><FontAwesomeIcon icon={faSearch} /></p></Link>
                    <Link to={'/cart'}> <p className='hover:text-white'><FontAwesomeIcon icon={faShoppingBag} /></p></Link>
                    <Link to={'/notification'}><p className='hover:text-white'><FontAwesomeIcon icon={faBell} /></p></Link>
                    <Link to={'/profile'}><p className='hover:text-white'><FontAwesomeIcon icon={faUser} /></p></Link>
                </div>
            </div>
        </>
    )
}

export default Navbar