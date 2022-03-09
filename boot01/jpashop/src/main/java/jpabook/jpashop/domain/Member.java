package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장 타입을 사용하는 경우 사용되는 어노테이션 (@Embeddable과 @Embedded 중 하나만 있어도 됨)
    private Address address;

    @OneToMany(mappedBy = "member") // mappedBy : order 테이블에 있는 member 필드에 의해 매핑되었다는 뜻 (매핑된 거울이라는 의미)
    private List<Order> orders = new ArrayList<>();
}
