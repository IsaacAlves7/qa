import {  RE_USER_STATE  } from '../Actions';
  
  const initialState = {
      isAuthenticated:Boolean,
  }
  
  
  function Users(state = initialState, action) {
    switch(action.type) {
        case RE_USER_STATE:
            console.log('pay', action.payload)
            state.isAuthenticated = action.payload;
            return  state;  
      default:
        return state;
    }
  } 
  
  export default Users;