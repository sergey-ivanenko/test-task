package by.itechart.testtask.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "appeal")
public class Appeal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "cafe_id", nullable = false)
    private Cafe cafe;

    @ManyToOne
    @JoinColumn(name = "ordering_id")
    private Ordering ordering;

    @OneToMany(mappedBy = "appeal", cascade = CascadeType.ALL)
    private Set<AppealComment> appealComments;

    public Appeal() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Cafe getCafe() {
        return cafe;
    }

    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public Set<AppealComment> getAppealComments() {
        return appealComments;
    }

    public void setAppealComments(Set<AppealComment> appealComments) {
        this.appealComments = appealComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appeal appeal = (Appeal) o;
        return id.equals(appeal.id) &&
                date.equals(appeal.date) &&
                text.equals(appeal.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, text);
    }
}
