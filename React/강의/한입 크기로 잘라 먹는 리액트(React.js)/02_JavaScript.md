# JavaScript
## JavaScript 기본
### JavaScrpit 소개
자바스크립트는 자바스크립트 엔진에 의해 실행됨 (자바스크립트 실행 환경, 자바스크립트의 Runtime)  
이 엔진 중 가장 대표적인 것 : Google Chrome의 V8 엔진  
자바스크립트 실습 환경 : https://codesandbox.io/  
<br>  

### 변수와 상수
변수 : 프로그램 실행 도중 계속해서 바뀌는 값을 저장하기 위한 공간
```javascript
// 변수 선언
let age = 20;
```
+ 변수명에는 기호 사용 불가능 (_, $ 제외)
+ 변수명은 숫자로 시작 불가능
+ 변수명에는 예약어 사용 불가능  

※ 변수는 let이 아니라 var를 사용해서 선언할 수도 있음 하지만 var는 변수를 중복해서 선언하는 것을 허용하기 때문에 프로그래머가 오류를 발생시킬 수 있음 (let의 경우 변수를 중복해서 선언하는 것을 비허용)

상수 : 변하지 않는 값을 저장하기 위한 공간 (read only) 따라서 상수의 경우 선언과 동시에 초기화가 이루어져야 함
```javascript
// 상수 선언
const age = 20;
```
<br>

### 자료형과 형 변환
자료형 : 값을 성질에 따라 분류한 것  
Primitive Data Type : 원시 타입(내장형 타입, 기본형 타입), 한 번에 하나의 값만 가질 수 있으며 하나의 고정된 저장 공간을 이용함 
+ Number : 자바스크립트는 숫자라면 모두 숫자형으로 구분 (정수와 실수의 구분 X)  
숫자 타입에는 Infinity(무한대), -Infinity(음의 무한대), NaN(수학적 연산의 실패)도 포함됨
+ String : "", '', ``로 문자열을 감싼 후 값을 저장  
``로 감싼 문자열의 경우 템플릿 리터럴을 사용할 수 있음  
※ 템플릿 리터럴 : 문자열 중간에 ${}를 이용해 변수 값을 넣는 것   

    ```javascript
    let age = 20;

    let introduce `저는 ${age}살 입니다`;
    ```
+ Boolean : 참/거짓만을 저장하는 자료형
+ Undefined : 변수에 아무런 값을 할당하지 않은 경우 자동으로 할당받는 값
+ Null : 의도적으로 아무 값도 담지 않고 있다는 것을 나타낼 때 사용

Non-Primitive Data Type : 비원시 타입, 한 번에 여러 개의 값을 가질 수 있으며 여러 개의 고정되지 않은 동적 공간을 사용함
+ Object
+ Array
+ Function  
<br>

형변환 : 자바스크립트 엔진은 서로 다른 자료형 간의 연산을 수행할 때 적절하게 자료형을 바꾸어 연산해 주는 기능을 가지고 있음  
+ 묵시적 형변환
+ 명시적 형변환
    ```javascript
    number = "22";
    parseInt(number); // 명시적 형변환
    ```
<br>

