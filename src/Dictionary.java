import java.io.*;
import java.util.*;

public class Dictionary {
    Scanner scanner = new Scanner(System.in);
    public static String nameFile = "/Users/thanhnhi/IdeaProjects/slangword1/src/slang.txt";
    public static String fileName = "/Users/thanhnhi/IdeaProjects/slangword1/src/his.txt";
    public static LinkedList<String> his;
    public static TreeMap<String, String> map;

    // tham khảo https://stackoverflow.com/questions/29061782/java-read-txt-file-to-hashmap-split-by
    public Dictionary() throws IOException {
        map = ManageDict.readFile(nameFile);
        his = ManageDict.readHis(fileName);
    }
    //1
    public void findWord(String word) {
        if (map.containsKey(word)) {
            System.out.println(word + ":" + map.get(word));
        } else {
            System.out.println("không tìm thấy");
        }
        his.add(word);
    }

    //2
    public void findDefine(String define) {
        LinkedList<String> list = new LinkedList<String>();
        for(String key : map.keySet()) {
                if (map.get(key).contains(define)) {
                    list.add(key);
            }
        }
        for(String key : list) {
                System.out.println(key + ":" + map.get(key));
         }
        his.add(define);
    }
    //3
    public void show() {
        for(String key : his) {
            System.out.println(key);
        }
    }
    public void save() throws IOException {
        //ManageDict.writeMap(nameFile,map);
        ManageDict.saveHis(fileName,his);
    }
    //4
    public void add(String word) {
        String k;
        int n;
        if (map.containsKey(word)){
            System.out.println("Đã tồn tại, bạn có muốn viết đè lên đó, nếu muốn nhấn 1, không nhấn 0");
            n = scanner.nextInt();
            if(n == 1){
                System.out.println("Nhập định nghĩa: ");
                k = scanner.nextLine();
                map.put(word,k);
           }
//            if(n == 0){
//                System.out.println("không thêm");
//                k = scanner.nextLine();
//                String tr[] = {k};
//                map.put(word,tr);
//            }
        }
        else{
            System.out.println("Nhập định nghĩa: ");
            k = scanner.nextLine();
            map.put(word,k);
        }

    }

    public void edit(String word) {
        String defin;
        if (map.get(word) != null){
            System.out.print("Thay đổi định nghĩa : ");
            defin = scanner.nextLine();
            map.put(word, defin);
            System.out.println("Thay đổi thành công"+word +":"+ map.get(word));
        } else {
            System.out.println("Không có từ cần thay đổi");
        }

    }

    public void delete(String word) {
        String defin;
        if (map.get(word) != null){
            System.out.print("Bạn có muốn xoá từ "+word+"(1:xoá,0:không xoá): ");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.println("Xoá thành công");
                map.remove(word);
            } else
                System.out.println("Xoá thất bại");
        } else
            System.out.println("Không có từ để xoá");
    }
    public void reset() {
        map.clear();
        System.out.println("Trả về danh sách gốc");
    }


    //https://stackoverflow.com/questions/4951997/generating-random-words-in-java
    //https://stackoverflow.com/questions/32915711/what-can-an-object-array-hold
        public TreeMap<String, String> randomWord(int numberWord, boolean flag) throws IOException {

        TreeMap<String, String> treeMap = new TreeMap<String,String>();
        Random random = new Random();

        Object[] value = map.keySet().toArray();

        for(int i = 0; i < numberWord ; i++)
        {
            String word = (String)value[random.nextInt((int)(Math.random() * 7664))];
            if (flag == true)
                treeMap.put(word, map.get(word));
            else
                treeMap.put(map.get(word), word);

        }
        return treeMap;
    }
    public void randomQuiz(String ques, boolean flag) throws IOException {
        int count = 1, correct = 0;

        TreeMap<String, String> quizTreeMap = randomWord(4,flag);

        Random random = new Random();
        Object[] value = quizTreeMap.keySet().toArray();

        String question = (String) value[random.nextInt(value.length)];
        String answer = quizTreeMap.get(question);

        System.out.print(ques + question + "\n");

        for (String key : quizTreeMap.keySet()){
            System.out.println(count + ") " + quizTreeMap.get(key));
            if (quizTreeMap.get(key) == answer)
                correct = count;
            count += 1;
        }

        System.out.print("Chọn đáp án(1-4): ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        if (choose == correct)
            System.out.println("Đáp án đúng ");
        else {
            System.out.println("Đáp án sai ");
            if (flag == true)
                System.out.println("Đáp án đúng của : " + question + " là " + answer);
            else
                System.out.println("Đáp án đúng của : " + answer + " là " + question);
        }
    }

}


