package com.example.cheko_app.services;

import com.example.cheko_app.dto.BrowseResponse;
import com.example.cheko_app.dto.DishCountResponse;
import com.example.cheko_app.entities.Dish;
import com.example.cheko_app.entities.MasterType;
import com.example.cheko_app.mapper.DishToBrowseResponseMapper;
import com.example.cheko_app.mapper.LookupMapper;
import com.example.cheko_app.repositories.DishRepository;
import com.example.cheko_app.specification.DishSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final DishToBrowseResponseMapper dishToBrowseResponseMapper;
    private final LookupMapper lookupMapper;

    public List<BrowseResponse> browse(String search, Long type) {
        Specification<Dish> spec = Specification
                .where(DishSpecification.hasSearchByNameOrDescription(search))
                .and(DishSpecification.hasType(type));

        List<Dish> dishes = dishRepository.findAll(spec);

        return dishToBrowseResponseMapper.mapAll(dishes);
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
}
