//curso free udemy: https://www.udemy.com/course/node-js-api-tutorial/learn/lecture/13683886#overview

//const helpers = require('./helpers') //import one module

//let total = helpers.sum(5, 4)

const { sum, sum2, sum3 } = require('./helpers') //import one module


//Node Modules
//creatin a simple server with node
const http = require('http')
const server = http.createServer((req, res) => {

    res.end("hello world from node js updated!");
})

server.listen(3000);

let total = sum(5, 4);
console.log("Total ", total);

total = sum2(5, 4)
console.log("Total ", total);

total = sum3(5, 4)
console.log("Total ", total);

//2 instarlar nodemon para resestar nosso server sempre que atualizar
//npm init -> para criar um arquivo de package.json
// alterei script par dev: node app.js e entao posso rodar npm run dev, que o comando é executado