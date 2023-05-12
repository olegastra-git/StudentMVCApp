package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Controller.iGetModel;

// Описание класса Model, который реализует интерфейс iGetModel
public class Model implements iGetModel {

    // Объявление HashMap для хранения объектов класса Student
    private HashMap<Long, Student> students;

    // Конструктор класса Model
    public Model(List<Student> studentsList) {
        this.students = new HashMap<>();
        // Добавление всех объектов класса Student из переданного списка в HashMap
        for (Student student : studentsList) {
            this.students.put(student.getStudentID(), student);
        }
    }

    // Метод для получения всех объектов класса Student из HashMap
    public List<Student> getAllStudents() {
        List<Student> allStudents = new ArrayList<>();
        // Добавление всех объектов класса Student из HashMap в список allStudents
        for (Student student : students.values()) {
            allStudents.add(student);
        }
        return allStudents;
    }

    // Реализация метода deleteStudent из интерфейса iGetModel
    @Override
    public boolean deleteNumber(long studentID) {
        // Проверка наличия объекта класса Student с указанным ID в HashMap
        if (students.containsKey(studentID)) {
            students.remove(studentID); // Удаление объекта из HashMap
            return true;
        } else {
            return false; // Объект не найден, возвращается false
        }
    }

    @Override
    public void setModelE(Model model) {
        // Метод не реализован, выбрасывается исключение
        throw new UnsupportedOperationException("Unimplemented method 'setModelE'");
    }

    @Override
    public List<Student> getAllStudent() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllStudent'");
    }

    @Override
    public boolean deleteStudent(int deleteNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }
}