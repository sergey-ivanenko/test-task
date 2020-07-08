package by.itechart.testtask.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CafeDto {
    private Long id;

    @NotBlank(message = "cafe name should not be null or empty")
    @Size(min = 1, max = 50, message = "cafe name should be equal to or greater than {min} and less than {max}")
    private String name;

    public CafeDto() {
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
        return "CafeDto: " +
                "id = " + id +
                ", name = '" + name + '\'';
    }
}
