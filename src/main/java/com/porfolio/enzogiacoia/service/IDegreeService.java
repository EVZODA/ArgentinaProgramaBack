/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.enzogiacoia.service;

import com.porfolio.enzogiacoia.model.Degree;
import java.util.List;

/**
 *
 * @author x3n0g
 */
public interface IDegreeService {
    
    public List<Degree> getAllDegrees();
    
    public List<Degree> getDegreesByPerson(Long id);
    
    public void addDegree(Degree newDegree);
    
    public void editDegree(Long id, Degree updatedDegree);
    
    public void deleteDegree(Long id);
    
}
