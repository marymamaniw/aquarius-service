package com.marymamani.aquariusservice.models;

import com.marymamani.aquariusservice.utils.constants.TableConstants.AreaTable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = AreaTable.TABLE_NAME)
public class Area {

    @Id
    @Column(name = AreaTable.CODE, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    @Column(name = AreaTable.NAME, nullable = false)
    private String name;
}
