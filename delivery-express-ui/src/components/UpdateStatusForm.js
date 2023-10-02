import React, { useState } from 'react';

function UpdateStatusForm({ onUpdateStatus }) {
    const [newStatus, setNewStatus] = useState('');

    const handleChange = (e) => {
        setNewStatus(e.target.value);
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        onUpdateStatus(newStatus);
    };

    return (
        <div>
            <h2>Update Shipment Status</h2>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="New Status"
                    value={newStatus}
                    onChange={handleChange}
                />
                <button type="submit">Update</button>
            </form>
        </div>
    );
}

export default UpdateStatusForm;
