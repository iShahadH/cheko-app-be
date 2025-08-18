package com.example.cheko_app.repositories;

import com.example.cheko_app.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long>, JpaSpecificationExecutor<Dish> {
    @Query("SELECT t, COUNT(d) FROM Dish d JOIN d.type t GROUP BY t")
    List<Object[]> countDishesGroupedByType();
}
