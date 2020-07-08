package by.itechart.testtask.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.util.Date;
import java.util.Set;

public class AppealDto {
    private Long id;

    @PastOrPresent
    private Date date;

    @NotBlank(message = "appeal text should be not empty or null")
    private String text;

    @NotNull(message = "cafe id should be not empty or null")
    private Long cafeId;

    //@NegativeOrZeroValue
    @Positive
    @NotNull(message = "enter value")
    private Long orderingNumber;

    @Valid
    private Set<AppealCommentDto> appealComments;

    public AppealDto() {
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

    public Long getCafeId() {
        return cafeId;
    }

    public void setCafeId(Long cafeId) {
        this.cafeId = cafeId;
    }

    public Long getOrderingNumber() {
        return orderingNumber;
    }

    public void setOrderingNumber(Long orderingNumber) {
        this.orderingNumber = orderingNumber;
    }

    public Set<AppealCommentDto> getAppealComments() {
        return appealComments;
    }

    public void setAppealComments(Set<AppealCommentDto> appealComments) {
        this.appealComments = appealComments;
    }

    @Override
    public String toString() {
        return "AppealDto:" +
                "id = " + id +
                ", date = " + date +
                ", text = '" + text + '\'' +
                ", cafeId = '" + cafeId + '\'' +
                ", orderingNumber = " + orderingNumber +
                ", appealComments = " + appealComments;
    }
}
