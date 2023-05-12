
// Импортируем необходимые классы из разных пакетов
import java.util.ArrayList;
import java.util.List;
import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.FileRepo;
import Model.Model;
import Model.Student;
import View.View;

public class App {
   public static void main(String[] args) throws Exception {
      // Создаем список студентов
      List<Student> students = new ArrayList<Student>();
      Student s1 = new Student("Sergey", "Ivanov", 21, (long) 101);
      Student s2 = new Student("Andr", "Sidor", 22, (long) 111);
      Student s3 = new Student("Ivan", "Petrov", 22, (long) 121);
      Student s4 = new Student("Igor", "Ivanov", 23, (long) 301);
      Student s5 = new Student("Dasha", "Cviticova", 25, (long) 171);
      Student s6 = new Student("Lena", "Ilina", 23, (long) 104);
      students.add(s1);
      students.add(s2);
      students.add(s3);
      students.add(s4);
      students.add(s5);
      students.add(s6);

      // Создаем экземпляр класса FileRepo, передаем ему имя файла и сохраняем в него
      // всех студентов из списка
      FileRepo fileRepo = new FileRepo("StudentDb.txt");
      for (Student pers : students) {
         fileRepo.addStudent(pers);
      }
      fileRepo.saveAllStudentToFile();

      // Создаем объекты двух моделей: Model и FileRepo
      iGetModel Model = new Model(students);
      iGetModel modelFileRepo = fileRepo;

      // Создаем объект класса View
      iGetView view = new View();
      // Создаем экземпляр класса Controller, передаем ему объекты View и
      // Model/FileRepo
      Controller control = new Controller(view, modelFileRepo);
      // Запускаем приложение, вызывая метод run()
      control.run();
      // Обновляем отображение, вызывая метод updateView()
      control.updateView();
   }
}