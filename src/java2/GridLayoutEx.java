package java2;
import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame{
    public GridLayoutEx() {
        setTitle(("GridLayoutExt 예제"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane(); // 컨텐트팬 알아내기

        contentPane.setLayout(new GridLayout(4, 3)); //1x10 GridLayout 배치 관리자

        for(int i=8; i>0; i--){ // 8부터 내림차순으로 왼쪽으로 정렬
            String text = Integer.toString(i); // 정수 i를 문자열로 변환
            JButton button = new JButton(text); // 버튼 컴포넌트 생성
            contentPane.add(button); // 컨텐트팬에 버튼 부착

        }

        contentPane.add(new JButton("*"));
        contentPane.add(new JButton("0"));
        contentPane.add(new JButton("#"));
        setSize(500,200);
        setVisible(true);

    
}

public static void main(String[] args) {
    new GridLayoutEx();
}
}