### 연산자
+ 대입 연산자 : 변수에 값을 넣는 연산자 (=)  
+ 산술 연산자 : 사칙연산 가능 (+, -, *, /, %)
+ 연결 연산자 : 두 개 이상의 문자열을 연결하는 연산자 (+)  
문자열과 숫자의 + 연산의 경우 산술 연산이 아닌 연결 연산이 수행됨
+ 복합 연산자 : 산술 연산과 대입 연산을 한 번에 수행 (+=, -=, *=, /=)
+ 증감 연산자 : 값을 증가/감소시키는 연산자로 숫자형에만 사용 가능 (++, --)
+ 논리 연산자 : boolean 자료형을 제어하는 연산자 (!, &&, ||)
+ 비교 연산자 : 두 개의 값을 비교하는 연산자 (==, !=, <=, >=, <, >, ===, !==)  
※ 자바스크립트의 경우 ==/!=을 사용하면 자료형이 아닌 값만 비교하기 때문에 1과 "1"을 비교할 경우 true가 출력됨 따라서 자료형까지 비교하고 싶은 경우 ===/!==을 사용함
+ typeof 연산자 : 자바스크립트는 동적 타입 언어이기 때문에 변수에 값을 할당할 때 자료형에 구애받지 않아 유연하지만, 이로 인해 오류 발생 가능 따라서 오류 발생을 줄이기 위해 typeof 연산자를 이용하여 타입 확인
+ null 병합 연산자 : 양쪽의 피연산자 중 null이나 undefine이 아닌 값을 선택함 따라서 값이 확정되어 있는 변수를 찾는 경우에도 사용 가능 (??)

    ```javascript
    let a;
    a = a ?? 10; // a의 값은 10이 됨
    ```
<br>

### 조건문
조건문 : 어떤 연산의 참, 거짓에 따라 다른 명령을 수행
+ if/else if/else
+ switch : 체이닝되는 조건이 많은 경우 사용  
<br>

### 함수
함수 : 중복되는 동일한 코드를 묶어 효율적으로 사용하기 위한 것으로 function 키워드를 사용하여 선언
```javascript
function test(a, b){
    area = a * b;
    return area;
} // 함수 선언식, 함수 선언 방식의 함수 생성

test(); // 함수 호출
```
지역변수 : 함수 내부에서 선언된 변수로 해당 함수 내에서만 접근 가능  
전역변수 : 함수 외부에서 선언된 변수로 어디에서나 접근 가능  
<br> 

### 함수 표현식
함수 표현식 : 함수도 값이기 때문에 변수 또는 상수에 담아 사용 가능 이를 함수 표현식이라고 함  
함수를 값에 담는 경우에는 함수의 이름을 지정하지 않아도 됨 (무명 함수)
```javascript
let hello = function() {
    return "안녕하세요";
}; 

console.log(hello); // 함수가 출력됨
console.log(hello()); // 문자열이 출력됨
```

함수 선언식과 함수 표현식의 차이점  
호이스팅 : 함수 선언식으로 만들어진 함수의 경우 프로그램 실행 전 코드의 최상단으로 끌어올려짐  
함수 표현식 함수의 경우 호이스팅이 일어나지 않기 때문에 선언 전 사용하면 오류 발생 (직접적으로 선언 전에는 접근 불가능)  
<br> 

### 화살표 함수
화살표 함수 : 함수 표현식을 더 쉽게 사용하는 방법으로 function 키워드 대신 =>를 사용
```javascript
let hello = () => {
    return "안녕하세요";
}; 

// 구현부에서 리턴하는 값만 하나 존재하는 경우 아래처럼 사용 가능 
let hello2 = () => "안녕하세요"; 
```
<br>

### 콜백 함수
콜백 함수 : 다른 함수에 매개변수로 함수를 넘겨 주는 것으로 유연한 동작을 할 수 있게 함  
<br>

### 객체
객체 생성
+ 객체 생성자를 이용하여 생성  

    ```javascript
    let person = new Object();
    ```
+ 객체 리터럴 방식 : 중괄호를 통해 객체 생성  
키와 값의 쌍으로 저장되며 이를 프로퍼티(객체 프로퍼티)라고 함

    ```javascript
    let person = {
        key: "value", 
        key1: "value2"
    };
    ```
객체 프로퍼티 : 객체의 프로퍼티의 value에는 어떤 자료형이 위치해도 상관없음  
하지만 key의 경우 문자열로만 이루어져야 하며, 쌍따옴표는 사용하지 않음  
키가 중복되는 경우 오류가 발생하지는 않으나, 가장 뒤에 있는 키를 기준으로 값을 가지며, 앞의 동일한 키의 값은 무시됨  

객체 접근 방법
+ 점 표기법 : 객체의 값에 접근할 때 .을 이용하여 접근

    ```javascript
    let person = {
        name: "이름", 
        age: 27
    };

    console.log(person.name);
    ```
