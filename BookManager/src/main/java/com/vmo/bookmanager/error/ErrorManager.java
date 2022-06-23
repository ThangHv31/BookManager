package com.vmo.bookmanager.error;

import java.util.List;

public class ErrorManager {
    private Boolean status;
    private List<Error> errors;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }
}
