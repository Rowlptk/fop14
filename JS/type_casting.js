let val;

// Number to String
let val1 = String(5);
console.log(val1);
console.log(typeof(val1));

let val2 = String(2+5);
console.log(val2);

val = val1 + val2;
console.log(val);

// Bool to String
val = String(true);

// Date to String
val = String(new Date());

// Array to String
val = String([2,3,4,5]);

// toString()
val = (5).toString();

// String to Number
val = Number('55');
val = Number(true);
val = Number(false);
val = Number(null);
val = Number('hello'); 
// NaN ==> Not a Number;
val = Number('55.3');
val = Number('55 3');

val = parseInt('100.345');
val = parseFloat('100.345');

const val3 = String(5);
const val4 = 6;
const sum = Number(val3 + val4);

console.log(sum);
console.log(typeof(sum));

let sum1 = '5' + 6 + 7; 
let sum2 = 5 + 6 + '7'; 

console.log(sum1, sum2);
// 513
// 117

// console.log(val)
// console.log(typeof(val));