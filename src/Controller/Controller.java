package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.Model;
import View.View;
import View.ViewEng;

public class Controller {

    // список всех студентов
    private List<Student> students;
    private iGetView view;
    private iGetModel model;

    public Controller(iGetView view, iGetModel model) {
        this.view = view;
        this.model = model;
        this.students = new ArrayList<Student>();

        // инициализируем вид и модель
        this.view.setViewEng(new ViewEng());
        this.model.setModelE(new Model(students));
    }

    /**
     * Получить всех студентов из модели
     */
    public void getAllStudent() {
        students.addAll(model.getAllStudent());
    }

    /**
     * Проверить есть ли данные в списке студентов
     */
    public boolean testData() {
        return students != null && !students.isEmpty();
    }

    /**
     * Обновить представление (вывести в консоль всех студентов)
     */
    public void updateView() {
        getAllStudent();
        if (students != null) {
            view.printAllStudent(students);
        } else {
            System.out.println("Список студентов пуст!");
        }
    }

    /**
     * Запустить основной цикл программы
     */
    public void run() {
        Commands command = Commands.NONE; // текущая команда
        boolean getNewIteration = true; // флаг продолжения цикла
        while (getNewIteration) {
            String input = view.prompt("Введите команду:"); // получаем команду от пользователя
            command = Commands.valueOf(input.toUpperCase()); // приводим строку к значению enum Commands
            switch (command) {
                case EXIT: // завершение программы
                    getNewIteration = false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST: // вывод всех студентов
                    getAllStudent();
                    updateView();
                    break;
                case DELETE: // удаление студента
                    int deleteNumber = view.promptInt("Введите номер студента на удаление:");
                    boolean isDeleted = model.deleteStudent(deleteNumber - 1);
                    if (isDeleted) {
                        System.out.println("Студент успешно удален!");
                    } else {
                        System.out.println("Студента с таким номером не найдено!");
                    }
                    break;
            }
        }
    }
}