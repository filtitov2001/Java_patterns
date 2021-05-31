package com.application.services;

import com.application.models.Student;
import com.application.models.University;
import com.application.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Service
public class SchedulerService {
    @Autowired
    StudentService studentService;
    @Autowired
    UniversityService universityService;

    @Scheduled(cron = "* */30 * * * *")
    public void toFile() throws IOException{
        System.out.println("Oket~");
        for(File myFile : new File("/Users/felikstitov/IdeaProjects/Lab17/Data").listFiles())
            if (myFile.isFile())
                myFile.delete();


        File file = new File("/Users/felikstitov/IdeaProjects/Lab17/Data/student.txt");
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(file);

        String text = "id   -   First Name  -   Last Name    -   Middle Name     -   University\n";

        List<Student> studentList = studentService.getAll();
        for(Student s: studentList){
            text += s.getId() + "   -   " + s.getFirstName() + "   -   "
                    + s.getLastName() + "   -   " + s.getMiddleName() + "    -   ";
            if(s.getUniversity()!=null) {
                text += s.getUniversity().getName() + "\n";
            }else{
                text += "Doesn't exist\n";
            }
        }

        fileWriter.write(text);
        fileWriter.close();

        file = new File("/Users/felikstitov/IdeaProjects/Lab17/Data/university.txt");
        file.createNewFile();
        fileWriter = new FileWriter(file);

        text+= "id  -   Name    -   Creation Date\n";

        List<University> universityList = universityService.getAll();
        for(University u: universityList)
            text += u.getId() + "   -   " + u.getName() + "     -    " + u.getCreationDate() + "\n";

        fileWriter.write(text);
        fileWriter.close();
    }

}
