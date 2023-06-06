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
            System.out.println("δ�ҵ��ļ�����");
            try{
                file.createNewFile();
                System.out.println("�Ѿ��½�һ���ļ�(File.txt)");
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
            System.out.println("��ȡ�ļ���Ա��Ϣ�ɹ�");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("��ȡ�ļ�ʧ��");
        }

    }

    public void WriteFile() {
        try {
            FileOutputStream fos = new FileOutputStream("File.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(employees);
            System.out.println("�����ļ��ɹ�!!");
        } catch (IOException e) {
            System.out.println(e);
            System.out.println("�����ļ�ʧ��~~~~");
        }
    }

    public void Add(Scanner sc) {
        System.out.println();
        System.out.println("----��ǰΪ��ӹ���------");
        System.out.println("�������Ա��: ");
        int ID = sc.nextInt();
        sc.nextLine();
        System.out.println("����������: ");
        String name = sc.nextLine();
        System.out.println("�������ַ�� ");
        String address = sc.nextLine();
        System.out.println("�����빤�ʣ� ");
        double salary = sc.nextDouble();
        Employee employee = new Employee(ID, name, address, salary);
        employees.add(employee);
        System.out.println("����û���Ϣ�ɹ�����");
    }

    public void Delete(Scanner sc) {
        System.out.println();
        System.out.println("������Ҫɾ����Ա�����ţ�");
        int ID = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == ID) {
                employees.remove(i);
                System.out.println("ɾ���ɹ�~~~~");
                return;
            }
        }
        System.out.println("��ָ��Ա�����Ѿ���ɾ��!!!");
    }

    public void Seek(Scanner sc) {
        System.out.println();
        System.out.println("������Ҫ��ѯ��Ա�����ţ� ");
        int ID = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == ID) {
                System.out.println(employees.get(i).toString());
                return;
            }
        }
        System.out.println("δ�ҵ�ָ��Ա��!!!");
    }

    public void Modify(Scanner scanner) {
        System.out.println();
        System.out.println("������Ҫ�޸ĵ�Ա�����ţ�");
        int ID = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == ID) {
                System.out.println("�޸�ǰԱ����Ϣ����:");
                System.out.println(employees.get(i).toString());

                System.out.println("�����޸ĺ�Ա���Ĺ���: ");
                int ModifyID = scanner.nextInt();
                scanner.nextLine();
                System.out.println("�����޸ĺ�Ա��������: ");
                String ModifyName = scanner.nextLine();
                System.out.println("�����޸ĺ�Ա���ĵ�ַ: ");
                String ModifyAddress = scanner.nextLine();
                System.out.println("�����޸ĺ�Ա���Ĺ���: ");
                double ModifySalary = scanner.nextDouble();
                Employee employee = new Employee(ModifyID, ModifyName, ModifyAddress, ModifySalary);
                employees.add(employee);
                System.out.println("�޸�Ա����Ϣ�ɹ�: ");
                System.out.println("�޸ĺ���Ϣ����: ");
                System.out.println(employees.get(i).toString());
                return;
            }
        }
        System.out.println("δ�ҵ�ָ��Ա��~~~~~");
    }

    public void PrintAll(Scanner sc) {
        System.out.println();
        System.out.println("����Ա������: ");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }
}
