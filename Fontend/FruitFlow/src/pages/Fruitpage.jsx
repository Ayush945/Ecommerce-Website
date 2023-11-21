import React, { useEffect, useState } from 'react';
import baseUrl from './CorsConfigure/BaseUrl';
import axios from 'axios';

import 'tailwindcss/tailwind.css'; // Import the tailwind CSS file

function FruitPage() {
    const [fruitData, setFruitData] = useState([]);
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
                        >
                            Add to Cart
                        </button>
                    </div>
                ))}
            </div>

        </>
    );
}

export default FruitPage;
