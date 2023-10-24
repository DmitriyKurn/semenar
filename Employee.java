package com.company;

public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private double salary;
    private String department;

    public Employee(String name, int age, double salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public int compareTo(Employee employee) {

        return Integer.compare(this.age,employee.age);
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Иван", 30, 50000, "Продажи"));
        employees.add(new Employee("Мария", 25, 60000, "Маркетинг"));
        employees.add(new Employee("Сергей", 30, 55000, "Продажи"));
        employees.add(new Employee("Елена", 25, 60000, "Маркетинг"));
        employees.add(new Employee("Александр", 28, 52000, "Финансы"));
        employees.add(new Employee("Анна", 32, 58000, "Финансы"));
        employees.add(new Employee("Алексей", 27, 53000, "Инжиниринг"));
        employees.add(new Employee("Ольга", 29, 57000, "Инжиниринг"));
        employees.add(new Employee("Дмитрий", 31, 59000, "Кадры"));
        employees.add(new Employee("Татьяна", 26, 54000, "Кадры"));
        employees.add(new Employee("Павел", 33, 61000, "Продажи"));
        employees.add(new Employee("Екатерина", 24, 48000, "Маркетинг"));
        employees.add(new Employee("Артем", 29, 56000, "Финансы"));
        employees.add(new Employee("Анастасия", 27, 52000, "Инжиниринг"));
        employees.add(new Employee("Андрей", 31, 59000, "Маркетинг"));
        employees.add(new Employee("София", 26, 55000, "Продажи"));
        employees.add(new Employee("Максим", 28, 58000, "Маркетинг"));
        employees.add(new Employee("Виктория", 30, 57000, "Финансы"));
        employees.add(new Employee("Илья", 25, 54000, "Инжиниринг"));
        employees.add(new Employee("Алиса", 32, 60000, "Кадры"));

        Collections.sort(employees, new EmployeeComparator());
        print(employees);
    }

    private static void print(List<Employee> employees) {
        for (Employee employee :
                employees) {
            System.out.println("Имя: " + employee.getName() + ", Возраст: " + employee.getAge() +
                    ", Зарплата: " + employee.getSalary() + ", Отдел: " + employee.getDepartment());
        }
    }

    static class EmployeeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            int result = o1.compareTo(o2);
            if (result == 0)
                if (o1.getSalary() != o2.getSalary()) {
                    return Double.compare(o2.getSalary(), o1.getSalary());
                } else {
                    return o1.getDepartment().compareTo(o2.getDepartment());
                }
            return result;
        }
    }
}

