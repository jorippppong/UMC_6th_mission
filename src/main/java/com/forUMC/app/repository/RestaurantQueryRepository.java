package com.forUMC.app.repository;

import com.forUMC.app.domain.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RestaurantQueryRepository {
    @PersistenceContext
    private final EntityManager em;

    public Restaurant getMissions(Long restaurantId, Integer page, Integer size){
        return em.createQuery(
                "select r from Restaurant r"+
                        " where r.id = :restaurantId", Restaurant.class)
                .setParameter("restaurantId", restaurantId)
                .setFirstResult(page*size)
                .setMaxResults(size)
                .getSingleResult();
    }
}
