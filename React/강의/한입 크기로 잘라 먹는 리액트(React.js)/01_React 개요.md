# React 개요
## React란?
React : 페이스북이 만든 프론트엔드 라이브러리로 사용자 인터페이스를 만들기 위해 사용된다. 싱글 페이지 애플리케이션이나 모바일 애플리케이션 개발 시 토대로 사용될 수 있다.  
<br>

## React의 특징
1. JSX 문법  
    JSX란 자바스크립트 안에서 HTML을 사용하여 view를 구성할 수 있도록 하는 자바스크립트 문법이다. 리액트는 이러한 JSX를 이용하여 개발 편의성을 높인다.
2. Component 기반  
    컴포넌트란 독립적인 단위의 소프트웨어 모듈을 말한다. 리액트는 UI를 여러 컴포넌트를 쪼개서 만들기 때문에 전체 코드 파악이 쉽고, 코드의 재사용성이 증가한다.
3. Virtual DOM  
    DOM을 추상화한 것으로 면화를 미리 인지해 변화시킨다. 이 작업은 실제 DOM에서 진행되는 것이 아니므로 렌더링이 되지 않고, 그에 따른 연산도 줄어들기 때문에 앱의 효율성과 속도를 개선시킨다.  
    __* DOM__ : Document Object Model의 약자로 HTML 단위 하나하나를 객체로 생각한 모델을 말한다.
4. 단방향 Data Flow
