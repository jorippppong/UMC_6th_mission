package com.forUMC.app.domain;

import com.forUMC.app.converter.RestaurantConverter;
import com.forUMC.app.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_category_id")
    private RestaurantCategory restaurantCategory;

//    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
//    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();

    public void setRestaurantCategory(RestaurantCategory restaurantCategory){
        this.restaurantCategory = restaurantCategory;
    }
}
