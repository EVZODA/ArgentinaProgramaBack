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
public class PersonDto {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private String about;
    private String profileImageUrl;
    private String profileImageName;
    private String bannerImageUrl;
    private String bannerImageName;
    
}
