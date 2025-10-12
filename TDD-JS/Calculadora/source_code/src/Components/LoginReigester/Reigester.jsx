import React, { Component } from 'react';
import axios from 'axios';

class Reigester extends Component {
    constructor(props) {
        super(props);
        this.state = {  
            name:'',           
            email:'',
            password:'',
            erros:''  
        };
    }


    onChange = (e) =>{
        this.setState({ [e.target.name]: e.target.value });
       } 

       
    Reigester = (e) => {
        e.preventDefault();
        this.setState({ [e.target.name]: e.target.value });
        const Data = {
          name: this.state.name,
          password: this.state.password,
          email: this.state.email
        };
        axios.post(`${this.props.URL_backend}/Register`, { Data })
        .then(res => {
          console.log(res);
          console.log(res.data.message);
          const err  = res.data.message;
          this.setState({
            erros: err
          });
          if(!err){
            alert("successfully registered");
            const em = this.state.email;
            const pas = this.state.password;
            this.setState({
              email: em,
              password:pas
            })
          }
        })
        .catch((err) => {console.log(err)} )
     
      }

    render() {
        return (
           <React.Fragment>
            { this.state.erros ?
             <i className="alert alert-danger" role="alert">
             {this.state.erros}</i> : '' 
            }
                <hr></hr>                                                                   
            <form className="form-Reigester">
                <h4 className="h3 mb-3 font-weight-normal grey">Reigester</h4>
                <input 
                 value={this.state.name}
                 onChange={this.onChange} 
                 name="name" 
                 type="text" 
                 className="form-control" 
                 placeholder="Name" />
               
                <input value={this.state.email}
                onChange={this.onChange} 
                type="email"
                name="email" 
                className="form-control" 
                placeholder="Email address"
                />
               
                <input value={this.state.password}
                onChange={this.onChange} 
                type="password" 
                name="password"
                className="form-control" 
                placeholder="Password"
                />
                <button  onClick={ this.Reigester }  className="btn btn-md btn-success btn-block" type="submit">Reigester</button>
            </form>
           </React.Fragment>
            );
    }
}

export default Reigester;