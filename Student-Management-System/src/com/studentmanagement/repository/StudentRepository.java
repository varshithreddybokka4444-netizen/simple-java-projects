package com.studentmanagement.repository;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import com.studentmanagement.model.*;

public class StudentRepository {
    List<Student> Students ;
    public StudentRepository(){
        Students = new ArrayList<>();
    }
    public void addStudent(Student student){
        Students.add(student);
    }
    public Student findStudentById(String id){
        for(Student s : Students){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }

    public List<Student> getStudents() {

        return Collections.unmodifiableList(Students);
    }
    public boolean removeStudentbyId(String id) {
        boolean result = false;
        for(Student s : Students){
            if(s.getId().equals(id)){
               Students.remove(s);
               return true;
            }
        }
        return false;
    }
}

