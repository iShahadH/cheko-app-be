package com.example.cheko_app.validators;

import com.example.cheko_app.repositories.DishRepository;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DishExists.DishExistsValidator.class)
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DishExists {
    String message() default "Dish with given id does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Component
    class DishExistsValidator implements ConstraintValidator<DishExists, Long> {

        private final DishRepository dishRepository;

        public DishExistsValidator(DishRepository dishRepository) {
            this.dishRepository = dishRepository;
        }

        @Override
        public boolean isValid(Long dishId, ConstraintValidatorContext context) {
            if (dishId == null) return false;
            return dishRepository.existsById(dishId);
        }
    }
}