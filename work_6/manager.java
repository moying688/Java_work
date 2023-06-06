package work_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class manager implements Serializable {
    private ArrayList<Employee> employees;

    public manager() {
        employees = new ArrayList<Employee>();
        ReadFile();
    }

    public void ReadFile() {

        File file = new File("File.txt");
        if (!file.exists()) {
            System.out.println("未找到文件！！");
            try{
                file.createNewFile();
                System.out.println("已经新建一个文件(File.txt)");
            }catch (FileNotFoundException e){
                System.out.println(e);
            }catch (IOException e){
                System.out.println(e);
            }
            return;
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            employees = (ArrayList<Employee>) ois.readObject();
            System.out.println("读取文件成员信息成功");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("读取文件失败");
        }

    }

    public void WriteFile() {
        try {
            FileOutputStream fos = new FileOutputStream("File.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            System.out.println("保存文件成功!!");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("保存文件失败~~~~");
        }
    }

    public void Add(Scanner sc) {
        System.out.println();
        System.out.println("----当前为添加功能------");
        System.out.println("请输入雇员号: ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("请输入姓名: ");
        String name = sc.nextLine();
        System.out.println("请输入地址： ");
        String address = sc.nextLine();
        System.out.println("请输入工资： ");
        double salary = sc.nextDouble();
        Employee employee = new Employee(ID, name, address, salary);
        employees.add(employee);
        System.out.println("添加用户信息成功！！");
    }

    public void Delete(Scanner sc) {
        System.out.println();
        System.out.println("请输入要删除的员工工号：");
        int ID = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == ID) {
                employees.remove(i);
                System.out.println("删除成功~~~~");
                return;
            }
        }
        System.out.println("无指定员工或已经被删除!!!");
    }

    public void Seek(Scanner sc) {
        System.out.println();
        System.out.println("请输入要查询的员工工号： ");
        int ID = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == ID) {
                System.out.println(employees.get(i).toString());
                return;
            }
        }
        System.out.println("未找到指定员工!!!");
    }

    public void Modify(Scanner scanner) {
        System.out.println();
        System.out.println("请输入要修改的员工工号：");
        int ID = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == ID) {
                System.out.println("修改前员工信息如下:");
                System.out.println(employees.get(i).toString());

                System.out.println("输入修改后员工的工号: ");
                int ModifyID = scanner.nextInt();
                scanner.nextLine();
                System.out.println("输入修改后员工的名字: ");
                String ModifyName = scanner.nextLine();
                System.out.println("输入修改后员工的地址: ");
                String ModifyAddress = scanner.nextLine();
                System.out.println("输入修改后员工的工资: ");
                double ModifySalary = scanner.nextDouble();
                Employee employee = new Employee(ModifyID, ModifyName, ModifyAddress, ModifySalary);
                employees.add(employee);
                System.out.println("修改员工信息成功: ");
                System.out.println("修改后信息如下: ");
                System.out.println(employees.get(i).toString());
                return;
            }
        }
        System.out.println("未找到指定员工~~~~~");
    }

    public void PrintAll(Scanner sc) {
        System.out.println();
        System.out.println("所有员工如下: ");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }
}
