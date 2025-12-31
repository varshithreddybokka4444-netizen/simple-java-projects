package com.studentmanagement.service;
import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentRepository;

import java.util.List;
import java.util.Map;

public class StudentService   {

    StudentRepository repo = new StudentRepository();

    public ServiceResult addStudent(String name,String id, Map<String,Integer> marks) {
        if (name == null||name.isEmpty()) {
            return new ServiceResult(false, "Name is empty");
        }
        if (id == null||id.isEmpty()) {
            return  new ServiceResult(false, "Id is empty");
        }
        if (marks == null||marks.isEmpty()) {
            return new ServiceResult(false, "Marks is empty");
        }

        int sum = 0;
        int count = 0;
        for (String subject : marks.keySet()) {
            int mark = marks.get(subject);
            if (mark < 0 || mark > 100) {
                return new ServiceResult(false, subject + " mark is invalid");
            }
            sum += mark;
            count++;
        }

        int avg = sum / count;
        char grade = 'A';

        if(avg>= 90) grade ='A';
        else if(avg>= 75) grade ='B';
        else if(avg>= 60) grade ='C';
        else if(avg>= 40) grade ='D';
        else grade ='F';


        Student s = new Student(name, id, marks, grade);
        repo.addStudent(s);

        return new ServiceResult(true, "Student added successfully");
    }
    public ServiceResult updateStudent(String name,String id,Map<String,Integer> marks) {
        Student s = repo.findStudentById(id);
        if(s==null){

            return  new ServiceResult(false, "Student not found");
        }
        if (name == null||name.isEmpty()) {

            return new ServiceResult(false,"Name is empty");
        }
        if (marks == null||marks.isEmpty()) {

            return new ServiceResult(false, "Marks invalid");
        }

        int sum = 0;
        int count = 0;
        for (String subject : marks.keySet()) {
           int mark = marks.get(subject);
            if (mark < 0||mark>100) {
                return new ServiceResult(false,subject+" Mark is Invalid ");
            }
            sum += mark;
            count++;
        }

        int avg = sum / count;
        char grade = 'A';

        if(avg>= 90) grade ='A';
        else if(avg>= 75) grade ='B';
        else if(avg>= 60) grade ='C';
        else if(avg>= 40) grade ='D';
        else grade ='F';



            repo.removeStudentbyId(id);
            Student s2 = new Student(name, id, marks, grade);
            repo.addStudent(s2);
            return new ServiceResult(true,"Student updated successfully");

    }
    public ServiceResult deleteStudentByID(String id){
    if(repo.removeStudentbyId(id)){
    return new ServiceResult(true,"Student deleted successfully");
    }
    return new ServiceResult(false,"Student not found");

    }
    public List<Student> printAllStudents(){
       return repo.getStudents();
    }
    public Map<String,Integer> printStudentMarksByID(String id){
        Student s = repo.findStudentById(id);

        return s.getMarks();
    }

}