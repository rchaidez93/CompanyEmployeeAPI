import React from 'react';
import { Card } from 'semantic-ui-react'
import EmployeeCard from './EmployeeCard';

const Cards = () => {
    return (
        <Card.Group centered>
            {[1,2,3,4,5,6,7,8,9].map(e=> (
                <EmployeeCard key={e}/>
            ))}
        </Card.Group>
    );
};

export default Cards;