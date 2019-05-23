const jwt = require('jsonwebtoken');
const {
    SHA256
} = require('crypto-js');

const message = '123456';
const hash = SHA256(message).toString();

var data = {
    password: SHA256('123456').toString(),
    name: 'kiril ha meleh'
};

var mySecret = 'my secret';

var token = jwt.sign(data, mySecret);
console.log('encoded', token);

var decoded = jwt.verify(token, mySecret);
console.log('decoded', decoded);