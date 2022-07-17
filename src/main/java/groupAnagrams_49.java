import java.util.*;


public class groupAnagrams_49 {
/*
类似于恰好一次的，则使用hash 进行处理：
1、将 string 数据进行排序，字母异构的字母异位词 排序后相同，作为key
2、根据key 取value值 list<string>,并将str装进list中，然后更新value
 */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for( String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String keys = new String(ch);

            List<String> list = res.getOrDefault(keys, new ArrayList<String>());

            list.add(str);

            res.put(keys, list);
        }
        return new ArrayList<List<String>>(res.values());
    }

}
