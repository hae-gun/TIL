var http = require('http');
var url = require('url');
var fs = require('fs');
var port = 3000;
http.createServer(function(req, res){
    var q = url.parse(req.url, true);
    //console.log(q);
    if(q.pathname =="/index"){
        var fileName = "./index.html";
    }else{
        var fileName = "." + q.pathname;
    }
    console.log(req);
    console.log(fileName);
    
    fs.readFile(fileName, function(err, data){
        if(err){
            res.writeHead(404, {'Content-Type': 'text/html'});
            return res.end("404 Not Found...");
        }
        res.writeHead(200, {'Content-Type': 'text/html'});
            res.write(data);
            return res.end();
        
    });
}).listen(port, function(){
    console.log('웹 서버 시작: %d', port);
});