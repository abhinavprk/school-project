package org.school.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Set;

@Entity
@Table(name = "school")
@Getter
@Setter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(100)")
    private String name;

    @OneToOne(mappedBy = "school")
    @JsonIgnoreProperties("school")
    private Dean dean;

    @OneToMany(mappedBy = "school")
    @JsonIgnoreProperties("school")
    private Set<Instructor> instructors;

    @OneToMany(mappedBy = "school")
    @JsonIgnoreProperties("school")
    private Set<Course> courses;

}
