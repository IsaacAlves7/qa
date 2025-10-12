import React, { Component } from 'react';
import Repose from './repose';

import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { addToFavorit, DelFromFavorit, GETFavoriteState } from '../../store/Actions';




class Specific extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            user:[],
            is_Favorite:false
         };

        this.props.GETFavoriteState();

        const fetchUser = async (user) => {
        const api_call = await fetch(`https://api.github.com/users/${user}`);
        const data = await api_call.json();
        return {data}
        };

        fetchUser(props.match.params.login).then((res)=>{
            if(!res.data.message) {
            this.setState({ user: res.data });
            }
            console.log(res)
        })
         
    }


    async  componentDidMount(){
        console.log('spaecific',this.props.Favorite.Favoritedata);
        let data = this.props.Favorite.Favoritedata;
        let theUser = this.props.match.params.login;
        for (let index = 0; index < data.length; index++) {
          const element = data[index];
            if(element === theUser){
              this.setState({ is_Favorite: true })
            }
          }
     }
 

 
    AddToFave = () =>{
        this.props.addToFavorit( this.state.user.login);
        this.setState({ is_Favorite: true });
     }
  
    RemoveFromFave = () => {
        this.props.DelFromFavorit( this.state.user.login);
        this.setState({ is_Favorite: false });
     }




    Data(){
        if(this.state.user.length === 0){
          return (<i>there is no user found with this username</i>)
        } else {
         return (

         <center>
          <section className="Specific">
           <div className="main" id="main">
            <div className="container">
             <div className="row">
              <div className="col-lg-12 col-md-12">
                <div className="SUsersData">

                  { 
                    this.state.is_Favorite === false ?
                    <i onClick={this.AddToFave}  
                    className='fas fa-heart  NotFave'>          
                    </i> :
                    <i onClick={this.RemoveFromFave}  
                    className='fas fa-heart  Fave '>          
                    </i>  
                   }
                     <h4>Name : <i className="bl">
                         { this.state.user.name }
                     </i>
                     </h4>
                    <img src={this.state.user.avatar_url} alt="" />
                    <h4>followers : <i className="bl"> 
                    {this.state.user.followers} 
                    </i></h4> 
                    <h4>location : <i className="bl">
                         { this.state.user.location }
                    </i></h4>


                < Repose user={this.props.match.params.login}   />

               </div>
              </div>
             </div>
            </div>
           </div>
          </section>
         </center>

         )
        }
  
       }
  


    render() {
        return (
        <React.Fragment>
            { this.Data() }
        </React.Fragment>
        );
    }
    
}




Specific.propTypes = {
    addToFavorit: PropTypes.func.isRequired,
    DelFromFavorit: PropTypes.func.isRequired,
    GETFavoriteState: PropTypes.func.isRequired,
    Favorite: PropTypes.object.isRequired
  }
  
  const mapStateToProps = ( state ) => ({
    Favorite: state.Favorite
  });
  
  export default connect(mapStateToProps,{ 
    addToFavorit,DelFromFavorit,GETFavoriteState })(Specific);