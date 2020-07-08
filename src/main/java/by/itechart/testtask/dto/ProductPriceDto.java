package by.itechart.testtask.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.util.Date;

public class ProductPriceDto {
    private Long id;

    @NotNull(message = "price should be not empty or null.")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal price;

    @PastOrPresent(message = "invalid date")
    private Date dateStart;

    @FutureOrPresent(message = "invalid date")
    private Date dateEnd;

    @NotNull(message = "enter product id")
    private Long productId;

    public ProductPriceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductPriceDto: " +
                "id = " + id +
                ", price = " + price +
                ", dateStart = " + dateStart +
                ", dateEnd = " + dateEnd +
                ", productId = " + productId;
    }
}
