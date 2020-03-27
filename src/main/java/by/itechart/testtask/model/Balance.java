package by.itechart.testtask.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "balance")
public class Balance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "date_start", nullable = false)
    private Date dateStart;

    @Column(name = "date_end", nullable = false)
    private Date dateEnd;

    @Column(name = "solvency", nullable = false, columnDefinition = "boolean default true")
    private Boolean solvency;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cafe_id", nullable = false)
    private Cafe cafe;

    public Balance() {
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

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return id.equals(balance.id) &&
                value.equals(balance.value) &&
                dateStart.equals(balance.dateStart) &&
                dateEnd.equals(balance.dateEnd) &&
                solvency.equals(balance.solvency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, dateStart, dateEnd, solvency);
    }
}
