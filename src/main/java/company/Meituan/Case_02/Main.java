package company.Meituan.Case_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String str = scanner.next();
            Map<Integer,Integer> map = new HashMap<>();
            map.put(1,map.getOrDefault(1,0));
            String[] arr = str.split(",");
            int temp = Integer.parseInt(arr[0]);
            System.out.println(temp);
        }
    }
}
