package com.wonmocyberschool.imageserver.DTO;

public class ResponseDTO {
    private String message;
    private String imageLocation;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }
}