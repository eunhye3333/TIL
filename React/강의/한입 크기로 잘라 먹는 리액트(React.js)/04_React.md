# React

## React를 사용하는 이유

1. React는 Component 기반의 UI 라이브러리이기 때문에 컴포넌트화 가능

   공통으로 사용될 것으로 예상되는 코드를 모듈로 작성한 후 컴포넌트로 지정해 재사용함으로써(컴포넌트화 방식) 산탄총 수술(Shotgun Surgery) 방지

   ※ 산탄총 수술 : 중복 코드의 변경 사항으로 인해 중복 코드들이 포함된 파일을 모두 수정해야 하는 상황

2. React는 선언형 프로그래밍 방식임

   명령형 프로그래밍 방식 : 절차를 하나하나 다 나열해야 함 (ex. jQuery)
   선언형 프로그래밍 방식 : 그냥 목적을 바로 말함 (ex. React)

3. Virtual DOM

   DOM을 자주 업데이트하는 상황이 발생하면 브라우저는 많은 연산을 필요로 하게 되고, 결과적으로 성능 저하의 원인이 됨

   Virtual DOM(가상의 DOM)을 사용하면 요소를 추가하는 과정에서 발생하는 변화를 실제 돔에 업데이트하는 것이 아니라 가상의 돔에 업데이트한 후 한번에 업데이트함 이 경우 화면에 그리는 랜더링 과정을 생략하기 때문에 연산이 줄어듦

   ※ DOM(Document Object Model; 문서 객체 모델) : 웹 브라우저가 HTML을 해석할 수 있게 트리 형태로 구성해 놓은 모델



## React App을 만드는 방법

대표적으로 React와 함께 사용하는 라이브러리

+ Webpack : 다수의 자바스크립트 파일을 하나의 파일로 합쳐주는 모듈 번들 라이브러리 (모듈 번들러)
+ Babel : JSX 등의 쉽고 직관적인 자바스크립트 문법을 사용할 수 있도록 해주는 라이브러리 



Boiler Plate : 환경설정까지 이미 되어있는 패키지를 감싼 패키지를 사용하여 기초 설정 작업을 하지 않아도 되도록 해 주는 것 (빵틀 같은 역할)



create-react-app 설치 방법

```
npx create-react-app 프로젝트 이름
```

npx : 설치되어 있지 않은 패키지를 딱 한 번만 쓰고 싶을 때 사용하는 명령어로 npm을 편리하게 이용하기 위한 도구
만약 npx가 설치되어 있지 않다면 ```npm install -g npx```로 설치 가능



node.js 패키지의 경우 어떤 모듈을 써야 되는지가 package.json, package-lock.json에 명시되어 있기 때문에 node_modules 폴더가 없어도 됨
→ 없는 경우 ```npm i```를 입력하면 node_modules가 자동으로 다운로드됨



## JSX

리액트의 컴포넌트를 만드는데 유용한 역할을 하는 문법

+ 닫힘 규칙 : JSX는 여는 태그가 있으면 반드시 닫는 태그가 있어야 함 

  셀프 클로징 태그 : a 태그 또는 이미지 태그 등 HTML에서는 닫지 않아도 되는 태그들의 경우에도 JSX에서는 닫지 않으면 오류가 발생함 이런 경우에는 열자마자 닫아 주면 되는데 이를 셀프 클로징 태그라고 함 (```<a/>```)

- 최상위 태그 규칙 : 다른 모든 태그를 감싸는 가장 바깥 태그를 최상위 태그라고 하는데, JSX의 표현식은 반드시 하나의 최상위 태그를 가져야 함

  만약 최상위 태그로 묶고 싶지 않다면 React.fragment를 이용할 수 있음 해당 태그를 사용하면 최상위 태그로 묶이지 않고 리턴됨

  ```javascript
  import React from 'react'; // 리액트의 기능이기 때문에 리액트 import
  
  import MyHeader from "./MyHeader";
  
  function App() {
    let name = "이름";
  
    return (
      <React.Fragment>
        <MyHeader />
        <header className="App-header">
          <h2>안녕 리액트 {name}</h2>
        </header>
      </React.Fragment>
    );
  }
  ```

  빈 태그로 작성해도 같은 기능

  ```javascript
  import React from 'react'; // 리액트의 기능이기 때문에 리액트 import
  
  import MyHeader from "./MyHeader";
  
  function App() {
    let name = "이름";
  
    return (
      <>
        <MyHeader />
        <header className="App-header">
          <h2>안녕 리액트 {name}</h2>
        </header>
      </>
    );
  }
  ```



자바스크립트의 경우 class가 예약어이기 때문에 HTML처럼 class로 작성하는 것이 아니라 className으로 작성함

JSX의 중괄호 안에는 값을 포함할 수 있지만, 숫자나 문자열만 포함 가능 (배열 또는 boolean 등은 랜더가 되지 않음)

조건부 랜더링 : 삼항연산자를 이용하여 조건에 따라 다른 값을 출력하도록 하는 것  
<br>

## State
State(상태) : 계속 값이 바뀌는 동적인 데이터