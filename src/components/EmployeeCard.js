import React from 'react';
import { Card, Icon, Image } from 'semantic-ui-react'

const EmployeeCard = () => {
    return (
        <Card raised>
            <Image src={'https://semantic-ui.com/images/avatar/large/chris.jpg'} wrapped ui={false} />
            <Card.Content>
            <Card.Header>Matthew</Card.Header>
            <Card.Meta>
                <span className='date'>Joined in 2015</span>
            </Card.Meta>
            <Card.Description>
                Matthew is a musician living in Nashville.
            </Card.Description>
            </Card.Content>
            <Card.Content extra>
            <a href="/#">
                <Icon name='user' />
                22 Friends
            </a>
            </Card.Content>
        </Card>
    );
};

export default EmployeeCard;