import javax.swing.*;
import java.awt.*;
public class GraphicsDrawLineEx extends JFrame {
    public GraphicsDrawLineEx() {
    setTitle("drawLine 사용 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(new MyPanel());
    setSize(200, 150);
    setVisible(true);
    }
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED); // 빨간색을 선택한다.
            g.drawLine(20, 20, 100, 100);
            g.drawOval(20,20,100,200);
            g.drawRect(30,30,40,40);
    }
    }
    public static void main(String [] args) {
    new GraphicsDrawLineEx();
    }   
}