+ 괄호 표기법 : 배열처럼 괄호를 사용하여 접근  
괄호 표기법을 사용하는 경우에는 반드시 키를 문자열 형태로 입력하여야 함 따옴표를 빼고 사용하는 경우 변수로 인식하기 때문에 에러 발생  
동적으로 접근하는 경우 유용

    ```javascript
    let person = {
        name: "이름", 
        age: 27
    };

    console.log(person["name"]);
    ```

객체 생성 이후 프로퍼티 추가/수정/삭제 
```javascript
let person = {
    name: "이름", 
    age: 27
};

// 추가
person.location = "한국";
person["gender"] = "F";

// 수정
person.name = "이름123";

// 삭제
// delete 사용 : 해당 객체와 프로퍼티 간의 연결만 끊기 때문에 메모리는 계속 사용됨
delete person.age;
delete person["age"];

// 삭제와 동일한 효과를 내면서 메모리에서도 제거하는 방법
person.age = null;
```
※ 객체를 const로 선언한 후 프로퍼티를 추가해도 에러가 발생하지 않고 추가됨  
→ 프로퍼티를 추가, 수정하는 행위는 해당 상수 자체를 수정하는 행위가 아니라 해당 상수가 갖는 오브젝트를 수정하는 행위이기 때문  
해당 상수 자체를 수정하는 행위란 대입 연산자를 이용하여 새로운 객체를 할당하는 것을 의미함 (해당 상수 자체에 대입 연산자를 사용하지 않는다면 프로퍼티 추가/수정/삭제 가능)  

메서드 : 객체 안에 있는 함수인 프로퍼티  
멤버 : 객체 안에 있는 함수가 아닌 프로퍼티  

this : 메소드에서 객체 자기 자신을 가리키는 명령어  

in 연산자 : 객체에 해당 프로퍼티가 존재하는지 확인
```javascript
let person = {
    name: "이름", 
    age: 27
};

console.log(`name : ${"name" in person}`);
```
<br>  

### 배열
배열 : 순서 있는 요소들의 집합으로 모든 자료형을 넣을 수 있음  
배열 생성
+ 배열 생성자를 이용하여 생성  

    ```javascript
    let arr = new Array();
    ```
+ 배열 리터럴 방식 : 대괄호를 통해 배열 생성  

    ```javascript
    let arr = [1, "2", true, {}];
    ```
배열은 키가 없기 때문에 인덱스(위치한 순서)로 값에 접근함  

배열에 값 추가
```javascript
let arr = [1, "2", true, {}];

arr.push(6); // 배열의 가장 마지막에 값 추가
```

배열의 길이 확인 : arr.length  
<br>

### 반복문
반복문 : 특정 명령을 반복해서 실행하는 경우 사용
+ for(초기식; 조건식; 증감식)  
+ while

Object.keys(객체) : 해당 객체의 키를 배열로 반환해주는 메소드
Object.values(객체) : 해당 객체의 값을 배열로 반환해주는 메소드  
<br>

### 배열 내장 함수
내장 함수 : 배열의 메소드와 같은 의미
+ forEach : 배열을 순회하는 내장함수

    ```javascript
    const arr = [1, 2, 3, 4];
    
    arr.forEach((elm) => console.log(elm)); // 콜백 함수

    arr.forEach(function (elm){
        console.log(elm);
    }); // 위와 같은 의미
    ```
+ map : 원본 배열의 모든 요소를 순회하며 리턴된 값을 따로 배열로 추려내 리턴

    ```javascript
    const arr = [1, 2, 3, 4];
    
    arr.map((elm) => {
        return elm * 2;
    });
    ```
+ includes : 주어진 배열에서 전달받은 인자와 일치하는 값이 있는지를 확인하고 boolean 값을 반환함  
만약 동일한 값이지만 타입이 다른 경우에는 false를 반환 (=== 연산 사용)

    ```javascript
    const arr = [1, 2, 3, 4];
    
    console.log(arr.includes(2));
    ```
