package com.example.userservice.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data // @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class) // 데이터가 업데이트, 생성되는 시간을 편리하게 기록되도록 해줌
public class User {
    @Id
    private String userId;

    private String userName;

    private String userPwd;

    private String position;

    @CreatedDate // 데이터가 생성될 때 업데이트
    private LocalDateTime createdAt;

    @LastModifiedDate // 데이터가 수정될 떄 업데이트
    private LocalDateTime updatedAt;
}
