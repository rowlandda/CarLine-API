package com.csce4623.carline.controllers;

import com.csce4623.carline.models.Student;

import com.csce4623.carline.repositories.StudentsAllRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class StudentAllRestController {
    @Autowired
    private StudentsAllRepository repository;

    //return list of all students
    @RequestMapping(value = "/all/students", method = RequestMethod.GET)
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = repository.findAll();
        if (students == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

    //get specific student by _id
    @RequestMapping(value = "/all/students/{_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentById(@PathVariable("_id") String _id) {
        Student student = repository.findBy_id(_id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }
}

