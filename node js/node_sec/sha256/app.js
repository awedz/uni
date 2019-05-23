const {
    SHA256
} = require('crypto-js');

const message = '123456';
const hash = SHA256(message).toString();

console.log(`message ${ message }`);
console.log(`hash ${ hash }`);
console.log(`hash len ${ hash.length }`);
console.log(`hash ${ SHA256( message ) }`);