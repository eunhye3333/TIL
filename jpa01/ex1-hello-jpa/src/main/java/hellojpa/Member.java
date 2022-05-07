package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // jpa가 관리한다는 것을 알려주는 어노테이션
//@Table(name="USER") // MEMBER가 아니라 USER 테이블에 저장되도록 설정
public class Member {

    @Id
    private Long id;

//    @Column(name = "username") // 컬럼명이 name이 아니라 username이라고 설정해 주는 것
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
