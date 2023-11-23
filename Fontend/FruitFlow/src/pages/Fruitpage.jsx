import React, { useEffect, useState } from 'react';
import baseUrl from './CorsConfigure/BaseUrl';
import axios from 'axios';
import Cookies from 'js-cookie';
import { Link } from 'react-router-dom';
function FruitPage() {
    const [fruitData, setFruitData] = useState([]);
    const [message, setMessage] = useState(false);
    useEffect(() => {
        const fetchData = async () => {
            try {
                const apiEndpoint = `${baseUrl}item/get-all-items`;
                console.log("API Endpoint:", apiEndpoint);

                const response = await axios.get(apiEndpoint);
                setFruitData(response.data);
            } catch (error) {
                console.error("Error:", error);
            }
        };
        fetchData();
    }, []);

    const handleClick = (itemId) => {
        const userData = Cookies.get('user')
        const userDetail = JSON.parse(userData);

        const postData = async () => {
            try {
                const apiEndpoint = `${baseUrl}cart-item/add-to-cart/${userDetail.customerId}/${itemId}`
                console.log("Add to cart: ", apiEndpoint);
                const response = await axios.post(apiEndpoint);
                console.log(response.data)
                setMessage(true);

                setTimeout(() => {
                    setMessage(false);
                }, 2000);
            }
            catch (error) {
                console.error(error);
            }
        }
        postData();
    }

    return (
        <>
            <h1 className="text-3xl font-bold mb-4">Fruit Page</h1>
            <div className="grid grid-cols-3 gap-4">
                {fruitData.map((fruit) => (
                    <div key={fruit.itemId} className="bg-gray-200 p-4 rounded">
                        <h2 className="text-xl font-semibold mb-2">{fruit.itemName}</h2>
                        <p className="text-gray-700">Price: {fruit.itemPrice}</p>
                        <p className="text-gray-700">Quantity: {fruit.itemQuantity}</p>
                        <button
                            className="bg-blue-500 text-white px-4 py-2 mt-4 rounded"
                            onClick={() => handleClick(fruit.itemId)}
                        >
                            Add to Cart
                        </button>
                        <Link to={'/cart'}><button
                            className="ml-5 bg-blue-500 text-white px-4 py-2 mt-4 rounded"

                        >
                            Go to Cart
                        </button>
                        </Link>
                    </div>
                ))}
            </div>
            {message ? (
                <div className='text-green-400'>
                    Item Added to cart
                </div>

            ) : (
                <div></div>
            )}

        </>
    );
}

export default FruitPage;
