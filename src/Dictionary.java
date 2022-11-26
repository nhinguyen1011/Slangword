import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.*;
public class Dictionary {
    private LinkedList<String> his;
    public static TreeMap<String, String> map;

    // tham khảo https://stackoverflow.com/questions/29061782/java-read-txt-file-to-hashmap-split-by


    public Dictionary() throws IOException {
        map = ManageDict.readFile();


    }

    public static void main(String[] args) throws IOException {
        Dictionary dic = new Dictionary();
        //dic.display();
    }
}



