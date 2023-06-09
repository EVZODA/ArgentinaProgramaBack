/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.enzogiacoia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author x3n0g
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ProjectDto {
    
    private Long id;
    private String name;
    private String description;
    private String url;
    private Long personId;
    
}
