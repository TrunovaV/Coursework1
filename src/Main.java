//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EmployeeBook book = new EmployeeBook();

        System.out.println("1. Проверка добавления сотрудников (11 вызовов для массива из 10 мест)");
        Employee[] testData = {
                new Employee("Котлов Иван Викторович", 1, 150),
                new Employee("Петров Семён Иванович", 1, 250),
                new Employee("Любимов Николай Петрович", 2, 130),
                new Employee("Смирнова Анна Сергеевна", 2, 360),
                new Employee("Кузнецова Светлана Петровна", 3, 140),
                new Employee("Попов Олег Васильевич", 3, 280),
                new Employee("Ванина Тамара Федоровна", 4, 160),
                new Employee("Трусов Михаил Юрьевич", 4, 400),
                new Employee("Иванова Елена Михайловна", 5, 220),
                new Employee("Новикова Елена Васильевна", 5, 450),
                new Employee("Семёнов Пётр Иванович", 1, 150),
        };


        for (int i = 0; i < testData.length; i++) {
            boolean added = book.addEmployeeToBook(testData[i]);
            System.out.println("Добавление сотрудника №" + (i + 1) + ": " + added);
        }

        System.out.println("\n=== 2. Вывод всех сотрудников ===");
        book.printListOfEmployees();

        System.out.println("\n=== 3. Подсчет средней зарплаты до первого null ===");
        System.out.println("Средняя зарплата: " + book.calculateAverageSalary());

        System.out.println("\n=== 4. Расчет налогов ===");
        book.calculateTaxes("PROPORTIONAL");
        book.calculateTaxes("PROGRESSIVE");

        System.out.println("\n=== 5. Индексация зарплат отдела 1 на 10% ===");
        book.indexSalaryByDepartment(1, 10);
        book.printListOfEmployees();

        System.out.println("\n=== 6. Поиск первого сотрудника отдела 2 с зарплатой > 150 ===");
        book.printFirstHigherSalary(2, 150);

        System.out.println("\n=== 7. Поиск первых 3 сотрудников с зарплатой < 250 ===");
        book.printEmployeesWithSalaryLessThan(250, 3);

        System.out.println("\n=== 8. Проверка наличия сотрудника с точки зрения бухгалтерии (equals по зарплате) ===");

        Employee tempEmployee = new Employee("Фантом", 1, 400);
        System.out.println("Есть ли сотрудник с зарплатой 400.0? " + book.containsEmployeeBySalary(tempEmployee));

        Employee uniqueEmployee = new Employee("Уникальный", 1, 999);
        System.out.println("Есть ли сотрудник с зарплатой 999.0? " + book.containsEmployeeBySalary(uniqueEmployee));

        System.out.println("\n=== 9. Получение сотрудника по ID ===");
        Employee found = book.getEmployeeById(5);
        System.out.println("Сотрудник с ID=5: " + (found != null ? found.toString() : "Не найден"));
    }
}