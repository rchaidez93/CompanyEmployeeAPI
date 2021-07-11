import React from 'react';
import './App.css';
import { Header, Container } from 'semantic-ui-react'
import DropDownList from './components/DropDown';
import Cards from './components/Cards';
import AddCompany from './components/AddCompany';
import {CompanyProvider } from './context/CompanyContext';

function App() {

  return (
    <div className="App">
      <Container>
        <CompanyProvider>
          <Header size="tiny" as="h2" textAlign="justified" block={true}>
            <div className="companies-header">
              <div className="companies-text">Companies</div>
              <AddCompany />    
            </div>
          </Header>
        
        
          <div display="flex">
          <DropDownList />
          </div>
        </CompanyProvider>
        <Header size="tiny" as="h2" textAlign="justified" block={true}>
          <div className="companies-header">
            <div className="companies-text">
              Employees
            </div>
            
          </div>
        </Header>
        <Container>
          <Cards />
        </Container>
      </Container>
    </div>
  );
}

export default App;
