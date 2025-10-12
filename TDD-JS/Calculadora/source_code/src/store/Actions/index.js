export const GET_FAVORITES = 'GET_FAVORITES';
export const Add_TO_FAVORITES = 'Add_TO_FAVORITES';
export const DEL_FROM_FAVORITES = 'DEL_FROM_FAVORITES';

export const RE_USER_STATE = 'RE_USER_STATE';


export function GETFavoriteState() {
  const action = {
      type: GET_FAVORITES
    }
  return action;
}


export function addToFavorit(item) {
    const action = {
      type: Add_TO_FAVORITES,
      payload:item
    }
    return action;
  }


  export function DelFromFavorit(item) {
    const action = {
      type: DEL_FROM_FAVORITES,
      payload:item
    }
    return action;
  }


  export function ReUserState(authState) {
    const action = {
        type: RE_USER_STATE,
        payload:authState
      }
    return action;
  }
  
