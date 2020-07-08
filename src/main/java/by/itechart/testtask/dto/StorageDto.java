package by.itechart.testtask.dto;

import javax.validation.constraints.NotNull;

public class StorageDto {
    private Long id;

    @NotNull(message = "enter cafe id")
    private Long cafeId;

    @NotNull(message = "enter product id")
    private Long productId;

    @NotNull(message = "value should be not empty or null.")
    private Float value;

    public StorageDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "StorageDto: " +
                "id = " + id +
                ", cafeId = " + cafeId +
                ", productId = " + productId +
                ", value = " + value;
    }
}
