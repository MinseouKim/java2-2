package java2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseListenerEx extends JFrame{
    private JLabel la = new JLabel("Hello"); // "Hello" 문자열을 추가하기 위한 레이블

    public MouseListenerEx(){
        setTitle("Bouse 이벤트 예제");;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null); // 컨텐트팬의 배치관리자 삭제
        la.setSize(50,20); // 레이블의 크기 50x20 설정
        la.setLocation(30,30); // 레이블의 위치(30,30)으로 설정
        c.add(la); // 레이블 삽입

        setSize(200, 200);
        setVisible(true);
    }

    class MyMouseListener implements MouseListener{
        public void mousePressed(MouseEvent e){
            int x = e.getX(); // 마우스 클릭 좌표 x
            int y = e.getY(); // 마우스 클릭 좌표 Y
            la.setLocation(x,y); // 레이블의 위치를 (x,y)로 이동
        }
        public void mouseReleased(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
    }
    public static void main(String[] args) {
        new MouseListenerEx();
    }
}
