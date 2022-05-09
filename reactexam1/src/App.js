import "./App.css";

function App() {
  let name = "이름";

  return (
    <div className="App">
      <header className="App-header">
        <h2>안녕 리액트 {name}</h2>
      </header>
    </div>
  );
}

export default App; // es 모듈 시스템 : 해당 시스템을 사용하면 import 이름 from "경로"로 다른 파일에서 추가해 사용 가능
// 이름은 변경 가능하며, export default는 하나만 가능
