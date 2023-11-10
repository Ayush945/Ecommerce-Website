import React from 'react'
import fruitPic from '../Images/fruit-homepage.png'
import { Link } from 'react-router-dom'

function Homepage() {
    return (
        <>
            <div className='flex flex-col justify-around items-center px-7 cursor-pointer md:flex-row mt-10'>
                <div className='text-2xl font-semibold md:1/2'>
                    <p>Crave <span className='text-green-300'>Freshness</span> ?</p>
                    <p className='mt-5'>Yearing for <span className='text-green-300'>Bargains</span> in Bulk ?</p>
                    <div className='flex gap-5 mt-7'>
                        <Link to={'/fruits'}><p className='border p-4 rounded-xl bg-green-300 hover:text-white hover:bg-green-500 shadow-green-200 hover:shadow-2xl'>Order Now</p></Link>
                        <Link to={'/aboutus'}><p className='border p-4 rounded-xl bg-green-300 hover:text-white hover:bg-green-500 shadow-green-200 hover:shadow-2xl mt-2 md:mt-0'>Learn More</p></Link>
                    </div>
                </div>
                <div>
                    <img
                        src={fruitPic}
                        alt='fruit pic'
                        className=' h-96 w-96'
                    />
                </div>
            </div>
        </>
    )
}

export default Homepage