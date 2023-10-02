import React, { useState } from 'react';
import axios from 'axios'; // Импортируем axios

function ShipmentForm({ onCreateShipment }) {
    const [formData, setFormData] = useState({
        trackingNumber: '',
        senderAddress: '',
        destinationAddress: '',
        status: '',
        dateReceived: '',
        lastStatusDate: '',
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            // Отправка POST-запроса на сервер
            const response = await axios.post('http://localhost:8080/api/shipments', formData);

            // Обработка успешного ответа от сервера
            console.log('Shipment created:', response.data);

            // Очистка формы после создания отправления
            setFormData({
                trackingNumber: '',
                senderAddress: '',
                destinationAddress: '',
                status: '',
                dateReceived: '',
                lastStatusDate: '',
            });

            // Вызов функции onCreateShipment, если необходимо передать данные обратно в родительский компонент
            onCreateShipment(response.data); // response.data содержит данные, полученные от сервера
        } catch (error) {
            // Обработка ошибки при отправке запроса
            console.error('Error creating shipment:', error);
        }
    };

    return (
        <div>
            <h2>Create Shipment</h2>
            <form onSubmit={handleSubmit}>
                {/* Input fields for shipment details */}
                {/* ... */}
                <button type="submit">Create</button>
            </form>
        </div>
    );
}

export default ShipmentForm;
