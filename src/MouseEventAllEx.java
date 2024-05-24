import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEventAllEx {
    private JLabel la = new JLabel("    Move me"); // 마우스로 이동시킬 레이블 컴포넌트

    public MouseEventAllEx() {
        setTitle("MouseListener와 MouseMotionListener 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        
        MyMouseListener listener = new MyMouseListener();// 마우스 /모션 리스너 객체 생성
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);

        c.setLayout(null); // 배치 관리자를 삭제하여 레이블을 마음대로 움직일 수 있게 함
        la.setSize(80,20);
        la.setLocation(100, 80);
        c.add(la);

        setSize(320,200);
        setVisible(true);
    }
}
