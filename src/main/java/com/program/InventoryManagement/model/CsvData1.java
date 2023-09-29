package com.program.InventoryManagement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CsvData1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pId;
    String productName;
    String productNo;

}
