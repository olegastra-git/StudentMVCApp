package View;

import java.util.List;
import java.util.Scanner;

import Controller.iGetView;
import Model.Student;

public class ViewEng implements iGetView {
    // метод для вывода всех студентов
    public void printAllStudent(List<Student> students) {
        System.out.println("-----Displaying list of students-----");
        for (Student person : students) {
            System.out.println(person);
        }
        System.out.println("-----End of list-----");
    }

    // метод для получения текстового ввода от пользователя
    public String prompt(String message) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print(message);
            return in.nextLine();
        }
    }

    @Override
    // метод для получения числового ввода от пользователя (не реализован)
    public int promptInt(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'promptInt'");
    }

    @Override
    // метод для установки экземпляра класса в качестве ViewEng (не реализован)
    public void setViewEng(ViewEng viewEng) {
        throw new UnsupportedOperationException("Unimplemented method 'setViewEng'");
    }

}