import React, { useContext } from 'react';
import { Dropdown } from 'semantic-ui-react';
import { CompanyContext } from '../context/CompanyContext';

const DropDownList = () => {
    
    const { state: companies } = useContext(CompanyContext);
    
    return (
        <Dropdown
        placeholder='Select Friend'
        fluid
        selection
        search
        options={companies}
      />
    );
};

export default DropDownList;