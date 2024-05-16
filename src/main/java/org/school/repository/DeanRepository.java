package org.school.repository;

import org.school.dao.Dean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeanRepository extends JpaRepository<Dean, Long> {
}
