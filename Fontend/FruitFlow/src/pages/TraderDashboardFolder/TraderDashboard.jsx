import React, { useState } from 'react';
import baseUrl from './../CorsConfigure/BaseUrl';
import axios from 'axios';
import Cookies from 'js-cookie';
import { useNavigate } from 'react-router';

function TraderDashboard() {
    const [message, setMessage] = useState(false);
    const [failedStatus, setFailedStatus] = useState(false);
    const navigate = useNavigate()
    const userDetail = Cookies.get('user');
    const userObject = JSON.parse(userDetail);

    const [formData, setFormData] = useState({
        itemName: '',
        itemPrice: '',
        itemQuantity: '',

    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const apiEndpoint = `${baseUrl}item/add-item/${userObject.traderId}`;
        console.log(apiEndpoint)
        try {
            console.log(formData);
            const response = await axios.post(apiEndpoint, formData);
            console.log(response);

            setMessage(true);
        } catch (error) {
            console.error(error);
            setFailedStatus(true);
        }
    };
    const handleLogout = () => {
        navigate('/home')
    }

    return (
        <>
            <div className='h-screen flex flex-col gap-6 items-center justify-center'>
                <p className='text-3xl font-bold text-green-300'>Add a Fruit</p>
                <form
                    className=' bg-gray-300 p-4 flex flex-col text-xl gap-4'
                    onSubmit={handleSubmit}
                >
                    <label>Fruit Name: </label>
                    <input
                        type='text'
                        className='mb-3 p-1'
                        placeholder='Fruit Name'
                        onChange={handleChange}
                        name='itemName'
                        value={formData.itemName}
                        required
                    />
                    <label>Fruit Price: </label>
                    <input
                        type='text'
                        className='mb-3 p-1'
                        placeholder='Fruit Price'
                        onChange={handleChange}
                        name='itemPrice'
                        value={formData.itemPrice}
                        required
                    />
                    <label>Fruit Quantity: </label>
                    <input
                        type='text'
                        className='mb-3 p-1'
                        placeholder='Fruit Quantity'
                        onChange={handleChange}
                        name='itemQuantity'
                        value={formData.itemQuantity}
                        required
                    />
                    <button
                        type='submit'
                        className='bg-grey-400 hover:bg-white'
                    >
                        Add
                    </button>
                </form>
                {message && (
                    <div className='text-green-600 mt-2'>
                        Fruit Added
                    </div>
                )}
                {failedStatus && (
                    <div className='text-red-600 mt-2'>
                        Failed
                    </div>
                )}
                <button onClick={handleLogout}>Exit</button>
            </div>
        </>
    );
}

export default TraderDashboard;
