package com.forUMC.app.domain;

import com.forUMC.app.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false)
    private Integer foodPrice;

    @Column(nullable = false)
    private LocalDate deadline;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

//    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
//    private List<MemberMission> memberMissions = new ArrayList<>();


    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
        restaurant.getMissions().add(this);
    }
}
