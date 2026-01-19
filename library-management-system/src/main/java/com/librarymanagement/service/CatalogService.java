package com.librarymanagement.service;
import com.librarymanagement.model.*;

public class CatalogService {

    public ServiceResult addBook(String title,String author,String publisher,String isbn){
        if(title==null){
            return new ServiceResult(false,"Invalid Book title!");
        }
        else if(author==null){
            return new ServiceResult(false,"Invalid Author name!");
        }
        else if(publisher==null){
            return new ServiceResult(false,"Invalid publisher name!");
        }
        else if(isbn==null){
            return new ServiceResult(false,"Invalid ISBN number!");
        }

        Book book = new Book(title,author,publisher,isbn);

    }
    public boolean issueBook(String isbn){
    return true;
    }
}






