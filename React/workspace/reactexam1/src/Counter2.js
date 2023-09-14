import React,{useState} from "react";
import OddEvenResult from "./OddEvenREsult";

// const Counter2 = (props) => { // 부모에서 보내 준 props를 전달받음 (객체로 받아짐)
    // 몇 개를 보내든 객체 안에 담겨서 오게 됨
    // console.log(props);

const Counter2 = ({ initalValue }) => { // 비구조화 할당을 통해 받아오는 것 가능
    const [count, setCount] = useState(initalValue)

    const onIncrease = () => {
        setCount(count + 1); // 상태 변화 함수에 새로운 상태를 전달하여 업데이트함
    }

    const onDecrease = () => {
        setCount(count - 1);
    }

    return (
        <div>
            <h2>{count}</h2>
            <button onClick={onIncrease}>+</button>
            <button onClick={onDecrease}>-</button>
            <OddEvenResult count={count} />
        </div>
    )
}

Counter2.defaultProps = { // 부모컴포넌트에서 전달받지 않은 Props의 기본값을 설정해 에러 방지
    initalValue:0
}

export default Counter2;