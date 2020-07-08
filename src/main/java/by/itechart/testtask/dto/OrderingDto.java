package by.itechart.testtask.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OrderingDto {
    private Long id;

    @NotNull(message = "total price should be not empty or null.")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalPrice;

    @PastOrPresent
    private Date date;

    @NotNull(message = "enter user id")
    @Positive
    private Long userId;

    @NotEmpty
    private List<MenuItemDto> menuItems;
    //private List<String> menuItemNames;

    public OrderingDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /*public List<String> getMenuItemNames() {
        return menuItemNames;
    }

    public void setMenuItemNames(List<String> menuItemNames) {
        this.menuItemNames = menuItemNames;
    }*/
    public List<MenuItemDto> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemDto> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "OrderingDto: " +
                "id = " + id +
                ", totalPrice = " + totalPrice +
                ", date = " + date +
                ", userId = " + userId +
                ", menuItems = " + menuItems;
    }
}
