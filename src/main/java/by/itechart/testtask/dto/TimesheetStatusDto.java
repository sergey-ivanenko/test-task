package by.itechart.testtask.dto;

import by.itechart.testtask.model.StatusValue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

public class TimesheetStatusDto {
    private Long id;

    @NotNull(message = "type should be not empty or null.")
    private StatusValue statusValue;

    @PastOrPresent(message = "invalid date")
    private Date date;

    private String comment;

    @NotNull(message = "enter timesheet id")
    private Long timesheetId;

    @NotNull(message = "enter user id")
    private Long userId;

    public TimesheetStatusDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusValue getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(StatusValue statusValue) {
        this.statusValue = statusValue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(Long timesheetId) {
        this.timesheetId = timesheetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TimesheetStatusDto: " +
                "id = " + id +
                ", statusValue = " + statusValue +
                ", date = " + date +
                ", comment = '" + comment + '\'' +
                ", timesheetId = " + timesheetId +
                ", userId = " + userId;
    }
}
