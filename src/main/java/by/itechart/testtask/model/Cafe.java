package by.itechart.testtask.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cafe")
public class Cafe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "cafes")
    private Set<User> users;

    @OneToMany(mappedBy = "cafe")
    private Set<Storage> storages;

    @OneToMany(mappedBy = "cafe")
    private Set<Balance> balances;

    @OneToMany(mappedBy = "cafe")
    private List<BalanceChange> balanceChanges;

    @OneToMany(mappedBy = "cafe"/*, cascade = CascadeType.ALL*/)
    private List<Appeal> appeals;

    public Cafe() {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Storage> getStorages() {
        return storages;
    }

    public void setStorages(Set<Storage> storages) {
        this.storages = storages;
    }

    public Set<Balance> getBalances() {
        return balances;
    }

    public void setBalances(Set<Balance> balances) {
        this.balances = balances;
    }

    public List<BalanceChange> getBalanceChanges() {
        return balanceChanges;
    }

    public void setBalanceChanges(List<BalanceChange> balanceChanges) {
        this.balanceChanges = balanceChanges;
    }

    public List<Appeal> getAppeals() {
        return appeals;
    }

    public void setAppeals(List<Appeal> appeals) {
        this.appeals = appeals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return id.equals(cafe.id) &&
                name.equals(cafe.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
