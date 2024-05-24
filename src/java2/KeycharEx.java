package java2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeycharEx extends JFrame{
    private JLabel la = new JLabel("<Enter>키로 배경색이 바뀝니다");
    public KeycharEx(){
        super("KeyListener의 문자 키 입력 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane(); //컨텐트팬 알아내기
        c.setLayout(new FlowLayout());
        c.add(la);
        c.addKeyListener(new MyKeyListener()); // 키 리스너 달기
        setSize(250,150);
        setVisible(true);

        c.setFocusable(true); // 켄텐트팬이 포커스를 받을 수 있도록 설정
        c.requestFocus(); // 컨텐트팬에 포커스 설정. 키 입력 가능해짐
    }
    class MyKeyListener extends KeyAdapter{ // 키 리스너
        public void keyPressed(KeyEvent e){
            // 임의의 색을 만들기 위해 랜덤하게 r, g, b 성분 생성
            int r = (int) (Math.random()*256);
            int g = (int) (Math.random()*256);
            int b = (int) (Math.random()*256);
            switch (e.getKeyChar()) {
                case '\n': // <enter> 키 입력
                    la.setText("r=" +r+ ", g="+ g + ", b="+b);
                    getContentPane().setBackground(new Color(r, g, b));
                    break;
                    case 'q' : System.exit(0); 
            }
        }
    }
    public static void main(String[] args) {
        new KeyCharEx();
    }
    
}
