package by.itechart.testtask.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RoleDto {
    private Long id;

    @NotBlank(message = "role name should be not null")
    @Size(max = 50, message = "role name should be equal to or less than {max}")
    private String name;

    public RoleDto() {
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

    @Override
    public String toString() {
        return "RoleDto: " +
                "id = " + id +
                ", name='" + name + '\'';
    }
}
