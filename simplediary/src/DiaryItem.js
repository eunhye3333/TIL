const DiaryItem = ({ author, content, created_date, emotion, id }) => {
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
    </div>
  );
};

export default DiaryItem;
