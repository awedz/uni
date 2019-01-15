var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);

app.get('/', function(req, res){
    res.sendFile(__dirname +'/index.html');
});
app.get('/chat.js', function(req, res){
    res.sendFile(__dirname +'/main.js');
});

http.listen(3000, function(){
    console.log('listening on *:3000');
});

io.on('connection', function(socket){
    socket.on('chat message', function(msg){
        io.emit('chat message', msg);
    });
});
function Connect(name)
{

};

function SendMessage(name,message)
{

};

function Disconnect(name)
{

};

// messageFormat{
//     conMsg
// }