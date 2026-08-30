import java.util.Objects;

public class EmployeeBook {
    private static final Employee[] employees = new Employee[10];


    public boolean addEmployeeToBook(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public void printListOfEmployees() {
        System.out.println("--- Список всех сотрудников ---");
        for (Employee element : employees) {
            if (element != null) {
                System.out.println(element.toString());
            }
        }
    }

    public double calculateAverageSalary() {
        double totalSalary = 0;
        int employeeCount = 0;

        for (Employee element : employees) {
            if (element == null) break;

            totalSalary += element.getSalary();
            employeeCount++;
        }

        if (employeeCount == 0) {
            return 0; // Защита от деления на 0, если массив пуст
        }
        return totalSalary / employeeCount;
    }

    public void calculateTaxes(String taxType) {
        System.out.println("Расчет налогов " + taxType.toUpperCase());
        for (Employee element : employees) {
            if (element == null) continue;

            double tax = 0;
            double salary = element.getSalary();

            switch (taxType.toUpperCase()) {
                case "PROPORTIONAL":
                    tax = salary * 0.13;

                case "PROGRESSIVE":
                    if (salary <= 150) {
                        tax = salary * 0.13;
                    } else if (salary <= 350) {
                        tax = salary * 0.17;
                    } else {
                        tax = salary * 0.21;
                    }
                    break;
                default:
                    System.out.println("Неизвестный тип налога: " + taxType);
                    return;
            }
            System.out.println(element.getFullName() + " (Зарплата: " + element.getSalary() + ") -> Налог: " + tax);
        }
    }
    public void indexSalaryByDepartment(int targetDepartment, double percent) {
        if (targetDepartment < 1 || targetDepartment > 5) {
            throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");
        }
        for (Employee element : employees) {
            if (element == null) {
            continue;
            }
            if (element.getDepartment() != targetDepartment || percent == 0) {
            continue;
            }
            double newSalary = element.getSalary() * (1 + percent / 100.0);
            element.setSalary((int) newSalary);
        }
    }

    public void printFirstHigherSalary(int targetDepartment, int minSalary) {
        for (int i = 0; i < employees.length; i++) {
            Employee element = employees[i];
            if (element == null) {
                continue;
            }
            if (element.getDepartment() == targetDepartment && element.getSalary() > minSalary) {
                int employeeNumber = i + 1;
                System.out.println("Порядковый номер: " + employeeNumber);
                element.printShortInfo();
                break;
            }
        }
    }

    public static void printEmployeesWithSalaryLessThan(double wage, int employeeNumber) {
        int i = 0;
        int count = 0;

        while (i < employees.length) {
            Employee emp = employees[i];
            if (emp != null && emp.getSalary() < wage) {
                emp.printShortInfo();
                count++;
                if (count == employeeNumber) {
                    break;
                }
            }
            i++;
        }
    }

    public boolean containsEmployeeBySalary(Employee targetElement) {
        if (targetElement == null || this.employees == null) {
            return false;
        }
        for (Employee element : employees) {
            if (element == null) {
                continue;
            }

            if (element.equals(targetElement)) {
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee element : employees) {
            if (element != null && element.getId() == id) {
                return element;
            }
        }
        return null; // Если сотрудник с таким id не найден
    }
}