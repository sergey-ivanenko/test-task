package by.itechart.testtask.dto;

import javax.validation.constraints.NotNull;

public class PurchaseDto {
    private Long id;

    @NotNull(message = "value should be not empty or null.")
    private Float value;

    @NotNull(message = "enter product id")
    private Long productId;

    public PurchaseDto() {
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "PurchaseDto: " +
                "id = " + id +
                ", value = " + value +
                ", productId = " + productId;
    }
}
