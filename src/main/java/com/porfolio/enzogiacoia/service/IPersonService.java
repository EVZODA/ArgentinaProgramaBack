/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.enzogiacoia.service;

import com.porfolio.enzogiacoia.model.Person;
import java.util.List;

/**
 *
 * @author x3n0g
 */
public interface IPersonService {
    
    public List<Person> getAllPersons();
    
    public Person getPerson(Long id);
    
    public void addPerson(Person person);
    
    public void editPerson(Long id, Person person);
    
    public void deletePerson(Long id);
    
}
