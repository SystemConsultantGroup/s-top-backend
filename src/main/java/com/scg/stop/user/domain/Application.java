package com.scg.stop.user.domain;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.scg.stop.global.domain.BaseTimeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor
public class Application extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String division; //소속

    private String position; // 직책

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Application(String division, String position, User user) {
        this.division = division;
        this.position = position;
        this.user = user;
    }

    public void updateDivision(String newDivision) {
        this.division = newDivision;
    }

    public void updatePosition(String newPosition) {
        this.position = newPosition;
    }
}
