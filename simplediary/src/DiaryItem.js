const DiaryItem = ({
  author,
  content,
  created_date,
  emotion,
  id,
  onDelete,
}) => {
  console.log(id);
  return (
    <div className="DiaryItem">
      <div className="info">
        <span>
          작성자 : {author} | 감정 점수 : {emotion}
        </span>
        <br />
        <span className="date">
          {
            new Date(created_date).toLocaleString() // ms가 가진 시간을 기준으로 Date 객체 생성
          }
        </span>
      </div>
      <div className="content">{content}</div>
      <button
        onClick={() => {
          console.log(id);
          if (window.confirm(`${id}번째 일기를 정말 삭제하시겠습니까?`)) {
            onDelete(id);
          }
        }}
      >
        삭제하기
      </button>
    </div>
  );
};

export default DiaryItem;
