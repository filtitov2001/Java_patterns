package com.application.services;

import com.application.repository.StudentRepository;
import com.application.repository.UniversityRepository;
import com.application.repository.StudentFilterRepository;
import com.application.dto.StudentDTO;
import com.application.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;
    private final StudentFilterRepository studentFilterRepository;

    @Autowired
    public StudentService(StudentRepository studentDAO,
                          UniversityRepository universityRepository,
                          StudentFilterRepository studentFilterRepository) {
        this.studentRepository = studentDAO;
        this.universityRepository = universityRepository;
        this.studentFilterRepository = studentFilterRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }

    public void save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setMiddleName(studentDTO.getMiddleName());
        student.setUniversity(universityRepository.findByName(studentDTO.getNameUniversity()));
        studentRepository.save(student);
    }

    public List<Student> filterStudents(
            String universityName, String firstName, String middleName, String lastName
    ) {
        return studentFilterRepository
                .findAllStudentsByAllNames(
                        universityName, firstName, middleName, lastName);
    }
}
