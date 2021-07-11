import axios from 'axios';
import React, { useContext, useState } from 'react';
import { Button, Input } from 'semantic-ui-react'
import '../App.css';
import { CompanyContext } from '../context/CompanyContext';

const AddCompany = () => {
    const {dispatch} = useContext(CompanyContext);
    const [companyName, setCompanyName] = useState("");

    const handleAddCompany = () => {
        axios.post(`api/companies/add?name=${companyName}`)
        .then(() => dispatch({
            type: 'ADD', 
            payload: {id: 300, key: companyName, text: companyName, value: companyName}
        }));
    };

    return (
        <div className="add-company-button">
            <Input size="mini" placeholder='Company Name...' onChange={(e) => setCompanyName(e.target.value)} />
            <Button size="tiny" content='Add' onClick={() => handleAddCompany()} />            
        </div>
        
    );
};

export default AddCompany;