import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.*;
public class Dictionary {
    private LinkedList<String> his;
    public static TreeMap<String, String> map;

    public static TreeMap<String, String> readFile() throws IOException {
        String line = null;
        BufferedReader reader = new BufferedReader(new FileReader("/Users/thanhnhi/IdeaProjects/Slangword/src/slang.txt"));
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("`", 2);
            if (parts.length >= 2) {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                map.put(parts[0], " ");
            }

        }
        reader.close();
        return map;
    }
    // tham khảo https://stackoverflow.com/questions/29061782/java-read-txt-file-to-hashmap-split-by
     public static void display() throws IOException {
        Map<String, String> mapFromFile  = readFile();

         for (String key : map.keySet())
         {
             if (map.size() >= 2){
                 System.out.println(key + ":" + map.get(key));
             }

         }
    }

    public Dictionary() {


    }

    public static void main(String[] args) throws IOException {
        Dictionary dic = new Dictionary();
        dic.display();
    }
}



