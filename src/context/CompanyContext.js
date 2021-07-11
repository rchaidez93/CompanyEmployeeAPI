import axios from 'axios';
import React, { createContext, useEffect, useReducer } from 'react';
import { CompanyReducer } from '../reducers/CompanyReducer';

const CompanyContext = createContext();
const initialCompaniesState = [];

const CompanyProvider = ({children}) => {
    const [state, dispatch] = useReducer(CompanyReducer, initialCompaniesState);

    useEffect(() => {
        axios.get('api/companies/get')
        .then((res) => dispatch({type:'INITIAL', payload: res.data}));
    },[]);

    return (
        <CompanyContext.Provider value={{state, dispatch}}>
            {children}
        </CompanyContext.Provider>
    );
}

export {CompanyContext, CompanyProvider};