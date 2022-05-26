package com.ergohomework.personmanager.controller;

import com.ergohomework.personmanager.controller.PersonController;
import com.ergohomework.personmanager.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class PersonControllerUnitTest {

    @Mock
    PersonService personService;

    @InjectMocks
    PersonController personController;

    @Test
    void testFindPersonByPersonalIdAndDateOfBirth() {
        String personalId = "150497-11324";
        LocalDate dateOfBirth = LocalDate.of(1997, 04, 15);

        personController.getPersonByPersonalIdAndDateOfBirth(personalId, dateOfBirth);

        Mockito.verify(personService).getPersonByPersonalIdAndDateOfBirth(personalId, dateOfBirth);

    }
}