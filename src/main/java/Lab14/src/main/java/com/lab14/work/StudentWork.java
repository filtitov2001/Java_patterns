package com.lab14.work;


import com.lab14.data.Student;
import com.lab14.data.University;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentWork {
    private static int ID = 0;
    private final Map<University, List<Student>> universities = new HashMap<>();

    public void save(University university, Student student) {
        Optional<University> universityOptional = universities.keySet()
                .stream().filter(key -> key.getName().equals(university.getName())).findFirst();
        student.setId(ID++);
        if (universityOptional.isPresent()) {
            universities.get(universityOptional.get()).add(student);
        } else {
            List<Student> students = new ArrayList<>() {{
                add(student);
            }};
            universities.put(university, students);
        }
    }

    public void remove(int id) {
        universities.values().forEach(el -> el.removeIf(st -> st.getId() == id));
        universities.entrySet().removeIf(elem -> elem.getValue().size() == 0);
        ID--;
    }

    public Map<University, List<Student>> getAll() {
        return universities;
    }
}
