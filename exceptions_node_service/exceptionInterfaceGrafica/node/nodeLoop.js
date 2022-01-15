const fs = require('fs') //file system

const fileName = "target.txt"

// const data = fs.readFileSync(fileName) //executa antes de seguir a executar a próxima linha
// console.log(data.toString()); //blocking coed


const errorHandler = err => console.log(err)
const dataHandler = data => console.log(data.toString())

//fs.watch(fileName, () => console.log(`File Changed`));

fs.readFile(fileName, (err, data) => { //control +k +c para comentar, e +u para descomentar
    if (err) {
        errorHandler(err)
    }
    dataHandler(data)
})

console.log('Node js Async Programming...?');