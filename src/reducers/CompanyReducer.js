
export function CompanyReducer(state, action) {
    switch(action.type){
        case 'INITIAL':
            return action.payload.map(company=> { return {
                id: company.id,
                key: company.name,
                text: company.name,
                value: company.name
            }});
        case 'ADD':
            return [...state, action.payload];
        case 'DELETE':
            return '';
        default:
            throw new Error();
    }
}