import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { addToFavorit, DelFromFavorit, GETFavoriteState } from '../../store/Actions';


class Favorite extends Component {

    constructor(props){
     super(props);
     this.state = {
       users:[]
     }
     this.props.GETFavoriteState();
      console.log('store2', props)
     this.data();
    }

    async data(){
      console.log('store2', this.props)
      
     let data = await this.props.Favorite.Favoritedata;
      let BigDATA = [];
      for (let index = 0; index < data.length; index++) {
      
      const user = data[index];
    
      const fetchUsers = async (user) => {
        const api_call = await fetch(`https://api.github.com/users/${user}`);
        const data = await api_call.json();
       return {data}
      };

       fetchUsers(user).then((res)=>{
         if(!res.data.message) {
          res.data.is_User_in_Fafovirte = true;
          BigDATA.push(res.data);
          this.setState({ users: BigDATA })
         }
      })
      }
   
  }

    RemoveFromFave (user) {
     console.log('user', user);
      this.props.DelFromFavorit( user);
      let array = this.state.users;
      let newArr = [];
      for (let index = 0; index < array.length; index++) {
        const el = array[index];
        if(el.login === user){
          el.is_User_in_Fafovirte = false;
        }
        newArr.push(el);
      }
      this.setState({ users: newArr })
    }
    
    ReAddToFave (user) {
      console.log('user', user);
      this.props.addToFavorit( user );

     let array = this.state.users;
     let newArr = [];
      for (let index = 0; index < array.length; index++) {
        const el = array[index];
        if(el.login === user){
          el.is_User_in_Fafovirte = true;
        }
        newArr.push(el);
      }
      this.setState({ users: newArr })
    }

    GoFetchOneUser(data){
      console.log('worked',data);
      this.props.history.push({
         pathname:`/Specific/${data}`,
    });     
    }
 
    render() {
        return (
          <React.Fragment>
          
          
          {/* <div className='main'>
              <div className='UsersData'>
              { this.state.users.map( user => (
                
                <div   
                  key={user.id} 
                  className='loop'
                  >
                  <i onClick={()=>{
                     this.GoFetchOneUser(user.login);}} 
                     key={user.id} >
                  <img src={user.avatar_url} alt=''/>            
                  <h6>Name : {user.login} </h6>
                  </i>
                  <div className='clear'></div>
                  { user.is_User_in_Fafovirte ?
                  <i 
                  onClick={()=>{ this.RemoveFromFave(user.login) }}
                  className="fas fa-heart dss Fave ">
                  </i>
                   :
                   <i 
                   onClick={()=>{ this.ReAddToFave(user.login) }}
                   className="fas fa-heart dss NotFaveS ">
                  </i>
                   }

                </div>
              ) ) }
              </div>
          </div>

 */}




<main role="main">
 <div className="album py-5 bg-light">
  <div className="container">
    <div className="row">

    { this.state.users.map( user => (

        <div key={user.id}  className="col-md-4">
          <div key={user.id}  className="card mb-4 shadow-sm">
            <img 
             className="bd-placeholder-img card-img-top"
             width="100%" height="225" 
             src={user.avatar_url}  alt='' />
            <div className="card-body">
              <p className="card-text text-center">
              Name :  {user.login} 
              </p>
              <div className="d-flex justify-content-between align-items-center">
                <div className="btn-group">
                  <button 
                  type="button" 
                  className="btn btn-sm btn-outline-secondary"
                  onClick={()=>{
                    this.GoFetchOneUser(user.login);}} 
                    key={user.id}
                  >View</button>
                </div>

                { user.is_User_in_Fafovirte ?
                  <button 
                    onClick={()=>{ this.RemoveFromFave(user.login) }}
                    type="button" 
                    className="btn btn-sm">
                    <i className="fas fa-heart Fave"></i>
                  </button>
                   :
                  <button 
                   onClick={()=>{ this.ReAddToFave(user.login) }}
                   type="button" 
                   className="btn btn-sm">
                   <i className="fas fa-heart NotFave"></i>
                  </button>
                }

             </div>
            </div>
          </div>
        </div>
       
       ) ) }

     </div>
   </div>
 </div>

</main>









          </React.Fragment>
        );
    }
}




Favorite.propTypes = {
  addToFavorit: PropTypes.func.isRequired,
  DelFromFavorit: PropTypes.func.isRequired,
  GETFavoriteState: PropTypes.func.isRequired,
  Favorite: PropTypes.object.isRequired
}

const mapStateToProps = ( state ) => ({
  Favorite: state.Favorite
});

export default connect(mapStateToProps,{ addToFavorit,DelFromFavorit,GETFavoriteState })(Favorite);




