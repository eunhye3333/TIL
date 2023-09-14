const OddEvenResult = ({count}) => {
    console.log(count);
    
    return <>{count % 2 === 0 ? "짝수" : "홀수"}</>;
}
// 부모가 내려주는 props가 변경되는 경우 리랜더 됨
export default OddEvenResult;