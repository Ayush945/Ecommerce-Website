import React, { useEffect, useState } from 'react';
import baseUrl from './CorsConfigure/BaseUrl';
import axios from 'axios';
import Cookies from 'js-cookie';

function Cartpage() {
    const [cartData, setCartData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const userData = Cookies.get('user');
                const userDetail = JSON.parse(userData);
                const customerId = userDetail.customerId;
                const apiEndpoint = `${baseUrl}cart-item/get-cart-item/${customerId}`;

                const response = await axios.get(apiEndpoint);

                console.log('API Response:', response.data);

                setCartData(response.data);
            } catch (error) {
                console.error(error);
            }
        };

        fetchData();
    }, []);
    const handleDelete = async (itemId) => {
        try {
            const apiEndpoint = `${baseUrl}cart-item/delete-cart-item/${itemId}`
            console.log(apiEndpoint);
            const response = await axios.delete(apiEndpoint);
            console.log("response:", response.data);
            setCartData((prevCartData) => prevCartData.filter(item => item.cartItemId !== itemId));
        }
        catch (error) {
            console.error(error);
        }
    }
    return (
        <div className="container mx-auto mt-8">
            <h1 className="text-3xl font-semibold mb-6">Your Cart</h1>
            {cartData.length > 0 ? (
                cartData.map((item) => (
                    <div key={item.cartItemId} className="bg-white shadow-md p-4 mb-4">
                        <h2 className="text-xl font-semibold mb-2">Item Details:</h2>
                        <p className="text-gray-700">Item Name: {item.item.itemName}</p>
                        <p className="text-gray-700">Item Price: ${item.item.itemPrice}</p>
                        <p className="text-gray-700">Item Quantity: {item.quantity}</p>
                        <button
                            className='bg-red-500 text-white px-4 py-2 mt-4 rounded'
                            onClick={() => handleDelete(item.cartItemId)}
                        >Remove Item</button>
                    </div>

                ))
            ) : (
                <p className="text-gray-700">No items in your cart.</p>
            )}

            <div className='flex justify-center items-center'>
                <button
                    className='bg-blue-500 text-white px-4 py-2 mt-4 rounded flex justify-center items-center'
                >Order Now</button>
            </div>
        </div>
    );
}

export default Cartpage;
