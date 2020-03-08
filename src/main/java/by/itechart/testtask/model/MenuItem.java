package by.itechart.testtask.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "menu_item")
public class MenuItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "is_actually", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActually;

    @ManyToMany(mappedBy = "menuItems")
    private List<Ordering> orderings;

    @OneToMany(mappedBy = "menuItem")
    private Set<Ingredient> ingredients;

    public MenuItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActually() {
        return isActually;
    }

    public void setActually(Boolean actually) {
        isActually = actually;
    }

    public List<Ordering> getOrderings() {
        return orderings;
    }

    public void setOrderings(List<Ordering> orderings) {
        this.orderings = orderings;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return id.equals(menuItem.id) &&
                name.equals(menuItem.name) &&
                price.equals(menuItem.price) &&
                isActually.equals(menuItem.isActually);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, isActually);
    }
}
