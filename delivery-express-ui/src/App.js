import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import HomePage from './HomePage';
import CreateShipmentPage from './CreateShipmentPage';
import UpdateStatusPage from './UpdateStatusPage';

function App() {
    return (
        <Router>
            <Switch>
                <Route path="/" exact component={HomePage} />
                <Route path="/create" component={CreateShipmentPage} />
                <Route path="/update" component={UpdateStatusPage} />
            </Switch>
        </Router>
    );
}

export default App;
