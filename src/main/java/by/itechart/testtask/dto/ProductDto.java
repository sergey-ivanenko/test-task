package by.itechart.testtask.dto;

import by.itechart.testtask.model.Unit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {
    private Long id;

    @NotBlank(message = "product name should be not empty or null.")
    private String name;

    @NotNull(message = "product unit should be not empty or null.")
    private Unit unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ProductDto: " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", unit = " + unit;
    }
}
