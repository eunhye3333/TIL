# React 실습

## React에서 배열 사용하기

### 컴포넌트 & 데이터 구조

리액트에서는 같은 레벨끼리는 데이터를 주고받을 수 없음

리액트는 단방향으로만 데이터가 흐름 (위 → 아래)



해결 방안 : 리액트의 상태인 state를 Editor과 List의 공통 부모 요소로 끌어올려서 해결 가능

|                 | <App /><br />[data, setData] |               |
| :-------------: | :--------------------------: | :-----------: |
|        ↓        |                              |       ↓       |
|     setData     |                              |     Data      |
|        ↓        |                              |       ↓       |
| <DiaryEditor /> |                              | <DiaryList /> |

<br>

리액트의 데이터 : 위 → 아래

리액트의 이벤트 : 아래 → 위