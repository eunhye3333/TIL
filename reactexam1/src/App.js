import React from "react"; 
import Container from "./Container";
import Counter from "./Counter";
import Counter2 from "./Counter2";

import MyHeader from "./MyHeader";

function App() {

  const number = 5;

  const counterProps = {
    a:1,
    b:2,
    c:3,
    d:4,
    e:5,
    initalValue:5
  }
  return (
    <Container>
      <div>
        <MyHeader />
        <Counter />
        {/* <Counter2 initalValue={5} a={1} b={2} c={3} /> */}
        <Counter2 {...counterProps} />
      </div>
    </Container>
  );
};

// initalValue : 부모 컴포넌트에서 자식 컴포넌트에 initalValue라는 이름의 값을 전달함 (Prop)
// ...counterProps : 객체를 펼쳐서 전달하는 스프레드 연산자

export default App;