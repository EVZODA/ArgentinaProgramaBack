/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.enzogiacoia.repository;

import com.porfolio.enzogiacoia.model.Tech;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author x3n0g
 */

@Repository
public interface TechRepository extends JpaRepository<Tech, Long> {
    
    public List<Tech> findByPersonId(Long id);
    
}
