package work_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        manager m = new manager();

        while(true){
            System.out.println("------���繤��֧��ϵͳ-----");
            System.out.println("0.��ӡ����Ա����Ϣ");
            System.out.println("1.���Ա����Ϣ");
            System.out.println("2.ɾ��Ա����Ϣ");
            System.out.println("3.�޸�Ա����Ϣ");
            System.out.println("4.��ѯԱ����Ϣ");
            System.out.println("5.�˳��������ļ�");
            System.out.println("��ѡ����Ӧ����:");
            int choice=scanner.nextInt();
            switch(choice){
                case 0:
                    m.PrintAll(scanner);
                    break;
                case 1:
                    m.Add(scanner);
                    break;
                case 2 :
                    m.Delete(scanner);
                    break;
                case 3:
                    m.Modify(scanner);
                    break;
                case 4:
                    m.Seek(scanner);
                    break;
                case 5:
                    m.WriteFile();
                    System.exit(1);
                default:
                    System.out.println("�ò��������ڣ�����������~~~~");
            }
        }

    }
}

