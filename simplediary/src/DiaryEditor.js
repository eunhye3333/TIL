import { useRef, useState } from "react";

const DiaryEditor = ({ onCreate }) => {
  const authorInput = useRef(); // React.MutableRefObject -> HTML DOM 요소에 접근하게 해줌
  const contentInput = useRef();

  const [state, setState] = useState({
    author: "",
    content: "",
    emotion: 1,
  }); // 비슷한 동작을 하는 state의 경우 이렇게 묶을 수 있음

  // const [author, setAutor] = useState("");
  // const [content, setContent] = useState("");

  const handleChangeState = (e) => {
    console.log(e.target.name);
    console.log(e.target.value);

    setState({
      ...state,
      [e.target.name]: e.target.value,
    });
  }; // onChange 합치기

  const handleSubmit = () => {
    if (state.author.length < 1) {
      // alert("작성자는 최소 1글자 이상 입력해주세요");
      // focus
      authorInput.current.focus();
      return;
    }

    if (state.content.length < 5) {
      // alert("일기 본문은 최소 5글자 이상 입력해 주세요");
      // focus
      contentInput.current.focus();
      return;
    }

    onCreate(state.author, state.content, state.emotion);

    alert("저장 성공");

    // 저장에 성공하면 일기 작성 폼 초기화
    setState({
      author: "",
      content: "",
      emotion: 1,
    });
  };

  return (
    <div className="DiaryEditor">
      <h2>오늘의 일기</h2>
      <div>
        <input
          ref={authorInput}
          name="author"
          value={state.author}
          type="text"
          // onChange={(e) => {
          //   // console.log(e.target.value);
          //   // console.log(e.target.name); // 타겟의 name 출력 가능
          //   // setAutor(e.target.value); // input 값이 바뀌게 해주는 설정
          //   setState({
          //     ...state, // 가지고 있는 프로퍼티를 펼쳐주는 것, 기본적으로 원래의 값을 알아서 세팅 가능
          //     // 객체가 만들어질 때 이 순서대로 만들어지기 때문에 만약 ...state를 뒤에 쓰면 원래의 값으로 덮어씌워져서 정상 동작 안 함
          //     author: e.target.value,
          //     // content: state.content
          //   }); // author의 값만 수정해야 함
          // }}

          onChange={handleChangeState}
        />
      </div>
      <div>
        <textarea
          ref={contentInput}
          name="content"
          value={state.content}
          onChange={handleChangeState}
        />
      </div>
      <div>
        오늘의 감정 점수 :　
        <select
          name="emotion"
          value={state.emotion}
          onChange={handleChangeState}
        >
          <option value={1}>1</option>
          <option value={2}>2</option>
          <option value={3}>3</option>
          <option value={4}>4</option>
          <option value={5}>5</option>
        </select>
      </div>
      <div>
        <button onClick={handleSubmit}>일기 저장하기</button>
      </div>
    </div>
  );
};

export default DiaryEditor;
