//curso free udemy: https://www.udemy.com/course/node-js-api-tutorial/learn/lecture/13683886#overview
//npm express: npm i express


const express = require('express')
const app = express()

app.get('/', (req, res) => {
    res.send('Hello World Express')
})

app.listen(3000)