/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.enzogiacoia.controller;

import com.porfolio.enzogiacoia.dto.PersonDto;
import com.porfolio.enzogiacoia.model.Message;
import com.porfolio.enzogiacoia.model.Person;
import com.porfolio.enzogiacoia.service.IPersonService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author x3n0g
 */
@RestController
@CrossOrigin(origins = {"https://enzogiacoia-portfolio.web.app", "http://localhost:4200"})
public class PersonController {

    @Autowired
    private IPersonService iPerson;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> personList = iPerson.getAllPersons();

        if (personList.isEmpty()) {
            Person person = new Person();

            person.setFirstName("First name");
            person.setLastName("Last name");
            person.setTitle("Title");
            person.setAbout("About me");

            iPerson.addPerson(person);
            personList.add(person);
        }

        List<PersonDto> dtoList = new ArrayList<>();

        for (Person person : personList) {
            PersonDto personDto = new PersonDto(
                    person.getId(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getTitle(),
                    person.getAbout(),
                    person.getProfileImageUrl(),
                    person.getProfileImageName(),
                    person.getBannerImageUrl(),
                    person.getBannerImageName());

            dtoList.add(personDto);
        }
        
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        Person person = iPerson.getPerson(id);
        
        PersonDto personDto = new PersonDto(
                    person.getId(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getTitle(),
                    person.getAbout(),
                    person.getProfileImageUrl(),
                    person.getProfileImageName(),
                    person.getBannerImageUrl(),
                    person.getBannerImageName());
        
        return new ResponseEntity(personDto, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/persons")
//    public ResponseEntity<Message> addPerson(@RequestBody Person newPerson){
//        
//        if (newPerson.getFirstName().isBlank()) {
//             return new ResponseEntity(new Message("First name is required"), HttpStatus.BAD_REQUEST);
//        }
//        if (newPerson.getLastName().isBlank()) {
//             return new ResponseEntity(new Message("Last name is required"), HttpStatus.BAD_REQUEST);
//        }
//        if (newPerson.getTitle().isBlank()) {
//             return new ResponseEntity(new Message("Title is required"), HttpStatus.BAD_REQUEST);
//        }
//        
//        iPerson.addPerson(newPerson);
//        return new ResponseEntity(new Message("Person added successfully."), HttpStatus.OK);
//    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persons/{id}")
    public ResponseEntity<Message> editPerson(@PathVariable Long id, @RequestBody Person updatedPerson) {

        if (updatedPerson.getFirstName().isBlank()) {
            return new ResponseEntity(new Message("First name is required"), HttpStatus.BAD_REQUEST);
        }
        if (updatedPerson.getLastName().isBlank()) {
            return new ResponseEntity(new Message("Last name is required"), HttpStatus.BAD_REQUEST);
        }
        if (updatedPerson.getTitle().isBlank()) {
            return new ResponseEntity(new Message("Title is required"), HttpStatus.BAD_REQUEST);
        }

        iPerson.editPerson(id, updatedPerson);
        return new ResponseEntity(new Message("Person edited successfully."), HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/persons/{id}")
//    public ResponseEntity<Message> deletePerson(@PathVariable Long id){
//        iPerson.deletePerson(id);
//        return new ResponseEntity(new Message("Person deleted successfully."), HttpStatus.OK);
//    }
}
