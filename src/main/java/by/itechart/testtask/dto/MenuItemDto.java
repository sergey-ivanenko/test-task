package by.itechart.testtask.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class MenuItemDto {
    private Long id;

    @NotBlank(message = "menu item name should not be empty or null")
    private String name;

    @NotNull(message = "price should be not empty or null.")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;

    @NotNull
    private Boolean isActually;

    public MenuItemDto() {
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActually() {
        return isActually;
    }

    public void setActually(Boolean actually) {
        isActually = actually;
    }

    @Override
    public String toString() {
        return "MenuItemDto: " +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price +
                ", isActually = " + isActually;
    }
}
