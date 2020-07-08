package by.itechart.testtask.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class IngredientDto {
    private Long id;

    @Positive(message = "value should be greater than zero.")
    @NotNull(message = "value should be not empty or null.")
    @Digits(integer = 5, fraction = 3)
    private Float value;

    @Positive
    @NotNull
    private Long menuItemId;

    @Positive
    @NotNull
    private Long productId;

    public IngredientDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Long getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "IngredientDto: " +
                "id = " + id +
                ", value = " + value +
                ", menuItemId = " + menuItemId +
                ", productId = " + productId;
    }
}
