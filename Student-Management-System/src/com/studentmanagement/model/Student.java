package com.studentmanagement.model;
import java.util.HashMap;
import java.util.Map;


public class Student
{
   private String name;
   private String id;
   private Map<String,Integer> marks ;
   private char grade;

    public Student(String name,String id, Map<String,Integer> marks,char grade) {
        this.name = name;
        this.id = id;
        this.marks = marks;
        this.grade = grade;
    }

    public String getName()
    {
        return name;
    }

    public String getId()
    {
        return id;
    }

    public Map<String,Integer> getMarks()
    {
        return marks;
    }

    public double getGrade()
    {
  return grade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Student ID: ").append(id).append("\n");
        sb.append("Name: ").append(name).append("\n");
        sb.append("Grade: ").append(grade).append("\n");
        sb.append("Marks:\n");

        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            sb.append("  ")
                    .append(entry.getKey())
                    .append(" : ")
                    .append(entry.getValue())
                    .append("\n");
        }

        return sb.toString();
    }

}