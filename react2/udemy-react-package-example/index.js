console.log("hello nodejs package");

const randomColor = require("randomcolor"); // npm i를 통해 받은 외부 모듈은 경로 없이 작성하면 알아서 가지고 옴

console.log(randomColor());

let color1 = randomColor();
let color2 = randomColor();
let color3 = randomColor();

console.log(color1);
console.log(color2);
console.log(color3);
