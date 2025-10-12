const mysql = require('mysql');
const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const cors = require("cors");

const Users = require('./routes/users');

const path = require('path');

app.use(cors({ origin: "*" }));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

const con = mysql.createConnection({ 
    host: "127.0.0.1",
    user: "root",
   // password: "5747723",
    database: "app_react_node"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});


/// this function here to allow check visite to this path form the server
app.use('/images', express.static(path.join(__dirname,'images')));
app.use('/', express.static(path.join(__dirname, 'react')));


app.use('/api/users', Users);

// const port = 4000;
const port = process.env.PORT || 4000;

app.listen(port, () => console.log(`Example app listening on port ${port}!`)); 