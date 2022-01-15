import express from 'express';
import morgan from 'morgan'
import dotEnv from 'dotenv'
import mongoose from 'mongoose'
import routerHome from './routes/routes.js'

const app = express()
dotEnv.config() //acessar .env

//mongo
try {
    await mongoose.connect(process.env.MONGO_URI)
    console.log('DB Mongo Connected')

} catch (error) {
    console.log(error)
}

app.use(morgan("dev")); //middleware

//utilizar middleware para acessar rotas
app.use('/', routerHome);

/* app.get('/', (req, res) => {
    res.send('Hello World')
}) */

const port = process.env.PORT || 8085
const server = app.listen(port, () => {
    const host = server.address().address;
    const portUsed = server.address().port;
    console.log(`Listening at http://${host}:${portUsed}`);
})