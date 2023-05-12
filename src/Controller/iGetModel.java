package Controller;

import java.util.List;

import Model.Model;
import Model.Student;

public interface iGetModel {
    public List<Student> getAllStudent();

    public boolean deleteStudent(int deleteNumber);

    public void setModelE(Model model);
}
