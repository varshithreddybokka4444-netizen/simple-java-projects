package com.librarymanagement.service;

public class Validator {
    public void validate(String data,String dataType){
        if(data==null||data.isBlank()){
            System.out.println(dataType + " cannot be null or blank");
            return;
        }
    }
}
