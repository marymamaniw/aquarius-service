package com.marymamani.aquariusservice.repositories;

import com.marymamani.aquariusservice.models.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AreaRepository extends JpaRepository<Area, UUID> {

    Area findByName(String name);
}
