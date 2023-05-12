package Model;

public class Student extends User implements Comparable<Student> {
    private long studentID; // поле, хранящее идентификатор студента

    // Конструктор
    public Student(String firstName, String secondName, int age, long studentID) {
        super(firstName, secondName, age); // вызываем конструктор базового класса User
        this.studentID = studentID;
    }

    // Геттер идентификатора студента
    public long getStudentID() {
        return studentID;
    }

    // Сеттер идентификатора студента
    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    // Переопределенный метод toString для удобного вывода информации о студенте
    @Override
    public String toString() {
        return "Student{"
                + "firstName=" + super.getFirstName()
                + ", secondName=" + super.getSecondName()
                + ", age=" + super.getAge() +
                ", studentID=" + studentID +
                '}';
    }

    // Реализация интерфейса Comparable для сортировки студентов в списке
    @Override
    public int compareTo(Student o) {
        if (super.getAge() == o.getAge()) // Сначала сравниваем возраст
        {
            if (this.studentID == o.studentID) // Если возрасты равны, сравниваем идентификаторы студентов
            {
                return 0; // Элементы равны
            }
            if (this.studentID < o.studentID) {
                return -1; // Элемент меньше
            }
            return 1; // Элемент больше
        }
        if (super.getAge() < o.getAge()) // Если возраст текущего студента меньше, чем возраст сравниваемого студента
        {
            return -1; // Элемент меньше
        }
        return 1; // Элемент больше
    }
}