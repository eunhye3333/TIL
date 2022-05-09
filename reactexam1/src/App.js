import React from "react"; // 리액트의 기능을 이용하는 컴포넌트에서만 import하면 됨
// import "./App.css";

import MyHeader from "./MyHeader";

function App() {
  let name = "이름";

  // return (
  //   <React.Fragment>
  //     <MyHeader />
  //     <header className="App-header">
  //       <h2>안녕 리액트 {name}</h2>
  //     </header>
  //   </React.Fragment>
  // );

  // return (
  //   <>
  //     <MyHeader />
  //     <header className="App-header">
  //       <h2>안녕 리액트 {name}</h2>
  //     </header>
  //   </>
  // );

  // 객체를 만들어서 하는 인라인 스타일링
  const style = {
    App: {
      backgroundColor: "black",
    },
    h2: {
      color: "red",
    },
    bold_text: {
      color: "green",
    },
  };

  const func = () => {
    return "func";
  };

  const number = 5;

  return (
    <div className="App" style={style.App}>
      <MyHeader />
      <h2 style={style.h2}>
        안녕 리액트 {name} {1 + 2} {"ㅈㄷㄹㅈ"} {func()}
      </h2>
      <b id="bold_text" style={style.bold_text}>
        {number}는 : {number % 2 === 0 ? "짝수" : "홀수"}
      </b>
    </div>
  );
}

export default App; // es 모듈 시스템 : 해당 시스템을 사용하면 import 이름 from "경로"로 다른 파일에서 추가해 사용 가능
// 이름은 변경 가능하며, export default는 하나만 가능
