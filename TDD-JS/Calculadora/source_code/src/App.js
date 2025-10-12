import React, { Component } from 'react'
import './App.css';
import Nav from './Components/Nav/Nav'; 
import Main from './Components/GitHup/Main';
import Data from './Components/GitHup/Data';
import Specific from './Components/GitHup/Specific';
import Favorite from './Components/Favorite/Favorite';
import LoginReigester from './Components/LoginReigester/MainPage';
import Profile from './Components/Profile/Profile';

// action
import { ReUserState } from './store/Actions';

// Protected Route
import PrivateRoute from './PrivateRoute';


import {  BrowserRouter as Router, Route } from 'react-router-dom';

import { Provider } from 'react-redux';

// store 
import { createStore } from 'redux';
import   rootReducer from './store/Reduecers';
// end of store 


class App extends Component {
  constructor(props) {
    super(props);
    this.state = { isAuthentication:false };

    // create store 
    this.store = createStore(
      rootReducer,
      window.__REDUX_DEVTOOLS_EXTENSION__ && 
      window.__REDUX_DEVTOOLS_EXTENSION__()
      );

  }

  // check if user is auth
  async componentDidMount() {
    
    if( localStorage.getItem('token') ){
     // console.log('auth');
     this.store.dispatch(ReUserState(true));
     this.setState({ isAuthentication: true })

    } else {
     // console.log('notauth')
     this.store.dispatch(ReUserState(false));
     this.setState({ isAuthentication: false })
     }

    await this.store.subscribe( ()=> {
   //  console.log('app.js',this.store.getState()['Users']['isAuthenticated']); 
     this.setState({ isAuthentication: this.store.getState()['Users']['isAuthenticated']})
    })    
  }


  // log out 
  logout = () => {
     console.log('logout')
     localStorage.removeItem("token");
     this.store.dispatch(ReUserState(false));
     this.setState({auth: false })
  }

  render() {
    return (
       <React.Fragment>
        <Provider store={this.store}  > 
          <Router >
            <Nav  store={this.store} Logout={this.logout} />
            <Route exact  path="/"  component={ Main }   />
            <Route exact  path="/Data/:id" component={ Data } />
            <Route exact  path="/Specific/:login" component={ Specific }/>
            <Route exact  path="/Favorite" component={ Favorite } />
            <Route exact  path="/LoginReigester" component={ LoginReigester } />
            <PrivateRoute exact path="/Profile" 
                          Logout={this.logout}
                          Auth={this.state.isAuthentication}  
                          component={ Profile } 
                          />
          </Router> 
        </Provider>
       </React.Fragment>
      );
  }
}

export default App;
