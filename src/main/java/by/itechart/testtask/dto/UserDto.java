package by.itechart.testtask.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserDto {
    private Long id;

    @NotBlank(message = "full name should be not null")
    @Size(min = 2, max = 50, message = "full name should be equal to or greater than {min} and less than {max}")
    private String fullName;

    @NotBlank(message = "login should be not null")
    @Size(min = 2, max = 50, message = "login should be equal to or greater than {min} and less than {max}")
    private String login;

    @NotBlank
    @Size(min = 5, max = 255, message = "password should be equal to or greater than {min} and less than {max}")
    private String password;

    @NotBlank
    @Size(min = 5, max = 255, message = "password should be equal to or greater than {min} and less than {max}")
    private String confirmPassword;

    @Valid
    private Set<RoleDto> roles;

    @Valid
    private Set<CafeDto> cafes;

    public UserDto() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<RoleDto> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles) {
        this.roles = roles;
    }

    public Set<CafeDto> getCafes() {
        return cafes;
    }

    public void setCafes(Set<CafeDto> cafes) {
        this.cafes = cafes;
    }

    @Override
    public String toString() {
        return "UserDto: " +
                "id = " + id +
                ", fullName = '" + fullName + '\'' +
                ", login = '" + login + '\'' +
                ", password = '" + password + '\'' +
                ", roles = " + roles +
                ", cafes = " + cafes +
                '}';
    }
}
