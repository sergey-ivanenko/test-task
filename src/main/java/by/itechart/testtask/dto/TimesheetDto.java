package by.itechart.testtask.dto;

import by.itechart.testtask.model.DayType;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.util.Date;

public class TimesheetDto {
    private Long id;

    @NotNull(message = "day type should be not empty or null.")
    private DayType dayType;

    @PastOrPresent(message = "invalid date")
    private Date date;

    @NotNull(message = "work time should be not empty or null.")
    private Float workTime;

    @NotNull(message = "price should be not empty or null.")
    @Digits(integer = 4, fraction = 2)
    private BigDecimal dailyEarnings;

    @NotNull
    private Boolean isPaidOut;

    @NotNull(message = "enter user id")
    private Long userId;

    public TimesheetDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        this.dayType = dayType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Float workTime) {
        this.workTime = workTime;
    }

    public BigDecimal getDailyEarnings() {
        return dailyEarnings;
    }

    public void setDailyEarnings(BigDecimal dailyEarnings) {
        this.dailyEarnings = dailyEarnings;
    }

    public Boolean getPaidOut() {
        return isPaidOut;
    }

    public void setPaidOut(Boolean paidOut) {
        isPaidOut = paidOut;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TimesheetDto: " +
                "id = " + id +
                ", dayType = " + dayType +
                ", date = " + date +
                ", workTime = " + workTime +
                ", dailyEarnings = " + dailyEarnings +
                ", isPaidOut = " + isPaidOut +
                ", userId = " + userId;
    }
}