+ indexOf : 주어진 배열에 전달받은 인지와 일치하는 값이 있다면 몇 번째에 위치하는지 확인 (인덱스를 반환)  
만약 주어진 배열에 전달받은 인자와 같은 값이 존재하지 않는 경우에는 -1을 반환

    ```javascript
    const arr = [1, 2, 3, 4];
    
    console.log(arr.indexOf(2));
    ```
+ findIndex : 객체 배열에서 원하는 속성을 갖는 배열의 요소의 인덱스 반환  
콜백 함수를 전달해 해당 콜백 함수가 true를 반환하는 첫 번째 요소를 반환 (일치하는 요소가 두 개 이상인 경우에는 앞에 있는 부분만 반환됨)

    ```javascript
    const arr = [
        {color: "red"},
        {color: "black"},
        {color: "blue"},
        {color: "green"}
    ];
    
    console.log(arr.findIndex((elm) => elm.color === "green"));
    ```
+ find : 조건에 일치하는 요소를 반환  

    ```javascript
    const arr = [
        {color: "red"},
        {color: "black"},
        {color: "blue"},
        {color: "green"}
    ];
    
    console.log(arr.find((elm) => elm.color === "green"));
    ```
+ filter : 배열 필터링, 전달한 콜백 함수가 true를 반환하는 모든 요소를 배열로 반환

    ```javascript
    const arr = [
        {num: 1, color: "red"},
        {num: 2, color: "black"},
        {num: 3, color: "blue"},
        {num: 4, color: "green"},
        {num: 5, color: "blue"}
    ];
    
    console.log(arr.filter((elm)=>elm.color === 'blue'));
    ```
+ slice : 배열을 매개변수로 넘겨받은 인덱스 기준으로 자르며 넘겨받은 매개변수가 없는 경우 배열을 그대로 반환  
end에 명시된 인덱스 -1까지만 반환함  

    ```javascript
    const arr = [
        {num: 1, color: "red"},
        {num: 2, color: "black"},
        {num: 3, color: "blue"},
        {num: 4, color: "green"},
        {num: 5, color: "blue"}
    ];
    
    console.log(arr.slice(begin, end));
    ```
+ concat : 매개변수로 전달받은 배열을 원래 배열의 뒤에 붙임

    ```javascript
    const arr1 = [
        {num: 1, color: "red"},
        {num: 2, color: "black"},
        {num: 3, color: "blue"}
    ];

    const arr2 = [
        {num: 4, color: "green"},
        {num: 5, color: "blue"}
    ];
    
    console.log(arr1.concat(arr2));
    ```
+ sort: 배열을 정렬하여 원본 배열에 저장 (반환하는 것이 아님)  
문자열을 기준으로 사전 순서대로 정렬함 (모든 변수를 문자열로 봄)  
만약 문자열이 아닌 숫자, 객체 등을 정렬해야 하는 경우 sort의 매개변수로 비교 함수를 전달

    ```javascript
    let chars = ["나", "다", "가"];

    chars.sort();

    // 비교 함수 만들기 (오름차순)
    const compare = (a, b)=>{
        // 1. 같다
        if(a == b){
            return 0;
        }

        // 2. 크다 : 큰 값이 뒤로 가야 함
        if(a > b){
            return 1;
        }
        
        // 3. 작다 : 작은 값이 앞으로 가야 함
        if(a < b){
            return -1;
        }
    }

    // 숫자 정렬
    let numbers = [0, 10, 1, 30, 4, 7, 44, 13];

    numbers.sort(compare);
    ```
+ join : 배열 내의 모든 요소를 쉼표로 구분된 문자열로 합침  
만약 구분자를 쉼표가 아닌 다른 문자로 지정하고 싶은 경우 원하는 구분자를 매개변수로 넘기면 됨
    
    ```javascript
    const arr = ["1", "2", "3", "4"];

    console.log(arr.join());
    ```
<br>

