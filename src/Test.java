import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        Dictionary dict = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            menu();
            System.out.println("Nhap lua chon: ");
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
            }
        }while ( option < 0 ||  option > 11 );
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
        System.out.println("9.Chức năng đố vui(Slang word");
        System.out.println("10.Chức năng đố vui(definition)");
    }
}
