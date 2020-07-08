package by.itechart.testtask.dto;

import by.itechart.testtask.model.Type;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.util.Date;

public class BalanceChangeDto {
    private Long id;

    @NotNull(message = "value should be not empty or null.")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal changeValue;

    @NotNull(message = "type should be not empty or null.")
    private Type type;

    @PastOrPresent(message = "invalid date")
    private Date date;

    @NotNull(message = "enter cafe id")
    private Long cafeId;

    public BalanceChangeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getChangeValue() {
        return changeValue;
    }

    public void setChangeValue(BigDecimal changeValue) {
        this.changeValue = changeValue;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }

    @Override
    public String toString() {
        return "BalanceChangeDto: " +
                "id = " + id +
                ", changeValue = " + changeValue +
                ", type = " + type +
                ", date = " + date +
                ", cafe = " + cafeId;
    }
}
