import DiaryItem from "./DiartItem";

const DiaryList = ({ diaryList }) => {
  console.log(diaryList);

  return (
    <div className="DiaryList">
      <h2>일기 리스트</h2>
      <h4>{diaryList.length}개의 일기가 있습니다.</h4>
      <div>
        {diaryList.map(
          (
            it // 데이터에 고유한 값이 있는 경우 자식 요소의 최상위 부분에 key값을 지정해 줌
            // idx // 만약 고유한 값이 없는 경우 idx를 지정하면 됨 하지만 인덱스를 사용하는 경우 배열에 수정이 발생했을 떄 문제가 발생할 가능성 있음
          ) => (
            // <div key={it.id}>
            //   {/* <div key={idx}> */}
            //   <div>작성자 : {it.author}</div>
            //   <div>일기 : {it.content}</div>
            //   <div>감정 : {it.emotion}</div>
            //   <div>작성 시간(ms) : {it.created_date}</div>
            // </div>
            <DiaryItem key={it.id} {...it} />
          )
        )}
      </div>
    </div>
  );
};

DiaryList.defaultProps = {
  diaryList: [], // undefined인 경우 발생하는 에러를 방지하기 위해 default 파라미터 값 설정
};

export default DiaryList;
