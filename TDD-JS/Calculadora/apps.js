var http = require("http");

http.createServer(function(requisicao,resposta){
    resposta.end("<h1>Bem vindo ao meu site!</h1><h4>guiadoprogramador.com</h4>");
}).listen(3000);

console.log("Meu servidor está rodando!");