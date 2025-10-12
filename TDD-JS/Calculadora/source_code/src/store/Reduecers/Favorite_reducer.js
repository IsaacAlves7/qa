import { 
    GET_FAVORITES,
    Add_TO_FAVORITES,
    DEL_FROM_FAVORITES  } from '../Actions';
  
  const initialState = {
      isAuthenticated:Boolean,
      Favoritedata:[]
  }
  
  
  function Favorite(state = initialState, action) {
    switch(action.type) {
      case GET_FAVORITES:
        let FavData = JSON.parse(localStorage.getItem("Fav"));
        if(FavData){
          state.Favoritedata = FavData;
        }
        return state;
      // end
      case Add_TO_FAVORITES:
        let is_here = false;
        let pay = action.payload;
        for (let index = 0; index < state.Favoritedata.length; index++) {
        const element = state.Favoritedata[index];
          if(element === pay){
            is_here = true;
          }
        }
      
      if(is_here === false){
        let lState = state.Favoritedata;
        lState.push(action.payload);
        state.Favoritedata = lState;
        localStorage.setItem("Fav", JSON.stringify(lState)); 
      } else {
        console.log('false');
      }
  
        return state;
      // end
      case DEL_FROM_FAVORITES:
        let value = action.payload;
        let arr = state.Favoritedata;
        arr = arr.filter(item => item !== value);
        state.Favoritedata = arr;
        localStorage.setItem("Fav", JSON.stringify(arr));
        return state;
      // default   
      default:
        return state;
    }
  } 
  
  export default Favorite;