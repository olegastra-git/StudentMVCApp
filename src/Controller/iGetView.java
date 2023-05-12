package Controller;

import java.util.List;
import Model.Student;
import View.ViewEng;

public interface iGetView {
    void printAllStudent(List<Student> students);

    String prompt(String message);

    int promptInt(String string);

    void setViewEng(ViewEng viewEng);
}
