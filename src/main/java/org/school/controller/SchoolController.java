package org.school.controller;

import org.school.dao.School;
import org.school.service.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping(path = "/{schoolId}")
    private ResponseEntity<School> getSchoolDetail(@PathVariable(value = "schoolId") Long schoolId){
        School school = schoolService.findSchoolDetailById(schoolId);
        return new ResponseEntity<>(school, HttpStatus.OK);
    }
}
