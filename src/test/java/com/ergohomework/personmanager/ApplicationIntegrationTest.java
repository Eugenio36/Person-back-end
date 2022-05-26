package com.ergohomework.personmanager;

import com.ergohomework.personmanager.controller.PersonController;
import com.ergohomework.personmanager.domain.AuditLog;
import com.ergohomework.personmanager.domain.Gender;
import com.ergohomework.personmanager.domain.Person;
import com.ergohomework.personmanager.repository.AuditLogRepository;
import com.ergohomework.personmanager.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationIntegrationTest {

    @Autowired
    PersonController personController;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AuditLogRepository auditLogRepository;

    @Test
    void getPersonByPersonalIdAndDateOfBirth() {
        String personalId = "150497-11355";
        LocalDate dateOfBirth = LocalDate.of(2000, 1, 1);

        personRepository.save(new Person(
                personalId,
                "John",
                "Williamson",
                Gender.MALE,
                dateOfBirth));

        Person person = personController.getPersonByPersonalIdAndDateOfBirth(personalId, dateOfBirth);

        List<AuditLog> savedLogs = auditLogRepository.findAll();

        String expectedLogAction = "Person was queried by personal ID: " + personalId + " and date of birth: " + dateOfBirth;

        assertNotNull(person);
        assertEquals(person.getDateOfBirth(), dateOfBirth);

        assertEquals(1, savedLogs.size());
        assertEquals(expectedLogAction, savedLogs.get(0).getAction());

    }
}