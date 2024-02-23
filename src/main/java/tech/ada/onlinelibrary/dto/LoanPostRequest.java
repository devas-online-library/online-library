package tech.ada.onlinelibrary.dto;


import tech.ada.onlinelibrary.domain.enums.Genre;

import java.time.LocalDate;
import java.time.Year;
import java.util.Objects;

public class LoanPostRequest {

    private Long userId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanPostRequest(Long userId, LocalDate loanDate, LocalDate returnDate) {
        this.userId = Objects.requireNonNull(userId);
        this.loanDate = Objects.requireNonNull(loanDate);
        this.returnDate = Objects.requireNonNull(returnDate);
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}