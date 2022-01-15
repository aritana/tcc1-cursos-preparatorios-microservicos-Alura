import express from 'express';
import response from '../controllers/controllers.js'

let router = express.Router();

//route
const routerHome = router.get('/', response);

export default routerHome;