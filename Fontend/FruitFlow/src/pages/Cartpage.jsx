import React, { useEffect, useState } from 'react';
import baseUrl from './CorsConfigure/BaseUrl';
import axios from 'axios';
import Cookies from 'js-cookie';

function Cartpage() {
    const [cartData, setCartData] = useState([]);
    const [showOrderModal, setShowOrderModel] = useState(false);

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
            const apiEndpoint = `${baseUrl}cart-item/delete-cart-item/${itemId}`;
            console.log(apiEndpoint);
            const response = await axios.delete(apiEndpoint);
            console.log('response:', response.data);
            setCartData((prevCartData) => prevCartData.filter((item) => item.cartItemId !== itemId));
        } catch (error) {
            console.error(error);
        }
    };

    const handleIncreaseQuantity = (cartItemId, quantity) => {
        const newQuantity = quantity + 50;
        setCartData((prevCartData) =>
            prevCartData.map((item) =>
                item.cartItemId === cartItemId ? { ...item, quantity: newQuantity } : item
            )
        );
    };

    const handleOrderNow = () => {
        setShowOrderModel(true);
    }
    const handleCloseOrderModal = () => {
        setShowOrderModel(false);
    }

    const handleDecreaseQuantity = (cartItemId, quantity) => {
        if (quantity > 1) {
            const newQuantity = quantity - 1;
            setCartData((prevCartData) =>
                prevCartData.map((item) =>
                    item.cartItemId === cartItemId ? { ...item, quantity: newQuantity } : item
                )
            );
        }
    };

    return (
        <div className="container mx-auto mt-8 cursor-pointer">
            <h1 className="text-3xl font-semibold mb-6">Your Cart</h1>
            {cartData.length > 0 ? (
                cartData.map((item) => (
                    <div key={item.cartItemId} className="bg-white shadow-md p-4 mb-4 rounded-md">
                        <h2 className="text-xl font-semibold mb-2">Item Details:</h2>
                        <p className="text-gray-700">Item Name: {item.item.itemName}</p>
                        <p className="text-gray-700">Item Price: ${item.item.itemPrice}</p>

                        <div className="flex items-center space-x-4">
                            <button
                                className="bg-green-500 text-white px-3 py-1 rounded"
                                onClick={() => handleDecreaseQuantity(item.cartItemId, item.quantity)}
                            >
                                -
                            </button>
                            <p className="text-gray-700">Item Quantity: {item.quantity}</p>
                            <button
                                className="bg-green-500 text-white px-3 py-1 rounded"
                                onClick={() => handleIncreaseQuantity(item.cartItemId, item.quantity)}
                            >
                                +
                            </button>
                        </div>

                        <button
                            className="bg-red-500 text-white px-4 py-2 mt-4 rounded"
                            onClick={() => handleDelete(item.cartItemId)}
                        >
                            Remove Item
                        </button>
                    </div>
                ))
            ) : (
                <p className="text-gray-700">No items in your cart.</p>
            )}

            <div className="flex justify-center items-center">
                <button className="bg-blue-500 text-white px-4 py-2 mt-4 rounded"
                    onClick={handleOrderNow}
                >Order Now</button>
            </div>
            {showOrderModal && (
                <div className="fixed top-0 left-0 w-full h-full flex items-center justify-center">
                    <div className=" text-green-500 p-8 rounded-md bg-gray-200 w-1/4">
                        <p className="text-xl mb-4 text-center">Order Placed</p>
                        <p
                            className="bg-white text-green-500 px-4 py-2 rounded text-center hover:bg-green-200"
                            onClick={handleCloseOrderModal}
                        >
                            Exit
                        </p>
                    </div>
                </div>
            )}
        </div>
    );
}

export default Cartpage;
