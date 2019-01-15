var db_con = require('mysql');
let connection;

function connect()
{
    let connectionConfig = {
        "host": "localhost",
        "user": "kiril",
        "password":"1q2w3e4rasd",
    }
    try
    {
        connection = db_con.createConnection(connectionConfig);
    }
    catch(err)
    {
        console.log(err)
    }
}

function query(query,secFallback,failCallback)
{
    let callBackFromQuery = (err,result) => {err ? failCallback(err) : secFallback(result)};
    connection.query(query,callBackFromQuery);
    connection.end();
}


module.exports = {
    "query" : query,
    "connect": connect
}