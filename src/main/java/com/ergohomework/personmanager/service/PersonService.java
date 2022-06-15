package com.ergohomework.personmanager.service;

import com.ergohomework.personmanager.domain.Person;
import com.ergohomework.personmanager.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final AuditLogService auditLogService;

    Logger logger = LoggerFactory.getLogger(PersonService.class);

    public PersonService(PersonRepository personRepository, AuditLogService auditLogService) {
        this.personRepository = personRepository;
        this.auditLogService = auditLogService;
    }

    public Person getPersonByPersonalIdAndDateOfBirth(String personalId, LocalDate dateOfBirth) {

        String logMessage = "Person was queried by personal ID: " + personalId + " and date of birth: " + dateOfBirth;
        String exceptionMessage = "User by id " + personalId + " and date of birth " + dateOfBirth + " was not found.";

        auditLogService.addLog(logMessage);
        logger.debug(logMessage);

        return personRepository
                .findByPersonalIdAndDateOfBirth(personalId, dateOfBirth)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, exceptionMessage));

    }
}
