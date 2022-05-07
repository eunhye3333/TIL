# JPA 시작
## JPA 설정
JPA를 설정하기 위해서는 /META-INF/persistence.xml 파일이 필요  
<br>

## 데이터베이스 방언
JPA는 특정 데이터베이스에 종속적이지 않아서 중간에 데이터베이스를 변경할 수 있음  
하지만 각각의 데이터베이스가 제공하는 SQL 문법과 함수는 조금씩 다르기 때문에 이를 방언이라고 표현함  
→ 방언 : SQL 표준을 지키지 않는 특정 데이터베이스만의 고유한 기능  
따라서 어떤 데이터베이스의 방언을 사용할지 JPA에게 알려줘야 함 (하이버네이트는 40개 이상의 방언 지원)
<br>

### JPA 구동 방식
1. Persistence 클래스에서 시작
2. META-INF/persistence.xml에 작성한 설정 정보 조회
3. EntityManagerFactory 클래스 생성
4. 필요할 때마다 EntityManager 생성  
<br>  

### java.lang.NoClassDefFoundError
※ JDK 6/7/8에서는 JAXB API 클래스를 JDK의 일부로 제공하였으나, Java 9부터는 Java EE API로 간주되어 더이상 기본 클래스 경로에 포함되지 않는다. 따라서 다음 종속성을 추가해 주어야 한다.  

[Maven]
```xml
<!-- API, java.xml.bind module -->
<dependency>
    <groupId>jakarta.xml.bind</groupId>
    <artifactId>jakarta.xml.bind-api</artifactId>
    <version>2.3.2</version>
</dependency>
 
<!-- Runtime, com.sun.xml.bind module -->
<dependency>
    <groupId>org.glassfish.jaxb</groupId>
    <artifactId>jaxb-runtime</artifactId>
    <version>2.3.2</version>
</dependency>
```

[Gradle]
```gradle
dependencies {
    // JAX-B dependencies for JDK 9+
    implementation "jakarta.xml.bind:jakarta.xml.bind-api:2.3.2"
    implementation "org.glassfish.jaxb:jaxb-runtime:2.3.2"
}
```
<br>

### JPA 사용 시 주의 사항
+ 엔티티 매니저는 스레드 간에 절대 공유하면 안 되고 사용한 후에는 버려야 한다.
+ JPA의 모든 데이터 변경은 트랜잭션 안에서 실행되어야 한다.  
<br>

### JPQL
원하는 데이터를 가져오고, 통계성 쿼리를 날리고 하는 부분을 도와줌  
검색을 할 때도 테이블이 아닌 엔티티 객체를 대상으로 검색할 수 있는 문법 (DB에 종속적이지 않게)  
객체지향 쿼리 언어
