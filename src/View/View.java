package View;

import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Student;

public class View implements iGetView {
    public void printAllStudent(List<Student> students) {
        System.out.println("-----Вывод списка студентов-----");
        for (Student person : students) {
            System.out.println(person);
        }
        System.out.println("-----Конец списка-----");
    }

    public String prompt(String message) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print(message);
            return in.nextLine();
        }
    }

    @Override
    public int promptInt(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'promptInt'");
    }

    @Override
    public void setViewEng(ViewEng viewEng) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setViewEng'");
    }

}
