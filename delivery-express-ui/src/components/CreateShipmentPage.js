import React from 'react';
import ShipmentForm from './ShipmentForm';

function CreateShipmentPage({ onCreateShipment }) {
    return (
        <div>
            <h1>Create a New Shipment</h1>
            <ShipmentForm onCreateShipment={onCreateShipment} />
        </div>
    );
}

export default CreateShipmentPage;
