# 스프링부트 개념정리 3강 - 메시지 컨버터가 무엇인가요?
## MessageConverter
메시지 컨버터 : Java Object를 중간 단계인 JSON으로 컨버팅해 주는 역할 (직접 컨버팅하지 않아도 됨)  
요청, 응답받는 경우 모두 기능함  
다이렉트로 번역하는 것이 힘들기 때문에 양쪽 다 이해할 수 있는 중간 언어를 만듦 (XML을 사용하다가 JSON으로 대체됨)  
→ Java Object를 파이썬으로 넘기는 경우에는 파이썬이 이해할 수 없음 따라서 JSON으로 변경하여 파이썬으로 전달 (Java Object → JSON → Python Object)
```
JSON : 모든 언어가 이해할 수 있는 중간 단계  
num, name이라는 필드가 존재하는 Animal이라는 클래스를 JSON으로 변경하는 경우 {"num":10, "name":"사자"} 형태로 변환됨
```
자바 프로그램 → MessageConverter : Jackson → request(요청)/response(응답) → 파이썬 프로그램

## BufferedReader와 BufferWriter를 쉽게 사용 가능
통신 : 초기에는 bit 단위로 진행하였음 (1, 0)  
영어 한 문자를 전달하려고 함 → 8bit(256가지의 문자)로 통신 가능 (한글의 경우에는 16bit로 통신 가능)  
따라서 8bit씩 데이터를 끊어 읽으면 하나의 문자를 받을 수 있음, 이를 구분하기 위해 8bit를 1byte라고 하고, 이것이 통신의 단위가 됨  
각국 언어에 따라 필요한 Byte가 다름 따라서 전세계에서 호환할 수 있도록 하기 위해 유니코드에서 제공하는 UTF-8(3Byte 통신) 사용  
Byte Stream : 1Byte(8bit) 전송
바이트로 전송하는 경우 InputStream으로 읽음  
→ 하지만 문자가 아니라 Byte이기 때문에 변환에 어려움이 있음, 따라서 InputStreamReader를 이용해 문자 하나로 바꾸어 줌, 배열로 여러 개의 문자를 받음  
배열은 개수가 정해져 있기 때문에 해당 배열의 크기를 초과하는 경우 문자열이 잘릴 수 있고, 배열이 더 큰 경우에는 메모리 낭비가 발생할 수 있음  
### BufferedReader
BufferedReader : 위와 같은 상황을 해결하기 위해 배열이 아니라 BufferedReader를 사용하여 문자열을 받음 → 가병 길이의 문자열을 받을 수 있음
### BufferWriter
BufferWriter : Byte Stream으로 데이터를 전송할 때 가변 길이의 문자열을 쓰게 해 주는 클래스임, 하지만 PrintWriter를 더 많이 사용함  
### Spring에서는
BufferedReader와 BufferWriter를 직접 구현할 필요 없이 @ResponseBody(BufferWriter), @RequestBody(BufferedReader)라는 어노테이션을 통해 제공해 줌  
따라서 전송하는 데이터를 받을 수 있음
 
