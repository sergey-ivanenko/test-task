package by.itechart.testtask.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "login", length = 50, nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<Salary> salaries;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cafe_user", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "cafe_id"))
    private Set<Cafe> cafes;

    @OneToMany(mappedBy = "user")
    private Set<Timesheet> timesheets;

    @OneToMany(mappedBy = "user")
    private Set<TimesheetStatus> timesheetStatuses;

    @OneToMany(mappedBy = "user")
    private Set<Ordering> orderings;

    @OneToMany(mappedBy = "user")
    private Set<AppealComment> appealComments;

    @OneToMany(mappedBy = "user")
    private Set<PurchaseStatus> purchaseStatuses;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Salary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<Salary> salaries) {
        this.salaries = salaries;
    }

    public Set<Cafe> getCafes() {
        return cafes;
    }

    public void setCafes(Set<Cafe> cafes) {
        this.cafes = cafes;
    }

    public Set<Timesheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(Set<Timesheet> timesheets) {
        this.timesheets = timesheets;
    }

    public Set<TimesheetStatus> getTimesheetStatuses() {
        return timesheetStatuses;
    }

    public void setTimesheetStatuses(Set<TimesheetStatus> timesheetStatuses) {
        this.timesheetStatuses = timesheetStatuses;
    }

    public Set<Ordering> getOrderings() {
        return orderings;
    }

    public void setOrderings(Set<Ordering> orderings) {
        this.orderings = orderings;
    }

    public Set<AppealComment> getAppealComments() {
        return appealComments;
    }

    public void setAppealComments(Set<AppealComment> appealComments) {
        this.appealComments = appealComments;
    }

    public Set<PurchaseStatus> getPurchaseStatuses() {
        return purchaseStatuses;
    }

    public void setPurchaseStatuses(Set<PurchaseStatus> purchaseStatuses) {
        this.purchaseStatuses = purchaseStatuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) &&
                fullName.equals(user.fullName) &&
                login.equals(user.login) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, login, password);
    }
}
