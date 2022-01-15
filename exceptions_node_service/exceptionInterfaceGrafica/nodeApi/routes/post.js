const express = require('express')


const postController = require('../controllers/post')

const routerTeste = express.Router();

routerTeste.get('/', postController.getPosts);
//router.post('/post', postController.createPost);

module.exports = routerTeste;