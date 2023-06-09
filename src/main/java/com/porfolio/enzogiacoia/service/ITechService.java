/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.enzogiacoia.service;

import com.porfolio.enzogiacoia.model.Tech;
import java.util.List;

/**
 *
 * @author x3n0g
 */
public interface ITechService {
    
    public List<Tech> getAllTechs();
    
    public List<Tech> getTechsByPerson(Long personId);
    
    public void addTech(Tech newTech);
    
    public void editTech(Long id, Tech updatedTech);
    
    public void deleteTech(Long id);
    
}
