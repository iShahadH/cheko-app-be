package com.example.cheko_app.services;

import com.example.cheko_app.dto.BrowseDishResponse;
import com.example.cheko_app.dto.DetailsDishResponse;
import com.example.cheko_app.dto.DishCountResponse;
import com.example.cheko_app.entities.Dish;
import com.example.cheko_app.entities.MasterType;
import com.example.cheko_app.mapper.DishToBrowseDishResponseMapper;
import com.example.cheko_app.mapper.DishToDetailsResponseMapper;
import com.example.cheko_app.mapper.LookupMapper;
import com.example.cheko_app.repositories.DishRepository;
import com.example.cheko_app.specification.DishSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DishService {

    private final MinioService minioService;
    private final DishRepository dishRepository;
    private final DishToBrowseDishResponseMapper dishToBrowseDishResponseMapper;
    private final DishToDetailsResponseMapper dishToDetailsResponseMapper;
    private final LookupMapper lookupMapper;

    public List<BrowseDishResponse> browse(String search, Long type) {
        Specification<Dish> spec = Specification
                .where(DishSpecification.hasSearchByNameOrDescription(search))
                .and(DishSpecification.hasType(type));

        List<Dish> dishes = dishRepository.findAll(spec);

        return dishToBrowseDishResponseMapper.mapAll(dishes);
    }

    public List<DishCountResponse> countGroupedByType() {
        List<Object[]> results = dishRepository.countDishesGroupedByType();

        return results.stream()
                .map(obj -> new DishCountResponse(
                        lookupMapper.mapMasterType((MasterType) obj[0]), // type column
                        (Long) obj[1] // count column
                ))
                .toList();
    }

    public DetailsDishResponse details(Long dishId) {
        Dish dish = dishRepository.findById(dishId).orElseThrow();
        return dishToDetailsResponseMapper.map(dish);
    }

    public void increase(Long dishId) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found with id: " + dishId));
        dish.setQuantity(dish.getQuantity() + 1);
        dishRepository.save(dish);
    }

    public void decrease(Long dishId) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new EntityNotFoundException("Dish not found with id: " + dishId));

        if (dish.getQuantity() > 0) {
            dish.setQuantity(dish.getQuantity() - 1);
            dishRepository.save(dish);
        }
    }

    public List<BrowseDishResponse> getSecondHighestCalorie() {
        List<Dish> dishes = dishRepository.findSecondHighestCaloriePerType();
        return dishToBrowseDishResponseMapper.mapAll(dishes);
    }

    public void uploadDishImage(Long dishId, MultipartFile file) throws IOException {
        String s3Key = "dishes/" + dishId + "/" + file.getOriginalFilename();
        String url = minioService.uploadFile(file, s3Key);
        System.out.println("Uploading file: " + url);

        Dish dish = dishRepository.findById(dishId).orElseThrow();
        dish.setS3Url(url);
        dishRepository.save(dish);
    }

    public byte[] getDishImage(Long dishId) throws Exception {
        Dish dish = dishRepository.findById(dishId).orElseThrow();
        return minioService.getFileAsBytes(dish.getS3Url());
    }
}
