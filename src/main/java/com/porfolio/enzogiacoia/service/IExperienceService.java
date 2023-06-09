/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.enzogiacoia.service;

import com.porfolio.enzogiacoia.model.Experience;
import java.util.List;

/**
 *
 * @author x3n0g
 */

public interface IExperienceService {
    
    public List<Experience> getAllExperience();
    
    public List<Experience> getExperiencesByPerson(Long id);
    
    public void addExperience(Experience newExperience);
    
    public void editExperience(Long id, Experience updatedExperience);
    
    public void deleteExperience(Long id);
}
