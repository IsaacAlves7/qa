import React, { Component } from 'react';

class repose extends Component {
    constructor(props) {
        super(props);
        this.state = { 
             repos:[]
        };
       
        const FetchRepose = async (user) => {
            const api_call = await fetch(`https://api.github.com/users/${user}/repos`);
            const data = await api_call.json();
           return {data}
          };

           FetchRepose(props.user).then((res)=>{
            if(res.data.length > 0 & !res.data.message) {  

            let items = [];
            for(let i = 0; i < 5; i++) {
             items.push(res.data[i]);
             if(i===4){
                 //console.log(items);
                 this.setState({ repos: items });
                }
            }
          }

     })
    
    }

 

    render() {
     return (
        <React.Fragment>
         <div>
            <h3>here Last 5 repo</h3>
            <div className="lastfiveRepo">
                { this.state.repos.map( res => (                                          
                <div key={res.id} >
                <a key={res.id} href={res.html_url} > 
                    {res.name} 
                </a>               
                </div>
                ))}
            </div>
         </div>           
        </React.Fragment>        
      );
    }
}

export default repose;