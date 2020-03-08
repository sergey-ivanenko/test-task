package by.itechart.testtask.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "timesheet")
public class Timesheet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "day_type", nullable = false, length = 15)
    @Enumerated(EnumType.STRING)
    private DayType dayType;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "work_time", nullable = false)
    private Float workTime;

    @Column(name = "daily_earnings", nullable = false)
    private BigDecimal dailyEarnings;

    @Column(name = "paid_out", nullable = false, columnDefinition = "boolean default false")
    private Boolean isPaidOut;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "timesheet")
    private Set<TimesheetStatus> timesheetStatuses;

    public Timesheet() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timesheet timesheet = (Timesheet) o;
        return id.equals(timesheet.id) &&
                dayType == timesheet.dayType &&
                date.equals(timesheet.date) &&
                workTime.equals(timesheet.workTime) &&
                dailyEarnings.equals(timesheet.dailyEarnings) &&
                isPaidOut.equals(timesheet.isPaidOut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dayType, date, workTime, dailyEarnings, isPaidOut);
    }
}
