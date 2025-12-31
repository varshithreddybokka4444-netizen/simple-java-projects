package com.studentmanagement.app;

import com.studentmanagement.model.Student;
import com.studentmanagement.service.ServiceResult;
import com.studentmanagement.service.StudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
     Scanner input = new Scanner(System.in);
        StudentService studentService = new StudentService();
        boolean exit = false;
     while(!exit){
         System.out.println("---Student Management System---");
         System.out.println("1.Add Student");
         System.out.println("2.Update Student");
         System.out.println("3.Delete Student");
         System.out.println("4.Print marks of Student");
         System.out.println("5.Print marks of all Students");
         System.out.println("6.Exit");
         System.out.print("Please choose an option :");
         int option = input.nextInt();
         switch(option){
             case 1:
                 System.out.println("Enter Student ID");
                 String id = input.next();
                 System.out.println("Enter Student Name");
                 String name = input.next();
                 Map<String,Integer> marks = new HashMap<>();
                System.out.println("please enter number of subjects");
                int num = input.nextInt();
                for(int i=0;i<num;i++){
                    System.out.println("Enter subject name");
                    String subject = input.next();
                    System.out.println("Enter subject marks");
                    int mark = input.nextInt();

                         marks.put(subject,mark);
                }

                ServiceResult sr = studentService.addStudent(name,id,marks);
                System.out.println(sr.getMessage());
                 if(sr.isSuccess()){
                     System.out.println("Student successfully Added!");
                 }
                 else{
                     System.out.println("Student failed to Add!");
                 }
                break;

             case 2:
                 System.out.println("Enter Student ID");
                 String id2 = input.next();
                 System.out.println("Enter Student Name");
                 String updatedName = input.next();
                 Map<String,Integer> marks2 = new HashMap<>();
                 System.out.println("please enter number of subjects");
                 int n = input.nextInt();
                 for(int i=0;i<n;i++){
                     System.out.println("Enter Updatedsubject name");
                     String subject = input.next();
                     System.out.println("Enter Updatedsubject marks");
                     int mark = input.nextInt();

                     marks2.put(subject,mark);
                 }

                ServiceResult sr2 = studentService.updateStudent(updatedName,id2,marks2);
                 System.out.println(sr2.getMessage());
                 if(sr2.isSuccess()){
                     System.out.println("Student successfully updated");
                 }
                 else{
                     System.out.println("Student failed to update");
                 }
                 break;

             case 3:
                 System.out.println("Enter Student ID to be deleted");
                 String id3 = input.next();
                 ServiceResult sr3 = studentService.deleteStudentByID(id3);
                 System.out.println(sr3.getMessage());
                 if(sr3.isSuccess()){
                     System.out.println("Student successfully deleted");
                 }
                 else{
                     System.out.println("Delete student failed");
                 }
                 break;
             case 4:
              System.out.println("Enter Student ID ");
              String id4 = input.next();
             System.out.println(studentService.printStudentMarksByID(id4));
                 break;
                 case 5:
                  List<Student> students = studentService.printAllStudents();
                  for(Student s: students){
                      System.out.println(s);
                  }
                     break;
             case 6:
                 System.out.println("Thank you for using this program");
                 System.exit(0);

             default:
                 System.out.println("Invalid input");
                 break;
         }


     }

    }
}
