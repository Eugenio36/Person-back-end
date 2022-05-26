package com.ergohomework.personmanager.repository;


import com.ergohomework.personmanager.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByPersonalIdAndDateOfBirth(String personalId, LocalDate dateOfBirth);

}
