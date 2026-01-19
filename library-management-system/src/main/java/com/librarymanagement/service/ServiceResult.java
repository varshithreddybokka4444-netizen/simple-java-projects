package com.librarymanagement.service;

public class ServiceResult {
    private boolean isSuccess;
    private String message;
     public ServiceResult(boolean isSuccess,String message){
         this.isSuccess = isSuccess;
         this.message = message;
     }

    public boolean isSuccess() {
        return isSuccess;
    }
    public String getMessage() {
        return message;
    }
}
