package by.itechart.testtask.dto;

import by.itechart.testtask.model.StatusValue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class PurchaseStatusDto {
    private Long id;

    @PastOrPresent(message = "invalid date")
    private Date date;

    @NotNull(message = "status value should be not empty or null.")
    private StatusValue statusValue;

    @NotNull(message = "enter product id")
    private Long purchaseId;

    @NotNull(message = "enter user id")
    private Long userId;

    public PurchaseStatusDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public StatusValue getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(StatusValue statusValue) {
        this.statusValue = statusValue;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PurchaseStatusDto: " +
                "id = " + id +
                ", date = " + date +
                ", statusValue = " + statusValue +
                ", purchaseId = " + purchaseId +
                ", userId = " + userId;
    }
}
