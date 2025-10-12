import { combineReducers } from 'redux';

import Favorite from './Favorite_reducer';
import Users from './Users_reducer';

const rootReducer = combineReducers({
  Favorite,
  Users
})

export default rootReducer;