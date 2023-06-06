package SetDemo;
import java.util.*;
//无序性，不重复
public class Main {
    public static void main(String[] args) {
        String[]list=new String[]{"abc","de","abc","De","gong","De","gong"};
        HashSet<String> hs=new HashSet<>();
        for (String x:list) {
            hs.add(x);
        }
        for (String n:hs) {
            System.out.println(n);//打出来无序且不重复
        }
        System.out.println("--------------------");
        String str[]=new String[hs.size()];
        Arrays.sort(hs.toArray(str));///str会去接转化后的hs
        for (String l:str) {
            System.out.println(l);
        }
        System.out.println(Arrays.toString(str));
    }
}
