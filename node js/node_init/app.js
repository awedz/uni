const express = require("express");
const app = express();

let peopleArray=["aaa","bbb"];

app.get("/all",
    (reqest,response)=>{
        response.status(200);
        response.send(peopleArray);
    });
app.post("/all",
    (reqest,response)=>{
        peopleArray.push(reqest.body)
        response.status(201);
        response.send(peopleArray);
    });

app.listen(4900,() => {console.log("listening 4500")});