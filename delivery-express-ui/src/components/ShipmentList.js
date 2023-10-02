import React from 'react';

function ShipmentList({ shipments }) {
    return (
        <div>
            <h2>Shipments</h2>
            <ul>
                {shipments.map((shipment) => (
                    <li key={shipment.trackingNumber}>
                        {/* Display shipment details */}
                        {/* ... */}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default ShipmentList;
