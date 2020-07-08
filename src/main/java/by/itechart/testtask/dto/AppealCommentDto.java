package by.itechart.testtask.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.util.Date;

public class AppealCommentDto {
    private Long id;

    @PastOrPresent
    private Date date;

    @NotBlank(message = "comment text should not be empty or null")
    private String text;

    @Positive
    @NotNull(message = "appeal number should not be empty or null")
    private Long appealNumber;

    /*@NotBlank(message = "user name should not be empty or null")
    private String userName;*/

    @NotNull(message = "user id should not be empty or null")
    private Long userId;

    public AppealCommentDto() {
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

    public Long getAppealNumber() {
        return appealNumber;
    }

    public void setAppealNumber(Long appealNumber) {
        this.appealNumber = appealNumber;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "AppealCommentDto: " +
                "id = " + id +
                ", date = " + date +
                ", text = '" + text + '\'' +
                ", appealNumber = " + appealNumber +
                ", userId = " + userId;
    }
}
