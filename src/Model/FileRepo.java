package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Controller.iGetModel;

public class FileRepo implements iGetModel {

    private String fileName;
    private List<Student> students;

    public FileRepo(String fileName) {
        this.fileName = fileName;
        this.students = new ArrayList<>();
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void readAllStudentsFromFile() {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] param = line.split(" ");
                Student student = new Student(param[0], param[1], Integer.parseInt(param[2]), Long.parseLong(param[3]));
                students.add(student);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveAllStudentToFile() {
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Student student : students) {
                fw.write(student.getFirstName() + " " + student.getSecondName() + " " + student.getAge() + " "
                        + student.getStudentID());
                fw.append('\n');
            }
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getAllStudent() {
        readAllStudentsFromFile();
        return students;
    }

    @Override
    public boolean deleteStudent(int deleteNumber) {
        for (Student student : students) {
            if (student.getStudentID() == deleteNumber) {
                students.remove(student);
                saveAllStudentToFile();
                return true;
            }
        }
        return false;
    }

    @Override
    public void setModelE(Model model) {
        throw new UnsupportedOperationException("Unimplemented method 'setModelE'");
    }
}