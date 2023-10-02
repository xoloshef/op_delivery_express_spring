import React from 'react';
import ShipmentList from './ShipmentList';

function HomePage({ shipments }) {
    return (
        <div>
            <h1>Welcome to Delivery Express</h1>
            <ShipmentList shipments={shipments} />
        </div>
    );
}

export default HomePage;