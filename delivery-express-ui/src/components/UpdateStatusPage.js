import React from 'react';
import UpdateStatusForm from './UpdateStatusForm';

function UpdateStatusPage({ onUpdateStatus }) {
    return (
        <div>
            <h1>Update Shipment Status</h1>
            <UpdateStatusForm onUpdateStatus={onUpdateStatus} />
        </div>
    );
}

export default UpdateStatusPage;
