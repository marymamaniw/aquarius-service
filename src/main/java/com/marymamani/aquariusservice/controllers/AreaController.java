package com.marymamani.aquariusservice.controllers;

import com.marymamani.aquariusservice.dtos.AreaDto;
import com.marymamani.aquariusservice.models.Area;
import com.marymamani.aquariusservice.services.AreaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping
    public ResponseEntity<List<Area>> getAllAreas() {
        return ResponseEntity.ok(areaService.getAllAreas());
    }

    @PostMapping
    public ResponseEntity<Area> createArea(@Valid @RequestBody AreaDto areaDto) {
        Area areaCreated = areaService.createArea(areaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(areaCreated);
    }

    @PutMapping("{areaCode}")
    public ResponseEntity<Area> updateArea(@PathVariable UUID areaCode, @Valid @RequestBody AreaDto areaDto) {
        Area areaUpdated = areaService.updateArea(areaCode , areaDto);
        return ResponseEntity.ok(areaUpdated);
    }

    @DeleteMapping("{areaCode}")
    public ResponseEntity<UUID> deleteArea(@PathVariable UUID areaCode) {
        UUID deletedAreaCode = areaService.deleteArea(areaCode);
        return ResponseEntity.ok(deletedAreaCode);
    }
}