## JavaScript 응용
### Truthy & Falsy
Truthy & Falsy : boolean 값을 넣지 않아도 참이나 거짓으로 인식되는 속성 (참/거짓이 아니어도 참/거짓으로 인식되는 속성)  
빈 문자열, undefined 등을 false로 판단함  
예외처리 시 유용함 
+ Truthy : 빈 배열, 빈 객체, 0이 아닌 숫자, 값이 있는 문자열, Infinity  
+ Falsy : null, undefined, 숫자 0, NaN, 빈 문자열  
<br>

### 삼항연산자
삼항연산자 : 간단한 조건식을 한 줄로 표현 가능  
조건식 ? 참일 때 수행할 식 : 거짓일 때 수행할 식  
삼항연산자의 조건식에도 Truthy와 Falsy 사용 가능 
```javascript
let a;
a ? true : false; // Truthy, Falsy 사용
```
중첩해서 사용하면 else if처럼 사용 가능하지만 가독성이 떨어짐  
<br>

### 단락회로 평가
단락회로 평가 : 왼쪽에서 오른쪽으로 연산하게 되는 논리 연산자의 연산 순서를 이용하는 문법으로 피연산자 중 뒤에 위치한 피연산자를 확인할 필요 없이 연산을 끝내는 것  
ex. && 연산의 경우 두 개 다 참일 때만 참이기 때문에 첫 번째 피연산자가 거짓인 경우에는 뒤의 피연산자를 확인할 필요 없이 거짓이 됨  
Truthy/Falsy와 단락회로 평가를 같이 사용하는 경우 코드 길이 단축 가능
```javascript
// 1. &&만 사용 : person 값이 그래도 출력되기 때문에 null 또는 undefined 값이 출력될 수 있음
const getName = (person) => {
    return person && person.name; // 단락회로 평가와 Falsy를 같이 사용
    // person이 Falsy(undefined)이므로 뒤에 있는 person.name에 접근하지 않고 person을 반환
}

let person;
const name = getName(person);
console.log(name);

// 2. || 같이 사용 : 앞이 true이거나 Truthy하면 뒤를 고려하지 않고 앞에 있는 것 반환
const getName = (person) => {
    const name = person && person.name;
    return name || "객체가 아닙니다"; 
}

let person;
const name = getName(person);
console.log(name);
```
<br>

### 비 구조화 할당 
비 구조화 할당(구조 분해 할당) : 여러 개의 변수에 배열의 값을 간편하게 할당하는 기술  

배열의 비 구조화 할당 : 대괄호를 이용하여 배열의 값을 순서대로 변수에 할당 가능
```javascript
let arr = [1, 2, 3];

let [one, two, three] = arr; // one, two, three라는 변수에 각각 1, 2, 3이 할당됨 (배열의 기본 변수 비 구조화 할당)

let [one, two, three] = [1, 2, 3]; // 다음과 같은 방식으로도 사용 가능 (배열의 선언 분리 비 구조화 할당)
```
배열의 값을 변수에 할당받지 못하는 상황에 변수의 기본값을 설정 가능 (undefined, null 등이 출력되면 안 되는 경우에 유용)
```javascript
let [one, two, three, four = 4] = [1, 2, 3];
```
swap을 하는 경우 유용함
```javascript
let a = 1;
let b = 40;

[a, b] = [b, a]; // 오른쪽에 새로운 배열을 만든 것
```
<br>

객체의 비구조화 할당 : 키 값을 기준으로 키와 동일한 이름의 변수에 저장 (순서 상관 없음)
```javascript
let object = { one: 1, two: 2, three: 3 };

let { one, two, three } = object; 
```
변수의 이름을 다르게 사용하고 싶은 경우 :을 이용해 바꿀 수 있음
```javascript
let object = { one: 1, two: 2, three: 3 };

let { one:a, two:b, three:c } = object; 
```
배열처럼 기본값 설정 가능  
<br>

