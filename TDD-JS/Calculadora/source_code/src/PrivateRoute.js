import React from 'react';
import { Route, Redirect  } from 'react-router-dom';


function PrivateRoute({ component: Component, Auth, Logout , ...rest }) {

    return (
    <Route {...rest} render={props =>
        Auth ? 
        <Component {...props} Logout={Logout}  /> 
        : <Redirect to="/LoginReigester" />
      }
     />
    );

}
export default PrivateRoute


