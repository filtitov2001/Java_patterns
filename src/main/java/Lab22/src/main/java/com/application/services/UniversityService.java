package com.application.services;

import com.application.annotations.LogTime;
import com.application.dto.StudentDTO;
import com.application.dto.UniversityDTO;
import com.application.models.Student;
import com.application.models.University;
import com.application.repository.StudentRepository;
import com.application.repository.UniversityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UniversityService {
    private final UniversityRepository universityRepository;
    private final StudentRepository studentRepository;

    private final EmailService emailService;

    @Autowired
    public UniversityService(UniversityRepository universityRepository,
                             StudentRepository studentRepository,
                             EmailService emailService) {
        this.universityRepository = universityRepository;
        this.studentRepository = studentRepository;
        this.emailService = emailService;
    }

    @LogTime
    public List<University> getAll() {
        log.info("Find all universities");
        return universityRepository.findAll();
    }

    @LogTime
    public void delete(int id) {
        log.info("Delete user by id: " + id);
        Optional<University> optionalUniversity = universityRepository.findById(id);

        if (optionalUniversity.isEmpty()) {
            return;
        }

        studentRepository.deleteAllByUniversity(optionalUniversity.get());
        universityRepository.deleteById(id);
    }

    @LogTime
    public void save(University university) {
        log.info("Save user with ID: " + university.getId());
        String tmp = university.toString();
        emailService.sendInfoAboutSaveObject("Save: " + university.toString());
        universityRepository.save(university);
    }

}
