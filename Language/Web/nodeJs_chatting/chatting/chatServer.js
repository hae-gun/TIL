var express = require('express');
var app = express();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var url = require('url');


var name = "";
app.get('/', function(req, res){
   var q = url.parse(req.url, true).query;
    name = q.name;
    console.log(name);
   res.sendFile(__dirname+'/client.html');
    
});

io.on('connection', function(socket){
   console.log('user connected: ', socket.id);
   io.to(socket.id).emit('change name', name);
    
    socket.on('disconnect', function(){
       console.log("user disconnected: ", socket.id); 
    });
    
    socket.on('send message', function(nick, text){
        var hackText = escapeHtml(text);
        console.log(hackText);
        var msg = nick + ' : ' + hackText;
        console.log(msg);
        io.emit('receive message', msg);
    });
    
});
//escapte 처리: xss 공격 대응
var entityMap = { '&': '&amp;', '<': '&lt;', '>': '&gt;', '"': '&quot;', "'": '&#39;', '/': '&#x2F;', '`': '&#x60;', '=': '&#x3D;' }; 

function escapeHtml (string) { return String(string).replace(/[&<>"'`=\/]/g, function (s) { return entityMap[s]; }); }


http.listen(3000, function(){
    console.log('server on!');
});