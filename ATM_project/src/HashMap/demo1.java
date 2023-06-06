package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class demo1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String[]list=str.split(" ");
        System.out.println(Arrays.toString(list));

        //键     值对，，，，，键是唯一的
        //单词作为键，出现次数作为值
        HashMap<String,Integer>map=new HashMap<>();
//        map.put(key,value);
        for (int i = 0; i <list.length ; i++) {
            if(!map.containsKey(list[i])){
                map.put(list[i],1);
            }
            else map.put(list[i],map.get(list[i])+1);
        }
        System.out.println("============");
        Set<String> s= map.keySet();
        for(String x:s){
            System.out.println(x+" "+map.get(x));
        }
    }

}
