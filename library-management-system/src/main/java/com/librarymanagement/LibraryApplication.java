package com.librarymanagement;

import com.librarymanagement.model.Book;
import com.librarymanagement.repository.BookCopyRepository;
import com.librarymanagement.repository.BookRepository;
import com.librarymanagement.repository.LoanRepository;
import com.librarymanagement.repository.MemberRepository;
import com.librarymanagement.service.CatalogService;
import com.librarymanagement.service.CirculationService;
import com.librarymanagement.service.MemberService;

import java.util.Scanner;

public class LibraryApplication {
    public static void main(String[] args){
        BookRepository bookRepository = new BookRepository();
        BookCopyRepository bookCopyRepository = new BookCopyRepository();
        MemberRepository memberRepository = new MemberRepository();
        LoanRepository loanRepository = new LoanRepository();

        CirculationService circulationService = new CirculationService(memberRepository,bookCopyRepository, loanRepository);
        CatalogService catalogService = new CatalogService(bookRepository,bookCopyRepository);
        MemberService memberService = new MemberService(memberRepository);

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Welcome to Library");
            System.out.println("===== Library System =====");
            System.out.println("1. Add Book");
            System.out.println("1. Update Book");
            System.out.println("3. Add Book Copy");
            System.out.println("4. Add Member");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");

            System.out.println("Select any of the options");

            int choice = sc.nextInt();

            switch(choice){

                case 1 :
                    System.out.println("Enter Title of the Book :");
                    String title = sc.nextLine();
                    System.out.println("Enter Author Name/Names");
                    String author = sc.nextLine();
                    System.out.println("Enter name of the publishers ");
                    String publisher = sc.nextLine();
                    System.out.println("Please Enter isbn");
                    String isbn = sc.nextLine();
                    try {
                        catalogService.addBook(new Book(title, author, publisher, isbn));
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Please Enter isbn of the book to be updated :");
                    String isbnOfBookToBeUpdated = sc.nextLine();
                    System.out.println("Enter Title of the Book or enter null if updation not needed :");
                    String updatedTitle = sc.nextLine();
                    System.out.println("Enter Author Name/Names or enter null if updation not needed :");
                    String updatedAuthor = sc.nextLine();
                    System.out.println("Enter name of the publishers or enter null if updation not needed :");
                    String updatedPublisher = sc.nextLine();

                    try {
                        catalogService.updateBook(updatedTitle,updatedAuthor,updatedPublisher,isbnOfBookToBeUpdated);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Please Enter isbn of the book copy :");
                    String bookCopyIsbn = sc.nextLine();
                    try {
                        catalogService.addBookCopy(bookCopyIsbn);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4 :
                    sc.nextLine();
                    System.out.println("Please choose member type : ");
                    System.out.println("1.Student");
                    System.out.println("2.Faculty");
                    System.out.println("3.other");
                    int memberTypeChoice = sc.nextInt();
                    String memberType = "";
                    if(memberTypeChoice==1){
                        memberType = "Student";
                    }
                    else if(memberTypeChoice==2){
                        memberType = "Faculty";
                    }
                    else if(memberTypeChoice==3){
                        memberType = "Other";
                    }
                    System.out.println("Please enter your name :");
                    String name = sc.nextLine();
                    System.out.println("Please enter your email :");
                    String email = sc.nextLine();
                    try {
                        memberService.addMember(memberType, name, email);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Please enter Id of Copy to be issued:");
                    String bookCopyToIssue = sc.nextLine();
                    System.out.println("Please enter Id of member :");
                    String member = sc.nextLine();
                    try{
                        circulationService.issueBook(member,bookCopyToIssue);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6 :
                    sc.nextLine();
                    System.out.println("Please enter Id of Copy to be returned:");
                    String returningCopy = sc.nextLine();
                    try{
                        circulationService.returnBook(returningCopy);
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    running = false;
                    break;


            }




        }


    }
}
