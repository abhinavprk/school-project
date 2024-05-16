package org.school.service;

import org.school.dao.School;
import org.school.dto.response.ApiError;
import org.school.dto.response.ApiResponse;
import org.school.repository.SchoolRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public ResponseEntity<ApiResponse<School>> findSchoolDetailById(Long schoolId) {
        ResponseEntity<ApiResponse<School>> response;
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if(schoolOptional.isPresent()){
            response = new ResponseEntity<>(new ApiResponse<>(schoolOptional.get(), null), HttpStatus.OK);
        }else {
            Set<ApiError> errorSet = new HashSet<>();
            errorSet.add(new ApiError("no.school.found","There is no school in the system with id: " + schoolId));
            response = new ResponseEntity<>(new ApiResponse<>(null, errorSet), HttpStatus.OK);
        }
        return response;
    }
}
