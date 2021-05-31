package com.application.services;

import com.application.models.University;
import com.application.repository.StudentRepository;
import com.application.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UniversityService {
    private final UniversityRepository universityRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public UniversityService(UniversityRepository universityRepository,
                             StudentRepository studentDAO) {
        this.universityRepository = universityRepository;
        this.studentRepository = studentDAO;
    }

    public List<University> getAll() {
        return universityRepository.findAll();
    }

    public void delete(int id) {
        Optional<University> optionalUniversity = universityRepository.findById(id);

        if (optionalUniversity.isEmpty()) {
            return;
        }

        studentRepository.deleteAllByUniversity(optionalUniversity.get());
        universityRepository.deleteById(id);
    }

    public void save(University student) {
        universityRepository.save(student);
    }
}
