package org.school.service;

import org.school.dao.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    public School findSchoolDetailById(Long schoolId) {

        return new School();
    }
}
