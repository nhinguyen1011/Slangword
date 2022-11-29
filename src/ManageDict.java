import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class ManageDict {


        public static TreeMap<String, String> readFile(String nameFile) throws IOException {
            TreeMap<String, String> map1 = new TreeMap<String, String>();
            String line = null;
            BufferedReader reader = new BufferedReader(new FileReader(nameFile));
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("`", 2);
                if (parts.length >= 2) {
                    String key = parts[0];
                    String value = parts[1];

                    map1.put(key, value);
                } else {
                    map1.put(parts[0],line);
                }
            }
            reader.close();
            return map1;
        }

        public static void writeMap(String  nameFile,TreeMap<String, String> keys) throws IOException {
            String line;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(nameFile));) {
                for (String key : keys.keySet()) {
                    bw.write(key);
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public static LinkedList<String> readHis(String fileName) throws IOException {
            LinkedList his = new LinkedList<>();
            String line ;
            try ( BufferedReader bw = new BufferedReader(new FileReader(fileName));){
                while ((line = bw.readLine()) != null) {
                    his.add(line);
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            return his;
        }
        public static void saveHis(String fileName,LinkedList<String> keys) throws IOException {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));) {

                for (String word : keys){
                    bw.write(word + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }




