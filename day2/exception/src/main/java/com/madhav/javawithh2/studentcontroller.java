package com.madhav.javawithh2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class studentcontroller {
    private List<student> students=new ArrayList<>();
    public studentcontroller(){
        students.add(new student(1,"Madhav"));
        students.add(new student(2,"SP"));
        
    }
    @GetMapping("/student/{id}")
    public student getStudentById(@PathVariable int id){
        for(student s:students){
            if(s.getId()==id){
                return s;
            }
        }
        throw new studentnotfoundexc("Student not found with this id "+id);
    }
}