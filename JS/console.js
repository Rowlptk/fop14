// Log to console
console.log('Hello World!');
console.log(123);
console.log(true);

let greetings = 'Hello';
console.log(greetings);

console.log([1, 2, 3, 4]);

console.log({a:1, b:2});

console.error('This is an error!');
console.warn('This is a warning!');
console.clear();

// This is a single line comment
/*
this 
is
a
multiline
comment */

// let, const, var

var name = 'John';
let age = 39;

name ='Smith';
age = 40;

console.log(name, age);

const pi = 3.1415;
console.log(pi);
// pi = 3.1234;

// Naming conventions
// letters, numbers, _, $
// cannot start with numbers

// multiword first name
// let first name = 'Ram';
// firstname ==> all lower
// firstName ==> camel
// first_name ==> underscore
// FirstName ==> pascal

// Data Types
// primitive
// String
let data = 'Hello';

// Number
data = 123;

// Boolean
data = false;

// Null
data = null;

console.log(data);
console.log(typeof(data));

// undefined
let car;
console.log(car);
console.log(typeof(car));


// derived type
// Array
const mixer = ["Hello", 'Hi', 123, 123.456, true, false, null, undefined];
console.log(mixer);
console.log(typeof(mixer))

// Object literals
const address = {
    city : 'Kathmandu',
    state: 'State no 3'
}

console.log(address);
console.log(typeof(address));

// Inbuilt objects
// Date
const today = new Date();
console.log(today);
console.log(typeof(today));

// functions
const hello = function() {
    alert('Hello');
}

console.log(hello);
console.log(typeof(hello));
console.log(hello());








