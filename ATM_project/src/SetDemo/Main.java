package SetDemo;
import java.util.*;
//�����ԣ����ظ�
public class Main {
    public static void main(String[] args) {
        String[]list=new String[]{"abc","de","abc","De","gong","De","gong"};
        HashSet<String> hs=new HashSet<>();
        for (String x:list) {
            hs.add(x);
        }
        for (String n:hs) {
            System.out.println(n);//����������Ҳ��ظ�
        }
        System.out.println("--------------------");
        String str[]=new String[hs.size()];
        Arrays.sort(hs.toArray(str));///str��ȥ��ת�����hs
        for (String l:str) {
            System.out.println(l);
        }
        System.out.println(Arrays.toString(str));
    }
}
