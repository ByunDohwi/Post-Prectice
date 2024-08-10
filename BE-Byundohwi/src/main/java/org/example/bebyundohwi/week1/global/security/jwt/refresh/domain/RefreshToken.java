package org.example.bebyundohwi.week1.global.security.jwt.refresh.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class RefreshToken {
    @Id
    private String accountId;


    private String token;


    public void updateToken(String token) {
        this.token = token;
    }
}
