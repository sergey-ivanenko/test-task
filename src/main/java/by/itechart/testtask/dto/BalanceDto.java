package by.itechart.testtask.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.math.BigDecimal;
import java.util.Date;

public class BalanceDto {
    private Long id;

    @NotNull(message = "value should be not empty or null.")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal value;

    @PastOrPresent(message = "invalid date")
    private Date dateStart;

    @FutureOrPresent(message = "invalid date")
    private Date dateEnd;

    @NotNull(message = "solvency should be not empty or null.")
    private Boolean solvency;

    @NotNull(message = "enter cafe id")
    private Long cafeId;

    public BalanceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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

    public Boolean getSolvency() {
        return solvency;
    }

    public void setSolvency(Boolean solvency) {
        this.solvency = solvency;
    }

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }

    @Override
    public String toString() {
        return "BalanceDto: " +
                "id = " + id +
                ", value = " + value +
                ", dateStart = " + dateStart +
                ", dateEnd = " + dateEnd +
                ", solvency = " + solvency +
                ", cafeId = " + cafeId;
    }
}
