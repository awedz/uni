var dal = require("./dal");
const dbName = 'carDB';
function connectToDb()
{
    dal.connect();
}

function initDB()
{
    var query = ' DROP DATABASE IF EXISTS carDB; CREATE DATABASE carDB;'
}

