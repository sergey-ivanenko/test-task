package by.itechart.testtask.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "balance_changes")
public class BalanceChange implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "change_value", nullable = false)
    private BigDecimal changeValue;

    @Column(name = "type", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="cafe_id", nullable=false)
    private Cafe cafe;

    public BalanceChange() {
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
        BalanceChange that = (BalanceChange) o;
        return id.equals(that.id) &&
                changeValue.equals(that.changeValue) &&
                type == that.type &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, changeValue, type, date);
    }
}
