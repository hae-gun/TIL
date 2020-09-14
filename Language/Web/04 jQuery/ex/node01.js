var http = require('http');
var url = require('url');
var fs = require('fs');
var port = 3000;
http.createServer(function(req,res){
    var q = url.parse(req.url,true);
    var fileName = "." + q.pathname;
//    res.writeHead(200,{"Content-Type":"text/plain"});
    console.log(fileName);
    fs.readFile(fileName,function(err,date){
        if(err){
            res.writeHead(404,{'Content-Type':'text/html'});
            return res.end("404 Not Found")
        }
        res.writeHead(200,{'Content-Type':'text/html'});
        res.write(data);
        return res.end();
    });
}).listen(port,function(){
    console.log('웹 서버 시작: %d',port);
});