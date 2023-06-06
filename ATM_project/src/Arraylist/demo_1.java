package Arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class demo_1 {
    public static void main(String[] args) {
        ArrayList<Object>list=new ArrayList<>();
        list.add("5555");
        list.add(2);
        list.add("java");
        list.add("hdu");
        stu s=new stu(93285);
        list.add(s.getNumber());
//        System.out.println(list);
//        list.remove(0);
//        System.out.println(list.indexOf(3));//seek from front
//        System.out.println(list.lastIndexOf(2));
//        System.out.println(list.indexOf(2));
        System.out.println("------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.add(list.indexOf("java")+1,"new");
        list.set(list.indexOf("hdu"),"杭电");

//        for (Object e:list) {
//            System.out.println(e);
//        }
        /*
        迭代器
         */
        Iterator<Object>it= list.iterator();
        //进行一个判断
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
class stu{
    public int number;
    public stu(int number){
        this.number=number;
    }
    public int getNumber(){
        return number;
    }
}
class Demo<T>{
    T x;
    public Demo(T x){
        this.x=x;
    }
}