package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {} // jpa에서는 public, protected까지 허용, 기본 생성자가 있어야 jpa 사용 가능 (protected가 조금 더 안전)
    // jpa가 이런 제약을 두는 이유는 JPA 구현 라이브러리가 객체를 생성할 때 리플렉션 같은 기술을 사용할 수 있도록 지원해야 하기 때문

    // 값타입인 경우에는 Setter를 아예 제공하지 않고 생성할 때만 값을 받아서 생성하도록 하는 것이 좋음 (값 타입인 경우 변경 불가능하게 설계해야 함)
    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
