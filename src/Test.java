import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) throws IOException {
        TreeMap<String, String> mapWord;
        Dictionary dict = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            menu();
            System.out.println("Nhập lựa chọn: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Nhập slang word: ");
                    String word = scanner.nextLine();
                    dict.findWord(word);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println("Nhập định nghĩa của word: ");
                    String define = scanner.nextLine();
                    dict.findDefine(define);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Show lịch sử: ");
                    dict.show();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Nhập từ cần thêm: ");
                    String newWord = scanner.nextLine();
                    dict.add(newWord);
                    break;
                case 5:
                    scanner.nextLine();
                    System.out.println("Edit slang word: ");
                    String editWord = scanner.nextLine();
                    dict.edit(editWord);
                    break;
                case 6:
                    scanner.nextLine();
                    System.out.println("Nhập từ cần xoá: ");
                    String delWord = scanner.nextLine();
                    dict.delete(delWord);
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.println("Reset danh sách: ");
                    dict.reset();
                    break;
                case 8:
                    scanner.nextLine();
                    System.out.println("Random danh sách: ");
                    mapWord = dict.randomWord(4, true);
                    for (String key : mapWord.keySet()){
                        System.out.println(key + " : " + mapWord.get(key));
                    }
                    break;
                case 9:
                    String a = "Câu hỏi là: ";
                    dict.randomQuiz(a, true);
                    break;
                case 10:
                    String b = "Câu hỏi là: ";
                    dict.randomQuiz(b, false);
                    break;

                case 11:
                    System.out.println("Thoát ");
                    break;
                default :
                    break;

            }
        }while ( option != 11 );
        dict.save();

    }

    public static void menu(){
        System.out.println("---------------Menu---------------");
        System.out.println("1.Tìm kiếm theo slang word");
        System.out.println("2.Tìm kiếm theo definition");
        System.out.println("3.Hiển thị history");
        System.out.println("4.Thêm 1 slang words");
        System.out.println("5.Sửa 1 slang word");
        System.out.println("6.Xoá 1 slang word");
        System.out.println("7.reset danh sách slang words");
        System.out.println("8.random 1 slang word");
        System.out.println("9.Chức năng đố vui(Slang word)");
        System.out.println("10.Chức năng đố vui(definition)");
    }
}