### Spread 연산자
Spread 연산자 : 중복된 프로퍼티들을 계속해서 작성하는 경우에 이를 해결하기 위해 사용할 수 있음 (...)  
객체의 값을 새로운 객체에 펼쳐 주는 역할
```javascript
const cookie = {
  base: "cookie",
  madeIn: "korea"
};

const blueberryCookie = {
  ...cookie, // Spread 연산자
  toping: "blueberry"
};

console.log(blueberryCookie);
```
배열을 합치는 경우에도 사용 가능하며 concat과 달리 합치는 배열 중간에도 유연하게 값을 삽입 가능
```javascript
const noTopingCookies = ["촉촉한쿠키", "안촉촉한쿠키"];
const topingCookies = ["초코칩쿠키", "딸기쿠키"];

const allCookies = [...noTopingCookies, ...topingCookies]; // 이렇게 배열을 합칠 수 있음

```
<br>

### 동기 & 비동기
자바스크립트의 코드 실행 방식 : 자바스크립트는 싱글 스레드 방식으로 작동
+ 동기 방식 : 스레드 하나로 작성된 순서대로 작업을 처리함 먼저 작성된 코드가 모두 실행되면 다음 코드 실행  
하나의 작업이 너무 오래 걸리면 모든 작업이 오래 걸림 (성능상 문제 발생)   
= 블로킹 방식 : 스레드에서 작업 하나가 수행되고 있을 때 다른 작업을 동시에 할 수 없는 방식  
+ 비동기 방식 : 여러 개의 작업을 동시에 실행  
작업이 정상적으로 끝났는지를 확인하기 위해 콜백 함수를 붙여서 실행 (비동기 처리의 결과값 또는 끝났는지 확인)  
= 논 블로킹 방식  
setTiemout() : 타이머를 만들 수 있는 내장 비동기 함수로 콜백함수와 delayTime이 매개변수로 들어감 delayTime은 밀리세컨드 단위이며, 해당 시간 뒤에 콜백 함수를 실행  

    ```javascript
    function taskA(){
        setTimeout(()=>{
            // 코드
        }, delayTime);
    }
    ```
    비동기 처리의 값을 이용해야 하는 경우 콜백 함수 사용

JS Engin : Heap과 Call Stack 두 개의 공간으로 이루어짐  
스레드는 Call Stack 하나만을 담당
+ Heap : 변수나 상수들의 메모리 할당
+ Call Stack : 작성한 코드의 실행에 따라 호출 스택을 쌓음  
프로그램이 실행되면 Main Context가 제일 먼저 들어옴 (제일 마지막에 나감)  

Web APIs, Event Loop, Callback Queue : 자바스크립트와 웹 간의 상호작용을 처리하기 위한 요소로 가장 대표적인 상호작용은 비동기 처리임  
자바스크립트는 비동기로 실행되는 함수를 Call Stack에서 Web APIs로 넘기기 때문에 바로 다음 함수가 실행됨  
비동기 함수의 콜백 함수는 비동기 함수가 실행된 후 Callback Queue로 옮겨지고, Event Loop를 통해 Call Stack으로 다시 옮겨짐  
<br>

### Promise
콜백 지옥 : 연속되는 비동기 함수를 처리할 때 비동기 함수의 값을 사용하기 위해서 콜백이 계속해서 길어지는 현상  
Promise : 자바스크립트의 비동기를 돕는 객체로 비동기 함수에 콜백을 줄지어 전달하지 않아도 됨

비동기 작업이 가질 수 있는 3가지 상태 
+ Pending (대기 상태) : 비동기 작업이 진행 중이거나 시작할 수 없는 상태
+ Fulfilled (성공) : 비동기 작업이 의도한대로 정상적으로 완료된 상태  
resolve : 비동기 작업이 Pending 상태에서 Fulfilled 상태가 되는 것
+ Rejected (실패) : 비동기 작업이 실패했음을 의미 (응답 없음, 시간 초과 등)  
reject : 비동기 작업이 Pending 상태에서 Rejected 상태로 변화하는 것
```javascript
function isPositive(number, resolve, reject) {
  setTimeout(() => {
    if (typeof number === "number") {
      // 성공 -> resolve
      resolve(number >= 0 ? "양수" : "음수 ");
    } else {
      // 실패 -> reject
      reject("주어진 값이 숫자형 값이 아닙니다");
    }
  }, 2000);
}

isPositive(
  10,
  (res) => {
    console.log(res);
  },
  (err) => {
    console.log(err);
  }
);
```

