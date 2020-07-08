package by.itechart.testtask.dto;

import by.itechart.testtask.model.Unit;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class SalaryDto {
    private Long id;

    @NotNull(message = "rate should be not empty or null.")
    private Float rate;

    @NotNull(message = "unit should be not empty or null.")
    private Unit unit;

    @PastOrPresent(message = "invalid date start")
    private Date dateStart;

    @FutureOrPresent(message = "invalid date end")
    private Date dateEnd;

    @NotNull(message = "enter user id")
    private Long userId;

    public SalaryDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SalaryDto: " +
                "id = " + id +
                ", rate = " + rate +
                ", unit = " + unit +
                ", dateStart = " + dateStart +
                ", dateEnd = " + dateEnd +
                ", userId = " + userId;
    }
}
