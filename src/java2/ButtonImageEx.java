package java2;

import javax.swing.*;
import java.awt.*;
    public class ButtonImageEx extends JFrame {
        public ButtonImageEx() {
            setTitle("이미지 버튼 예제");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container c = getContentPane();
            c.setLayout(new FlowLayout());
            ImageIcon normalIcon = new ImageIcon("images/img2.jpg");
            ImageIcon rolloverIcon = new ImageIcon("images/img2.jpg");
            ImageIcon pressedIcon = new ImageIcon("images/img2.jpg");
            JButton btn = new JButton("call~~", normalIcon);
            btn.setPressedIcon(pressedIcon); // pressedIcon용 이미지 등록
            btn.setRolloverIcon(rolloverIcon); // rolloverIcon용 이미지 등록
            c.add(btn);
            setSize(250,150);
            setVisible(true);
        }
        public static void main(String [] args) {
        new ButtonImageEx();
        }
}