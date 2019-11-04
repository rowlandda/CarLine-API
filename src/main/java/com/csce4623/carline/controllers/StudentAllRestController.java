package com.csce4623.carline.controllers;

import com.csce4623.carline.models.LineStudent;
import com.csce4623.carline.models.Student;

import com.csce4623.carline.repositories.StudentsAllRepository;
import com.csce4623.carline.repositories.StudentsLineRepository;
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
    private StudentsAllRepository studentsAllRepository;
    @Autowired
    private StudentsLineRepository studentsLineRepository;

    //return list of all students
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> getAllStudents() {
        List<Student> students = studentsAllRepository.findAll();
        if (students == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

    //get specific student by _id
    @RequestMapping(value = "/all/{_id}", method = RequestMethod.GET)
    public ResponseEntity<?> getStudentById(@PathVariable("_id") String _id) {
        Student student = studentsAllRepository.findBy_id(_id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
    }

    //add a student to the carline
    @RequestMapping(value = "/line/{_id}", method = RequestMethod.POST)
    public ResponseEntity<?> addStudentToLine(@PathVariable("_id") String _id) {
        Student student = studentsAllRepository.findBy_id(_id);
        LineStudent lineStudent = new LineStudent(student);
        return new ResponseEntity<>(studentsLineRepository.save(lineStudent), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/line/{_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteStudentFromLine(@PathVariable("_id") String _id) {
        studentsLineRepository.delete(studentsLineRepository.findBy_id(_id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

