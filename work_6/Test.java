package work_6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        manager m = new manager();

        while(true){
            System.out.println("------杭电工资支付系统-----");
            System.out.println("0.打印所有员工信息");
            System.out.println("1.添加员工信息");
            System.out.println("2.删除员工信息");
            System.out.println("3.修改员工信息");
            System.out.println("4.查询员工信息");
            System.out.println("5.退出并保存文件");
            System.out.println("请选择相应操作:");
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
                    System.out.println("该操作不存在，请重新输入~~~~");
            }
        }

    }
}

