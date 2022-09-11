import { useRef, useState } from "react";
import "./App.css";
import DiaryEditor from "./DiaryEditor";
import DiaryList from "./DiaryList";

// const dummyList = [
//   {
//     id: 1,
//     author: "작성자",
//     content: "하이 1",
//     emotion: 5,
//     created_date: new Date().getTime(), // 밀리세컨즈로 변환하여 저장
//   },
//   {
//     id: 2,
//     author: "작성자2",
//     content: "하이 2",
//     emotion: 2,
//     created_date: new Date().getTime(),
//   },
//   {
//     id: 3,
//     author: "작성자3",
//     content: "하이 3",
//     emotion: 3,
//     created_date: new Date().getTime(),
//   },
// ];

function App() {
  const [data, setdata] = useState([]);

  const dataId = useRef(0);

  // 일기를 저장하면 일기 리스트에 반영이 되도록 설정하는 함수
  const onCreate = (author, content, emotion) => {
    const created_date = new Date().getTime();
    const newItem = {
      author,
      content,
      emotion,
      created_date,
      id: dataId.current,
    };

    data.current += 1;

    setdata([newItem, ...data]); // 원래 데이터에 새로운 일기 추가 (새로운 일기가 제일 위에 오게)
  };

  return (
    <div className="App">
      <DiaryEditor onCreate={onCreate} />
      {/* <DiaryList diaryList={dummyList} /> */}
      <DiaryList diaryList={data} />
    </div>
  );
}

export default App;
