package com.marymamani.aquariusservice.models;

import com.marymamani.aquariusservice.utils.constants.TableConstants.AreaTable;
import com.marymamani.aquariusservice.utils.constants.TableConstants.EmployeeTable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = EmployeeTable.TABLE_NAME)
public class Employee {

    @Id
    @Column(name = EmployeeTable.CODE, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID code;

    @Column(name = EmployeeTable.NAME, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = EmployeeTable.AREA, nullable = false,
            referencedColumnName = AreaTable.CODE, foreignKey = @ForeignKey(name = EmployeeTable.FOREIGN_KEY))
    private Area area;

    @Column(name = EmployeeTable.EMAIL, nullable = false, unique = true)
    private String email;

    @Column(name = EmployeeTable.PHONE_NUMBER, nullable = false, unique = true)
    private String phoneNumber;
}
