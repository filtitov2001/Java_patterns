package com.application.services;

import com.application.annotations.LogTime;
import com.application.repository.StudentRepository;
import com.application.repository.UniversityRepository;
import com.application.dto.StudentDTO;
import com.application.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;

    private final EmailService emailService;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          UniversityRepository universityRepository,
                          EmailService emailService) {
        this.studentRepository = studentRepository;
        this.universityRepository = universityRepository;
        this.emailService = emailService;
    }

    @LogTime
    @Transactional
    public List<Student> getAll() {
        log.info("Find all srudents");
        return studentRepository.findAll();
    }

    @LogTime
    @Transactional
    public void delete(int id) {
        log.info("Delete student by id: " + id);
        studentRepository.deleteById(id);
    }

    @LogTime
    @Transactional
    public void save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setUniversity(universityRepository.findByName(studentDTO.getNameUniversity()));

        log.info("Save student with ID: " + student.getId());
  //     String tmp = student.toString();

        student = studentRepository.save(student);
        emailService.sendInfoAboutSaveObject("Save: " + convert(student).toString());


    }

    public StudentDTO convert(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setMiddleName(student.getMiddleName());
        studentDTO.setId(student.getId());
        studentDTO.setNameUniversity(student.getUniversity().getName());
        return studentDTO;
    }


    @LogTime
    @Transactional
    public List<Student> filterStudents(
            String universityName, String firstName, String middleName, String lastName
    ) {
        log.info("Filter students by University Name: " + universityName +
                ", First Name:" + firstName +
                ", Middle Name=" + middleName +
                ", Last Name=" + lastName);

        return studentRepository
                .findAllStudentsByAllNames(
                        universityName, firstName, middleName, lastName);
    }
}
