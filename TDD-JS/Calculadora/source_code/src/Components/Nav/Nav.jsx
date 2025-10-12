import React, { Component } from 'react';
import { Link , withRouter  } from 'react-router-dom';

class Nav extends Component {
    constructor(props) {
        
        super(props);
        this.state = { isAuthentication:false };
   
      }

    async componentDidMount() {
        await this.props.store.subscribe( ()=> {
        this.setState({ isAuthentication: this.props.store.getState()['Users']['isAuthenticated']})
        }) 
    }
    
    Logout = () => {
     this.props.Logout();
    }

    GoHome = () => {
     this.props.history.push({
          pathname: `/`,
     });
    }

    render() {
        return (
            <React.Fragment>
                <div className="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
                    <h5 onClick={this.GoHome} className="LoGo my-0 mr-md-auto font-weight-normal">React With Node</h5>
                    <nav className="my-2 my-md-0 mr-md-3">
                        { this.state.isAuthentication ?
                        <Link to="/Profile" className="p-2 text-dark">
                        <i className='fas fa-user'> </i> Profile
                        </Link>                        
                        :'' }
                        <Link to="/Favorite" className="p-2 text-dark">
                         <i className='fas fa-heart'> </i> Favorites
                        </Link> 
                    </nav>
                    { this.state.isAuthentication ?
                     <button  className="btn btn-outline-danger" onClick={this.Logout} >Logout</button>:
                    <Link to="/LoginReigester" className="p-2 text-dark">
                    <button  className="btn btn-outline-primary" >Sign up</button>
                    </Link> 
                    }
                </div>
            </React.Fragment>
        );
    }
}

export default withRouter(Nav);
