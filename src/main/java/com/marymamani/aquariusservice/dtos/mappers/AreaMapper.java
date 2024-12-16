package com.marymamani.aquariusservice.dtos.mappers;

import com.marymamani.aquariusservice.dtos.AreaDto;
import com.marymamani.aquariusservice.models.Area;
import org.springframework.stereotype.Component;

@Component
public class AreaMapper {

    public Area toArea(AreaDto areaDto) {
        Area area = new Area();
        area.setName(areaDto.getName());
        return area;
    }
}
