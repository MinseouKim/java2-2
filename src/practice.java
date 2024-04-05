import java.util.Scanner;
public class practice {
    public static void main(String[] args) {
    Scanner scanner = newScanner(System.in);
    System.out.print("월(1~12)을 입력하시오:");
    int month = scanner.nextInt();
    if      (2<month && month <6)
        System.out.println("봄 입니다.");
    else if (5< month && month <10)
         System.out.println("여름 입니다.");
    else if (8< month && month <12)
        System.out.println("가을 입니다.");
    else
        System.out.println("겨울 입니다.");
    }
}
