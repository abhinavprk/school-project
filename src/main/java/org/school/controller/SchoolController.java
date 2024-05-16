package org.school.controller;

import org.school.dao.School;
import org.school.dto.response.ApiResponse;
import org.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/school")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping(path = "/{schoolId}")
    private ResponseEntity<ApiResponse<School>> getSchoolDetail(@PathVariable(value = "schoolId") Long schoolId){
        return schoolService.findSchoolDetailById(schoolId);
    }
}
