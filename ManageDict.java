import java.io.*;
import java.util.*;


public class ManageDict {
    public static TreeMap<String, String> map;
    public static LinkedList<String> his;
    public static String nameFile = "/Users/thanhnhi/IdeaProjects/Slangword/src/slang.txt";

    public static TreeMap<String, String> readFile() throws IOException {
        String line = null;
        BufferedReader reader = new BufferedReader(new FileReader(nameFile));
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

    public static void writeMap() throws IOException {
        File file = new File(nameFile);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, String> entry : map.entrySet()) {

                bw.write(entry.getKey() + ":" + entry.getValue());

                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void saveHis() throws IOException {
        File file = new File(nameFile);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, String> entry : map.entrySet()) {

                bw.write(entry.getKey() + ":" + entry.getValue());

                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


