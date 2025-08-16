package com.example.cheko_app.repositories;

import com.example.cheko_app.entities.MasterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterTypeRepository extends JpaRepository<MasterType, Long> {
}
