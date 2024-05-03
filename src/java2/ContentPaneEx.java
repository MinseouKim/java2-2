package java2;

import javax.swing.*;
import java.awt.*;


public class ContentPaneEx extends JFrame{
    public ContentPaneEx(){
        setTitle("ContentPane과 JFrame 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setBackground(Color.GREEN);
        contentPane.setLayout(new FlowLayout());

        contentPane.add(new JButton("OK"));
        contentPane.add(new JButton("byebye"));
        contentPane.add(new JButton("Cancel"));
        
        setSize(300,150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ContentPaneEx();
    }

}