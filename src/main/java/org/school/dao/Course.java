package org.school.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
    private Long name;

    @Column(name = "description", nullable = false, columnDefinition = "VARCHAR(250)")
    private String description;

    @ManyToMany(mappedBy = "courseList")
    private Set<Instructor> instructorList;

    @ManyToOne
    @JoinColumn(name = "school_id", nullable = false, referencedColumnName = "id")
    private School school;

}
