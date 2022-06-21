package com.spring.springboot.db.controller;

import com.spring.springboot.db.model.TeacherModel;
import com.spring.springboot.db.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createresource", method = RequestMethod.POST)
    public String createTeacher(@RequestBody TeacherModel teacherModel){
        return teacherService.createResource(teacherModel);
    }

    @RequestMapping(value = "readresources", method = RequestMethod.GET)
    public List<TeacherModel> readResources(){
        return teacherService.readResources();
    }

    @RequestMapping(value = "updateresource", method = RequestMethod.PUT)
    public String updateTeacher(@RequestBody TeacherModel teacherModel){
        return teacherService.updateResource(teacherModel);
    }

    @RequestMapping(value = "deleteresource", method = RequestMethod.DELETE)
    public String deleteTeacher(@RequestBody TeacherModel teacherModel){
        return teacherService.deleteResource(teacherModel);
    }

}
