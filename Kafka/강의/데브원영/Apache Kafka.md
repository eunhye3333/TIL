# Apache Kafka

## Kafka 개요 및 설명

### Apache Kafka 등장 배경

처음에는 데이터를 전송하는 소스 애플리케이션과 데이터를 받는 타겟 애플리케이션이 간단하게 단방향 통신을 수행

시간이 지나면서 소스 애플리케이션과 타겟 어플리케이션이 많아지고, 데이터를 전송하는 라인이 복잡해짐 → 배포와 장애에 대응하기 어려움

데이터를 전송할 때 프로토콜 포맷의 파편화가 심해져 유지보수가 어려워짐 이러한 문제를 해결하기 위해 Apache Kafka가 나옴



Apache Kafka : 소스 애플리케이션과 타켓 애플리케이션의 커플링을 약하게 하기 위해 나왔으며 아주 유연한 큐 역할을 함

Source Application -데이터→ Kafka -데이터→ Target Application

![image](https://user-images.githubusercontent.com/77559262/166422342-1f3c7d9a-b196-4f9d-ab68-2c17b8ac1aa9.png)



### Topic

카프카에서 다양한 데이터가 들어가는 공간

토픽에 프로듀서가 데이터를 넣게 되고, 컨슈머가 토픽에 있는 데이터를 가져다 사용 가능 (가장 오래된 데이터부터 가져감)

컨슈머가 데이터를 가져가더라도 데이터는 사라지지 않고 계속 파티션에 남아 있음 
이 데이터는 다른 컨슈머가 들어오는 경우 다시 가장 오래된 데이터부터 사용 가능
단, 다른 컨슈머의 구분은 아래를 따름

+ 컨슈머 그룹이 다를 경우
+ auto.offset.reset = earliest로 세팅되어 있는 경우



파티션이 여러 개인 경우 프로듀서가 키를 지정하여 데이터 할당을 컨트롤할 수 있음

+ 키가 null이고 기본 파티셔너를 사용하는 경우 라운드 로빈 방식으로 할당
+ 키가 있고 기본 파티셔너를 사용하는 경우 키의 해시 값을 구하고 특정 파티션에 할당

파티션을 늘리면 컨슈머 개수를 늘려서 데이터 처리를 분산시킬 수 있음
하지만 파티션을 삭제하는 것은 불가능하기 때문에 파티션을 늘릴 때 주의가 필요함

파티션의 레코드가 삭제되는 조건은 옵션을 통해 설정 가능 (일정한 기간 / 일정한 용량)

+ log.retention.ms : 최대 record 보존 시간
+ log.retention.byte : 최대 record 보존 크기 (byte)



### Producer

데이터를 카프카에 보내는 역할을 하며, 엄청난 양의 클릭로그들을 대량으로, 실시간으로 카프카에 적재할 때 사용 가능

Producer의 역할

+ Topic에 해당하는 메시지를 생성
+ 특정 Topic으로 데이터 publish(전송)
+ 전송 성공 여부 확인 가능, 처리 실패 시 재시도



카프카 클라이언트인 컨슈머와 프로듀서를 사용하기 위해서는 라이브러리 추가 필요
이때 카프카는 브로커 버전과 클라이언트 버전의 하위호환성이 완벽하게 모든 버전에 대해 지원하지 않기 때문에 버전 설정 시 주의 필요



카프카 프로듀서 작성 코드
```java
public class Producer{
    public static void main(String[] args) throws IOException {
        
        // 프로듀서를 위한 설정 정의
        Properties configs = new Properties();
        configs.put("bootstrap.servers", "localhost:9092"); // 부트스트랩 서버 설정을 로컬호스트의 카프카를 바라보도록 설정 (실제 연결 시에는 2개 이상의 정보를 넣는 것을 권장)
        configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); // key : 메시지를 보내면 토픽의 파티션이 지정될 때 쓰임
        configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        
        // 설정한 프로퍼티로 카프카 프로듀서 인스턴스 생성
        KafkaProducer<String, String> producer = new KafkaProducer<String, String> (configs);
        
        // 전송할 객체 생성
        ProducerRecord record = new ProducerRecord<String, String>("click_log", "login"); // 해당 코드의 경우 키 없이 click_log 토픽에 login이라는 value를 보내겠다는 의미
        
        producer.send(record); // 전송
        
        producer.close(); // 프로듀서 종료
    }
}
```



 키가 있는 경우 카프카는 키를 특정한 해시 값으로 변경시켜 파티션과 1 대 1 매칭을 시키기 때문에 파티션에는 동일한 값들이 쌓임
하지만 이때 새로운 파티션이 추가되면 키와 파티션의 매칭이 깨지기 때문에 키와 파티션의 연결은 보장되지 않음 → 키를 사용하는 경우 파시션을 추후에 추가하지 않는 것이 좋음



### Broker

카프카가 설치되어 있는 서버 단위

보통 3개 이상의 Broker로 구성하여 사용하는 것을 권장



### Replication

파티션의 복제로 만약 replication이 1이라면 파티션이 하나만 존재하는 것이고, replication이 2라면 파티션은 원본 하나, 복제본 하나로 총 두 개가 존재하는 것

브로커 개수에 따라 replication 개수가 제한됨 (replication 개수가 브로커 개수를 초과할 수 없음)

원본 파티션 (Leader partition) : 프로듀서가 토픽의 파티션에 데이터를 전달할 때 전달받는 주체
복제본 파티션 (Follower partition) 

파티션의 고가용성을 위해 사용됨
→ 브로커가 어떠한 이유로 사용할 수 없게 되면 해당 브로커에 있는 파티션은 복구할 수 없는데, 이로 인한 데이터의 손실을 방지하기 위함
만약 Leader partition을 사용할 수 없게 되는 경우 Follower partition이 Leader partition의 역할을 승계함

ack : 고가용성을 유지할 수 있는 장치, 0, 1, all 세 개의 옵션 중 하나의 옵션을 지정할 수 있음

+ 0인 경우 : 프로듀서는  Leader partition에 데이터를 전송하고 응답값을 받지 않음 (속도는 빠르지만 데이터 유실 가능성이 있음)
+ 1인 경우 :  Leader partition에 데이터를 전송하고 데이터를 정상적으로 받았는지 응답값을 받음 단, 나머지 파티션에 복제되었는지 알 수 없음 (데이터 유실 가능성이 있음)
+ all인 경우 : 1 옵션에 추가로 Follower partition에 복제가 잘 이루어졌는지에 대한 응답값을 받음 (데이터 유실은 없으나 속도가 현저히 느림)



### ISR (In Sync Replica)

원본 파티션과 복제본 파티션을 합한 것
