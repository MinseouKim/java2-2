import javax.swing.*;
import java.awt.*;


public class BorderLayoutEx extends JFrame {
    public BorderLayoutEx() {
        setTitle(("BorderLayout 예제"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane(); // 컨텐트팬 알아내기

    
    // 컨텐트팬에 BorderLayout 배치관리자 설정
    contentPane.setLayout(new BorderLayout(30,20));

    contentPane.add(new JButton("add"));
        contentPane.add(new JButton("sub"));
        contentPane.add(new JButton("mul"));
        contentPane.add(new JButton("div"));
        contentPane.add(new JButton("Calculate"));

        setSize(300,200); //프레임 크기 300x200 설정
        setVisible(true); //화면에 프레임 출력



    }
    public static void main(String[] args) {
        new BorderLayoutEx();
}
}
