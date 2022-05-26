package com.ergohomework.personmanager.controller;

import com.ergohomework.personmanager.domain.Person;
import com.ergohomework.personmanager.service.PersonService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Person getPersonByPersonalIdAndDateOfBirth(
            @RequestParam("personalId") String personalId,
            @RequestParam("dateOfBirth") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfBirth) {
        return personService.getPersonByPersonalIdAndDateOfBirth(personalId, dateOfBirth);
    }

}
