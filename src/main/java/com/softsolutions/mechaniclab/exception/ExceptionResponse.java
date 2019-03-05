package com.softsolutions.mechaniclab.exception;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "Object encapsulating the error details of a given request")
public class ExceptionResponse {

    @ApiModelProperty(value = "Date when the error occurred", example = "2019-01-29")
    private Date timestamp;

    @ApiModelProperty(value = "Text describing the error detail", example = "We could not found a Repair with id: 12")
    private String message;

    @ApiModelProperty(value = "HTTP status code", example = "400")
    private int status;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String message, int status) {
        super();
        this.timestamp = new Date();
        this.message = message;
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
