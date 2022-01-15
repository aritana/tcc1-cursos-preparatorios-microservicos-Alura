const express = require('express')
const app = express()
const morgan = require('morgan')
const routerTeste = require('./routes/post')
const dotenv = require('dotenv')
dotenv.config() //para acessar .env
const mongoose = require('mongoose')

//db
mongoose.connect(process.env.MONGO_URI)
    .then(() => { console.log('DB Mongo Connected') })

mongoose.connection.on('error', err => {
    console.log(`DB Mongo Connection Error:  ${err.message}`);
})


//bring in routes
//const postRoutes = require('./routes/post')


/* const myOwnMiddleware = (req, res, next) => {
    console.log('middleware applied!!!');
    next();
} */

//middleware morgan

app.use(morgan("dev")); //middleware
//app.use(myOwnMiddleware); //middleware

app.use('/', routerTeste.routerTeste) //middleware, ao contrario de usar app.get como ntes


const port = process.env.PORT || 8085
app.listen(port, () => {
    console.log(`A Node Js API listening on port ${port}`);
})

//rodar, node app.js ou  npm run dev