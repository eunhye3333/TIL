import React,{useState} from "react";

const Counter = () => {
    
    // 기본값 0에서 출발
    // 1씩 증가하고
    // 1씩 감소하는 
    // count 상태
    
    console.log("counter 호출!");

    const [count, setCount] = useState(0)

    const[count2, setCount2] = useState(0) // 상태를 여러 개 가질 수 있음 단, 이름이 겹치면 안 됨
    // 각자의 state는 별개로 작동함

    // useState 메서드 : 배열을 반환하고 배열의 비구조화 할당을 통해서 count, setCount를 매개변수로 받아옴
    // count : 상태의 값
    // setCount : count의 상태를 변화시키는 상태변화 함수
    // 0 : 초기값

    const onIncrease = () => {
        setCount(count + 1); // 상태 변화 함수에 새로운 상태를 전달하여 업데이트함
    }

    const onDecrease = () => {
        setCount(count - 1);
    }

    const onIncrease2 = () => {
        setCount2(count2 + 1); 
    }

    const onDecrease2 = () => {
        setCount2(count2 - 1);
    }

    // 컴포넌트는 자신이 가진 상태가 변화하면 화면을 다시 그려 리랜더를 함 (함수를 다시 호출함)

    return (
        <div>
            <h2>{count}</h2>
            <button onClick={onIncrease}>+</button>
            <button onClick={onDecrease}>-</button>

            <h2>{count2}</h2>
            <button onClick={onIncrease2}>+</button>
            <button onClick={onDecrease2}>-</button>
        </div>
    )
}

export default Counter;