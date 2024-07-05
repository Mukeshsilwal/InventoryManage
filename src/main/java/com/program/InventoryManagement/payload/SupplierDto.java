package com.program.InventoryManagement.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDto {
    private String supplierName;
    private int id;
    private String location;
    private Set<ProductDto> products;
}
