package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Member") // jpa가 관리한다는 것을 알려주는 어노테이션
// 속성 name : JPA에서 사용할 엔티티 이름을 지정하는 속성, 기본값은 클래스 이름을 그대로 사용하며 같은 클래스 이름이 없는 경우에는 기본 값을 사용하는 것을 권장
//@Table(name="USER") // MEMBER가 아니라 USER 테이블에 저장되도록 설정 테이블 명을 바꾸고 싶은 경우 사용

public class Member {

    @Id
    private Long id;

   @Column(name = "username", unique = true, length = 10) // 컬럼명이 name이 아니라 username이라고 설정해 주는 것
   // unique 제약조건, 길이 등을 설정 가능 
   // 이와 같은 DDL 생성 기능은 DDL을 자동 생성할 때만 사용되고, JPA 실행 로직에는 영향을 주지 않음
   private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