Promise 사용 방법
```javascript
function isPositiveP(number){
  const executor = (resolve, reject)=>{ // 실행자 : 비동기 작업을 실질적으로 수행
    setTimeout(()=>{
      if (typeof number === "number") {
        resolve(number >= 0 ? "양수" : "음수 ");
      } else {
        reject("주어진 값이 숫자형 값이 아닙니다");
      }
    }, 2000);
  };

  const async = new Promise(executor); // 전달하는 순간 자동으로 executor 수행됨
  return async; // promise 객체 반환
}

const res = isPositiveP(101); // 반환받은 promise 객체 사용
// res는 비동기 처리의 결과값인 resolve 또는 reject를 가지고 있음

// 비동기처리의 결과 사용
res
  .then((res) => {
    console.log("작업 성공 : ", res); // resolve
  })
  .catch((err) => {
    console.log("작업 실패 : ", err); // reject
  });

// 실행자를 변수로 만들지 않고 바로 넣기
function isPositiveP(number){
  return = new Promise((resolve, reject) => {
    setTimeout(()=>{
      if (typeof number === "number") {
        resolve(number >= 0 ? "양수" : "음수 ");
      } else {
        reject("주어진 값이 숫자형 값이 아닙니다");
      }
    }, 2000);
  });
}
```

콜백 지옥을 탈출하는 방법 : then 체이닝
```javascript
taskA(5, 1).then((a_res) => {
    console.log("A RESULT : ", a_res);
    return taskB(a_res); // taskA의 결과를 리턴 : taskB의 Promise 객체가 반환됨
}).then((b_res)=>{ // 따라서 Promise 객체이기 때문에 then을 연결하여 사용 가능
    console.log("B RESULT : ", b_res);
})
```
<br>

### async
async : 비동기를 다루는 기능이자 Promise를 더 쉽게 사용할 수 있도록 도와주는 기능  
함수 앞에 async 키워드를 붙여 주면 해당 함수는 Promise를 리턴하는 비동기 처리 함수가 됨
```javascript
async function helloAsync() {
  return "hello Async"; // resolve의 결과값이 됨
}

helloAsync().then((res) => {
  console.log(res);
});
```
<br>

### await
await : 비동기 함수의 호출 앞에 붙이면 비동기함수가 동기 함수처럼 작동함  
await이 붙은 함수가 실행되기 전에는 그 아래 코드가 실행되지 않으며, async 함수 내에서만 사용 가능
```javascript
function delay(ms){
    return new Promise((resolve) => {
        setTimeout(resolve, ms); // ms만큼 기다리기
    });
}

async function helloAsync() {
    await delay(3000);
    return "hello Async"; 
}

helloAsync().then((res) => {
  console.log(res);
});
``` 
<br>

### API 호출
API : 클라이언트와 서버를 연결하는 방법  
응답을 언제 받을 수 있을지 모르기 때문에 비동기 처리로 진행하여야 함  
[JSON Placeholder](https://jsonplaceholder.typicode.com/) : API 학습을 위해 더미 데이터를 반환하는 Open API  

fetch() : 자바스크립트에서 API 호출을 할 수 있는 내장함수로 Promise 객체를 반환  
fetch를 통해 API 값을 가지고 오게 되면 API 성공 객체 자체(resolve의 리턴값)를 반환하기 때문에 Response 객체가 반환됨(결과값의 포장지)
```javascript
let response = fetch("https://jsonplaceholder.typicode.com/posts").then(
  (res) => {
    console.log(res);
  }
);
```
