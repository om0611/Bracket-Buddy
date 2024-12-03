package com.example.csc207courseproject.data_access.api;

import com.example.csc207courseproject.data_access.DataAccessException;

public class APIDataAccessException extends DataAccessException {
    /**
     * Construct a new APIDataAccessException with the given error message.
     *
     * @param errorMessage the error message.
     */
    public APIDataAccessException(String errorMessage) {
        super(errorMessage);
    }
}
