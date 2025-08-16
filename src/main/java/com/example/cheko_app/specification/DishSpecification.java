package com.example.cheko_app.specification;

import com.example.cheko_app.entities.Dish;
import org.springframework.data.jpa.domain.Specification;

public class DishSpecification {

    public static Specification<Dish> hasSearchByNameOrDescription(String search) {
        return (root, query, builder) -> {
            if (search == null || search.isBlank()) {
                return builder.conjunction();
            }
            String likePattern = "%" + search.toLowerCase() + "%";
            return builder.or(
                    builder.like(builder.lower(root.get("name")), likePattern),
                    builder.like(builder.lower(root.get("description")), likePattern)
            );
        };
    }

    public static Specification<Dish> hasType(Long typeId) {
        return (root, query, builder) -> {
            if (typeId == null) {
                return builder.conjunction();
            }
            return builder.equal(root.join("type").get("id"), typeId);
        };
    }
}