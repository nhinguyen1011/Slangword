import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.*;
public class Dictionary {
    public static LinkedList<String> his;
    public static TreeMap<String, String> map;

    // tham khảo https://stackoverflow.com/questions/29061782/java-read-txt-file-to-hashmap-split-by


    public Dictionary() throws IOException {
        map = ManageDict.readFile();
        his = ManageDict.readHis();
    }

    public void findWord(String word) {
        if (map.containsKey(word)) {
            System.out.println(word + ":" + map.get(word));
        } else {
            System.out.println("không tìm thấy");
        }
        his.add(word);
    }
    public void findDefine(String define) {
        LinkedList<String> list = new LinkedList<String>();
        if (map.containsValue(define)) {
            System.out.println( map.get(define));
        } else {
            System.out.println("không tìm thấy");
        }

        his.add(define);
    }
}


