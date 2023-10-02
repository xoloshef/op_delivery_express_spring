import React, { useState } from 'react';

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

    const handleSubmit = (e) => {
        e.preventDefault();
        onCreateShipment(formData);
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
