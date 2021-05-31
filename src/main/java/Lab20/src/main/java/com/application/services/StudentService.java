package com.application.services;

import com.application.annotations.LogTime;
import com.application.repository.StudentRepository;
import com.application.repository.UniversityRepository;
import com.application.dto.StudentDTO;
import com.application.models.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                          UniversityRepository universityRepository) {
        this.studentRepository = studentRepository;
        this.universityRepository = universityRepository;
    }

    @LogTime
    public List<Student> getAll() {
        log.info("Find all srudents");
        return studentRepository.findAll();
    }

    @LogTime
    public void delete(int id) {
        log.info("Delete student by id: " + id);
        studentRepository.deleteById(id);
    }

    @LogTime
    public void save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setUniversity(universityRepository.findByName(studentDTO.getNameUniversity()));

        log.info("Save student with id: " + student.getId());
        student = studentRepository.save(student);


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
    public List<Student> filterStudents(
            String universityName, String firstName, String middleName, String lastName
    ) {
        log.info("Filter students by universityName=" + universityName +
                ", firstName=" + firstName +
                ", middleName=" + middleName +
                ", lastName=" + lastName);

        return studentRepository
                .findAllStudentsByAllNames(
                        universityName, firstName, middleName, lastName);
    }
}
