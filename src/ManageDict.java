import java.io.*;
import java.util.*;


public class ManageDict {
//    public static Map<String, String> TreeMapFromTextFile() {
//
//
//        //File file  = new File("/Users/thanhnhi/IdeaProjects/Slangword/src/slang.txt");
//
////        BufferedReader br = new BufferedReader(new FileReader(file));
////        while (scanner.hasNext()) {
////            String word = scanner.next();
////            //Integer count = map.get(word);
////            map.put(word,word);
////        }
////        scanner.close();
////
////        List<String> keys = new ArrayList<String>(map.keySet());
////        Collections.sort( keys );
////
////        PrintWriter out = new PrintWriter(new FileWriter("/Users/thanhnhi/IdeaProjects/Slangword/src/his.txt"));
////        for (String key : keys)
////            out.println(key + " : " + map.get(key));
////        out.close();
//
//        try {
//
//            // create file object
//            File file = new File("/Users/thanhnhi/IdeaProjects/Slangword/src/slang.txt");
//
//            // create BufferedReader object from the File
//            br = new BufferedReader(new FileReader(file));
//
//            String line = null;
//
//            // read file line by line
//            while ((line = br.readLine()) != null) {
//
//                // split the line by :
//                String[] parts = line.split("`");
//
//                // first part is name, second is number
//                String name = parts[0].trim();
//                String number = parts[1].trim();
//
//                // put name, number in HashMap if they are
//                // not empty
//                if (!name.equals("") && !number.equals(""))
//                    map.put(name, number);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            // Always close the BufferedReader
//            if (br != null) {
//                try {
//                    br.close();
//                } catch (Exception e) {
//
//                }
//            }
//        }
//
//        return map;
//    }
//
//    public static void display(){
//        Map<String, String> mapFromFile
//                = TreeMapFromTextFile();
//
//        // iterate over HashMap entries
//        for (Map.Entry<String, String> entry :
//                mapFromFile.entrySet()) {
//            System.out.println(entry.getKey() + " : "
//                    + entry.getValue());
//        }
//    }

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/thanhnhi/IdeaProjects/Slangword/src/slang.txt";
        TreeMap<String, String> map = new TreeMap<String, String>();

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null)
        {
            String[] parts = line.split("`", 2);
            if (parts.length >= 2)
            {
                String key = parts[0];
                String value = parts[1];
                map.put(key, value);
            } else {
                map.put(parts[0], " ");
                //System.out.println("ignoring line: " + parts[0]);
            }
        }

        for (String key : map.keySet())
        {
            if (map.size() >= 2){
                System.out.println(key + ":" + map.get(key));
            }
           else{
                System.out.println(key + " " + map.get(key));
            }
        }
        reader.close();
    }
}



