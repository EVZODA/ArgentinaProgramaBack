/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.enzogiacoia.controller;

import com.porfolio.enzogiacoia.dto.ProjectDto;
import com.porfolio.enzogiacoia.model.Message;
import com.porfolio.enzogiacoia.model.Person;
import com.porfolio.enzogiacoia.model.Project;
import com.porfolio.enzogiacoia.service.IPersonService;
import com.porfolio.enzogiacoia.service.IProjectService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author x3n0g
 */
@RestController
@CrossOrigin(origins = {"https://enzogiacoia-portfolio.web.app", "http://localhost:4200"})
public class ProjectController {

    @Autowired
    IPersonService iPerson;

    @Autowired
    IProjectService iProject;

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllProject() {
        List<Project> projectList = iProject.getAllProjects();
        List<ProjectDto> dtoList = new ArrayList<>();

        for (Project project : projectList) {
            ProjectDto projectDto = new ProjectDto(
                    project.getId(),
                    project.getName(),
                    project.getDescription(),
                    project.getUrl(),
                    project.getPerson().getId());

            dtoList.add(projectDto);
        }
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @GetMapping("persons/{personId}/projects")
    public ResponseEntity<List<ProjectDto>> getPersonProjects(@PathVariable Long personId) {
        List<Project> projectList = iProject.getProjectsByPerson(personId);
        List<ProjectDto> dtoList = new ArrayList<>();

        for (Project project : projectList) {
            ProjectDto projectDto = new ProjectDto(
                    project.getId(),
                    project.getName(),
                    project.getDescription(),
                    project.getUrl(),
                    project.getPerson().getId());

            dtoList.add(projectDto);
        }
        return new ResponseEntity(dtoList, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("persons/{personId}/projects")
    public ResponseEntity<Message> addProject(@PathVariable Long personId, @RequestBody Project newProject) {
        if (newProject.getName().isBlank()) {
            return new ResponseEntity(new Message("Project name is required"), HttpStatus.BAD_REQUEST);
        }
        if (newProject.getDescription().isBlank()) {
            return new ResponseEntity(new Message("Description is required"), HttpStatus.BAD_REQUEST);
        }
        if (newProject.getUrl().isBlank()) {
            return new ResponseEntity(new Message("Project url is required"), HttpStatus.BAD_REQUEST);
        }
        if (!newProject.getUrl().contains("https://github.com")) {
            return new ResponseEntity(new Message("Sorry, that's is not a valid github url"), HttpStatus.BAD_REQUEST);
        }

        Person person = iPerson.getPerson(personId);
        newProject.setPerson(person);

        iProject.addProject(newProject);
        return new ResponseEntity(new Message("Project added successfully."), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/projects/{id}")
    public ResponseEntity<Message> editProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        if (updatedProject.getName().isBlank()) {
            return new ResponseEntity(new Message("Project name is required"), HttpStatus.BAD_REQUEST);
        }
        if (updatedProject.getDescription().isBlank()) {
            return new ResponseEntity(new Message("Description is required"), HttpStatus.BAD_REQUEST);
        }
        if (updatedProject.getUrl().isBlank()) {
            return new ResponseEntity(new Message("Project url is required"), HttpStatus.BAD_REQUEST);
        }
        if (!updatedProject.getUrl().contains("https://github.com")) {
            return new ResponseEntity(new Message("Sorry, that's is not a valid github url"), HttpStatus.BAD_REQUEST);
        }

        iProject.editProject(id, updatedProject);
        return new ResponseEntity(new Message("Project updated successfully."), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Message> deleteProject(@PathVariable Long id) {
        iProject.deleteProject(id);
        return new ResponseEntity(new Message("Project deleted successfully."), HttpStatus.OK);
    }

}
