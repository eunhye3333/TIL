import "./App.css";
import DiaryEditor from "./DiaryEditor";
import DiaryList from "./DiaryList";

const dummyList = [
  {
    id: 1,
    author: "작성자",
    content: "하이 1",
    emotion: 5,
    created_date: new Date().getTime(), // 밀리세컨즈로 변환하여 저장
  },
  {
    id: 2,
    author: "작성자2",
    content: "하이 2",
    emotion: 2,
    created_date: new Date().getTime(),
  },
  {
    id: 3,
    author: "작성자3",
    content: "하이 3",
    emotion: 3,
    created_date: new Date().getTime(),
  },
];

function App() {
  return (
    <div className="App">
      <DiaryEditor />
      <DiaryList diaryList={dummyList} />
    </div>
  );
}

export default App;
