package jpabook.jpashop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "orders")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL) // cascade를 두면 order를 생성하면 orderItems을 같이 생성 (삭제도 같이 삭제)
    // 원래 모든 엔티티는 persist 해주고 싶으면 각각 해줘야 함
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문 시간
    // java8에서는 LocalDateTime을 쓰면 매핑을 안 해줘도 hibernate가 알아서 지원해줌

    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문 상태 [ORDER, CANCEL]

    //== 연관관계 메서드 ==//
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this); // 양방향 연관관계에 걸리도록 하기
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //== 생성 메서드 ==//
    public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems){ // 생성할 때 무조건 호출 (생성에 대한 비즈니스 로직 응집)
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);

        for(OrderItem orderItem : orderItems){
            order.addOrderItem(orderItem);
        }

        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());

        return order; // 연관관계를 걸면서 모두 세팅함 -> 생성 시점에 무언가를 수정해야 하면 해당 부분에서만 수정하면 됨
    }

    //== 비즈니스 로직 ==//
    // 주문 취소
    public void cancel(){
        if(delivery.getStatus() == DeliveryStatus.COMP){ // 이미 배송이 끝난 경우
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);

        for(OrderItem orderItem : orderItems){
            orderItem.cancel(); // orderItem에도 각각 cancel 해줘야 함
        }
    }

    //== 조회 로직 ==//
    // 전체 주문 가격 조회
    public int getTotalPrice(){
//        int totalPrice = 0;
//
//        for(OrderItem orderItem : orderItems){
//            totalPrice += orderItem.getTotalPrice(); // 주문할 때 주문 가격과 수량이 있기 때문에 그게 뽑혀야 함
//        }
//
//        return totalPrice;

        return orderItems.stream()
                .mapToInt(OrderItem::getTotalPrice)
                .sum(); // 위와 같은 로직
    }
}
