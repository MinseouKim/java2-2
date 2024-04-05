import java.util.Scanner;

public class practice3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend;
        int divisor;

        System.out.print("제수를 입력하시오:");
        dividend =scanner.nextInt();
        System.out.print("피제수 입력하시오 :");
        try{
            System.out.println(dividend + "를"+ divisor + "로 나누면 몫은" + dividend/divisor + "입니다.");
        }
        catch(ArithmeticException e){ //ArithmeticException 예외 처리 코드
            System.out.println("a으로 나눌수 없습니다.");
        }
        finally{
            scanner.close();
        }
    }
}