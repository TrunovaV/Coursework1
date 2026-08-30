import java.util.Objects;

public class Employee {
    private static int idCounter = 1;
    private final int id;
    private String fullName;
    private int department;
    private double salary;


    public Employee(String fullName, int department, double salary) {
        this.id = idCounter;
        idCounter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getDepartment() {
        return this.department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setDepartment (int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void printShortInfo() {
        System.out.println("Ф.И.О. сотрудника: " + this.fullName + ", зарплата: " + this.salary + " руб.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(fullName, employee.fullName) && department == employee.department &&
                salary == employee.salary;
    }


    public String toString() {
        return "ID сотрудника: " + idCounter + ", Ф.И.О. сотрудника:" + this.fullName + ", отдел: " + this.department
                + ", зарплата: " + this.salary + " руб.";
    }



}
