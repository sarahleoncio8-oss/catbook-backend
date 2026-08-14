package com.catbook.catbookbackend.Repository;

import com.catbook.catbookbackend.entity.GatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GatoRepository extends JpaRepository<GatoEntity, Long> {
}