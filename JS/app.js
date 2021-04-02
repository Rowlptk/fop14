const myTag = document.querySelector('h1');
// console.log(myTag);
myTag.addEventListener('click', meroKaam);

function meroKaam() {
    // console.log('i am clicked!');
    myTag.textContent = 'Hello Madhur G!';
    myTag.style.color = 'red';
}