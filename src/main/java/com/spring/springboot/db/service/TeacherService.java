package com.spring.springboot.db.service;

import com.spring.springboot.db.document.Subject;
import com.spring.springboot.db.entity.Teacher;
import com.spring.springboot.db.model.SubjectModel;
import com.spring.springboot.db.model.TeacherModel;
import com.spring.springboot.db.repository.SubjectRepository;
import com.spring.springboot.db.repository.TeacherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Transactional
    public String  createResource(TeacherModel teacherModel){
        if (!teacherRepository.existsByEmail(teacherModel.getEmail())){
            Teacher teacher = new Teacher();
            BeanUtils.copyProperties(teacherModel, teacher);
            try {
                teacherRepository.save(teacher);
                teacherModel.getSubjects().stream().forEach(c -> {
                    Subject subject = new Subject();
                    c.setEmail(teacherModel.getEmail());
                    BeanUtils.copyProperties(c, subject);
                    try {
                        subjectRepository.save(subject);

                    }catch (Exception e){
                        throw e;
                    }

                });
            }catch (Exception e){
                throw e;
            }

            return "Resource added successfully!";
        }else {
            return "Duplicate resource";
        }
    }

    public List<TeacherModel> readResources(){
        List<TeacherModel> teachers = new ArrayList<>();
        List<Teacher> teacherList = new ArrayList<>();
        try {
            teacherList = teacherRepository.findAll(); //Fetch all the Students from the database.
        }catch (Exception e){
            throw e;
        }

        if (teacherList.size() > 0){ //If the above list is not empty then return the list after unwrapping all the records
            teacherList.stream().forEach(s -> { //Traverse through the reords
                TeacherModel teacherModel = new TeacherModel();
                teacherModel.setFirstName(s.getFirstName());
                teacherModel.setLastName(s.getLastName());
                teacherModel.setEmail(s.getEmail());
                teacherModel.setDepartmentName(s.getDepartmentName());
                teacherModel.setEmploymentType(s.getEmploymentType());
                List<Subject> subjectList = new ArrayList<>();
                List<SubjectModel> subjects = new ArrayList<>();
                try {
                    subjectList = subjectRepository.findCourseByEmail(s.getEmail()); //Fetch all the courses by email ID.
                }catch (Exception e){
                    throw e;
                }
                if (subjectList.size() > 0){
                    subjectList.stream().forEach(c -> {
                        SubjectModel subjectModel = new SubjectModel();
                        BeanUtils.copyProperties(c, subjectModel);
                        subjects.add(subjectModel);
                    });
                }
                teacherModel.setSubjects(subjects);
                teachers.add(teacherModel);
            });
        }
        return teachers;
    }

    @Transactional
    public String updateResource(TeacherModel teacherModel){
        if (teacherRepository.existsByEmail(teacherModel.getEmail())){ //Check for availability of resource by email ID. Update if resource exists.
            Teacher teacher= teacherRepository.findByEmail(teacherModel.getEmail()).get(0);
            BeanUtils.copyProperties(teacherModel, teacher);
            try {
                teacherRepository.save(teacher); //Update Teacher
                List<Subject> subjects = subjectRepository.findCourseByEmail(teacherModel.getEmail()); //Read the courses from the database
                for (int i = 0; i < teacherModel.getSubjects().size(); i++){
                    BeanUtils.copyProperties(teacherModel.getSubjects().get(i),subjects.get(i));
                }

                subjects.stream().forEach(c -> {
                    Subject subject = subjectRepository.findById(c.getId()).get();
                    BeanUtils.copyProperties(c, subject);
                    subject.setEmail(teacherModel.getEmail());
                    subjectRepository.save(subject);
                });
            }catch (Exception e){
                throw e;
            }
            return "Resource was updated successfully";
        }else{
            return "Resource does not exist";
        }
    }

    @Transactional
    public String deleteResource(TeacherModel teacherModel){
        if (teacherRepository.existsByEmail(teacherModel.getEmail())){
            try {
                teacherRepository.deleteByEmail(teacherModel.getEmail());
                try {
                    subjectRepository.deleteByEmail(teacherModel.getEmail());
                }catch (Exception e){
                    throw e;
                }
            }catch (Exception e){
                throw e;
            }
            return "Removed successfully!";
        }else {
            return "Resource does not exist.";
        }
    }

}
