package work_6;

import java.io.Serializable;

public class Employee implements Serializable {
    private int Id;
    private String name;
    private String address;
    private double salary;

    public Employee() {

    }

    public Employee(int Id, String name, String address, double salary) {
        this.Id = Id;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "成员信息{" + "Id=" + Id + ", name='" + name + '\'' + ", address='" + address + '\'' + ", salary=" + salary + '}';
    }
}
