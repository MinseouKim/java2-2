# 202130103 김민서
## 2024-06-14 보강(종강)
## 13-1장 입출력 스트림과 파일 입출력
### 스트림의 연결
#### 여러개의 스트림을 연결하여 사용할 수 있음
- 예) 키보드에서 문자를 입력받기 위해 System.in과 InputStreamReader를 연결한 코드
#### 문자 스트림으로 텍스트 파일 읽기
- 텍스트 파일을 읽기 위해 문자 스트림 FileReader 클래스 이용 3가지 방법
1. 파일 입력 스트림 생성
2. 파일 읽기
3. 스트림 닫기
#### 파일 입출력과 예외 처리
#### FileReader의 생성자와 주요 메소드
- FileReader(file file) file에 지정된 파일로부터 읽는 FileReader 생성
-
``` java
import java.io.*;

public class FileReaderEx{
    public static void main(String[] args){
        FileReader in = null;
        try{
            in=new FileReader("c:\\windows\\system.ini");
            int c;
            while((c=in.read())!= -1){// 한 문자씩 끝까지 읽는다.}
                System.out.print((char)c);
        }
        in.close();
    }
    catch(IOException e){
        System.out.println("입출력 오류");
    }
}
}
```
### 문자 스티림으로 텍스트 파일 쓰기
1. 파일 출력 스트림 생성(파일 열기); -> *유의사항* 괄호안에 파일이 있어야함
2. 파일 쓰기, write()로 문자 하나 씩 파일에 기록
```java
import java.io.*;
    public class test {
        public static void main(String[] args) {
            InputStreamReader in = new InputStreamReader(System.in);
            FileWriter fout = null;
            int c;
        try {
            fout = new FileWriter("c:\\Temp\\test.txt");
            while ((c = in.read()) != -1) {
                fout.write(c); // 키보드로부터 받은 문자를 파일에 저장, 터미널에 입력후 ctrl+c 누르면 저장
            }
            in.close();
            fout.close();
        }
        catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
```
### 바이트 스트림으로 바이너리 파일 쓰기
#### 바이너리 값을 파일에 저장하기
##### FileOutputStream 클래스를 이용하여 프로그램 내의 변수, 배열, 버터에 든 바이너리 값을 파일에 그대로 기록
```java
import java.io.*;
public class FileOutputStreamEx {
    public static void main(String[] args) {
        byte b[] = {7,51,3,4,-1,24};
        
        try {
            FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");
            for(int i=0; i<b.length; i++)
                fout.write(b[i]); // 배열 b의 바이너리를 그대로 기록

            fout.close();
        } catch(IOException e) { }
            System.out.println("c:\\Temp\\test.out을 저장하였습니다.");
        }       
}
```
#### 바이트 스트림으로 바이너리 파일 읽기
##### 바이너리 파일에서 읽기 위해 FileInputStream 클래스 이용
```java
import java.io.*;
public class FileInputStreamEx {
    public static void main(String[] args) {
        byte b[] = new byte [6]; // 비어 있는 byte 배열
    try {
        FileInputStream fin =
            new FileInputStream("c:\\Temp\\test.out");
        int n=0, c;
        while((c = fin.read())!= -1) {
            b[n] = (byte)c; // 읽은 바이트를 배열에 저장
            n++;
        }

        System.out.println(
            "c:\\Temp\\test.out에서 읽은 배열을 출력합니다.");
        for(int i=0; i<b.length; i++)
            System.out.print(b[i]+" ");
        System.out.println();

        fin.close();
        } catch(IOException e) { }
    }   
}
```
### File 클래스
#### 파일의 결로명 및 속성을 다루는 클래스 
- java.io.File
- 파일과 디렉터리 경로명의 추상적 표현
### File 클래스 활용
- 파일 크기 f.length();

## 14장 : 자바 소켓 프로그래밍
### TCP/IP 특징 소개
- 연결형 통신
    - 한번 연결 후 계속 데이터 전송 가능
### IP 주소
- 숫자로 구성된 주소 ex)192.168.11.14
- 현재는 32비트의 IP버전 4가 사용되고 있음
    - 하지만 IP주소 고갈로 인해 128비트의 IP버전 6(IPV6)이 점점 사용되는 추세
### 포트 - 항구
### 포트를 이용한 통신
- 3522.putty,2451.chrome
### 소켓 프로그래밍
### Socket 클래스, 클라이언트 소켓
- Socket(InetAddress address, int port) 소캣을 생성하고, IP주소와 포트번호에서 대기하는 서버에 연결
### 클라이언트에서 소켓으로 서버에 접속하는 코드
- Socket clientSocket=new Socket("129.12.1.1",0000);
    - Socket의 생성자에서 129.12.1.1 주소의 9999포트에 접속
### 서버에 클라이 언트가 연결되는 과정
- 서버는 서버 소켓으로 들어오는 연결 요청을 기다림(listen)
- 클라이언트가 서버에게 연결 요청
- 서버가 연결 요청 수락(accept)


## 2024-06-07 14주차
### 스윙 컴포넌트 그리기, paintComponent()
#### 스윙의 페인팅 기본
- 모든 컴포넌트는 자신의 모양을 스스로 그린다.
- 컨테이너는 자신을 그린 후 그 위에 자식 컴포넌트들에게 그리기 지시
- 모든 스윙 컴포넌트는 자신의 모양을 그리는 paintComponent()메소드 보유

#### public void painComponent(Gramphics g)
- 스윙 컴포넌트가 자신의 모양을 그리는 메소드
- JComponent의 메소드 : 모든 스윙 컴포넌트가 이 메소드를 오버라이딩함
- 언제 호출 되는가?
- 컴포넌트가 그려져야 하는 시점마다 호출
### paintComponent()의 오버라이딩과 JPanel
### 예제 11-1 : JPanel을 상속받은 패널에 도형 그리기
```java
package java2;

import javax.swing.*;
import java.awt.*;
public class paintJPanelEx extends JFrame {
    public paintJPanelEx() {
        setTitle("JPanel의 paintComponent() 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(250,200);
        setVisible(true);
    }
    // JPanel을 상속받는 새 패널 구현
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE); // 파란색 선택
            g.drawRect(10,10,50,50);
            g.drawRect(50,50,50,50);

            g.setColor(Color.MAGENTA); // 마젠타색 선택
            g.drawRect(90,90,50,50);
        }
    }
    public static void main(String [] args) {
        new paintJPanelEx();
    }
}

```

### 그래픽 기반 GUI 프로그래밍
#### 그래픽 기반 GUI 프로그래밍
##### 스윙 컴포넌트에 의존하지 않고 선, 원 이미지 등을 이용하여 직접 화면을 구성하는 방법
##### 그래픽 기반 GUI 프로그래밍의 학습이 필요한 이유
- 
### Graphic와 문자열 출력
#### Graphic의 기능
- 색상 선택, 문자열 ,도형 그리기, 도형 칠하기, 이미지 그리기, 클리핑
### 그래픽의 색과 폰트
#### 
### 예제 11-2 : Color와 Font를 이용하여 문자열 그리기
```java
import javax.swing.*;
import java.awt.*;
public class GraphicsColorFontEx extends JFrame {
    public GraphicsColorFontEx() {
        setTitle("문자열, Color, Font 사용 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(300, 300);
        setVisible(true);
}
    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE); // 파란색 지정
        g.drawString("자바가 정말 재밋다.~~", 30,30);
        g.setColor(new Color(255, 0, 0)); // 빨간색 지정
        g.setFont(new Font("Arial", Font.ITALIC, 30));
        g.drawString("How much?", 30, 70);
        g.setColor(new Color(0x00ff00ff));
        for(int i=1; i<=4; i++) {
            g.setFont(new Font("Jokerman", Font.ITALIC, i*10));
            g.drawString("This much!!", 30, 60+i*40);
        }
    }
}
    public static void main(String [] args) {
    new GraphicsColorFontEx();
    }
}
```
### 도형 그리기와 칠하기
#### 도형 그리기
- 선, 타원, 사각형, 둥근 모서리 사각형, 원호, 폐 다각형 그리기
- 선의 굵기 조절할 수 없음
#### 예제 11-3 : 선 그리기
```java
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
```
### repaint()
- 자바 플렛폼에게 컴포넌트 그리기를 강제 지시하는 메소드
#### 부모 컴포넌트부터 다시 그리는 것이 좋음
- 이 컴포넌트는 새로운 위치에 다시 그려지지만 이전의 위치에 있던 자신의 모양이 남아 있음
### 예제 11-7 : repaint()와 마우스를 이용한 타원 그리기
```java
package java2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GraphicsDrawOvalMouseEx extends JFrame {
    public GraphicsDrawOvalMouseEx() {
        setTitle("마우스 드래깅으로 타원 그리기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String [] args) {
    new GraphicsDrawOvalMouseEx();
    }
    // 타원을 그릴 패널 작성. 이 패널에 마우스 리스너 구현
    class MyPanel extends JPanel {
        java.awt.Point start=null;
        private java.awt.Point end=null; // 마우스 시작점, 끝점
        public MyPanel() {
            MyMouseListener listener = new MyMouseListener();

            // listener를 아래 두 리스너로 공통으로 등록해야 한다.
        addMouseListener(listener);
        addMouseMotionListener(listener);
        }
        class MyMouseListener extends MouseAdapter {
            public void mousePressed(MouseEvent e) {
                start = e.getPoint();
            }
        public void mouseDragged(MouseEvent e) {
                end = e.getPoint();
                repaint(); // 패널의 그리기 요청 주목
            }
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(start == null) // 타원이 만들어지지 않았음
                return;
            g.setColor(Color.BLUE); // 파란색 선택
            int x = Math.min(start.x, end.x);
            int y = Math.min(start.y, end.y);
            int width = Math.abs(start.x - end.x);
            int height = Math.abs(start.y - end.y);
            g.drawOval(x, y, width, height); // 타원 그리기
        }
    }
}
```
# 12 : 자바 스레드 기초
### 멀티테스킹
- 여러개의 작업(태스크)이 동시에 처리되는 것
### 멀티태스킹 프로그램 사례
- 미디어 플레이어, 테트리스 게임
### 스레드와 운영체제
- 운영체제에 의해 관리되는 하나의 작업 혹은 태스크
- 스레드와 태스크는 똑같은 의미 이다.(방식이 다를뿐)
#### 스레드 구성
##### 스레드 코드
- 개발자가 작성
- 작업을 실행하기 위해 작성한 프로그램 코드
##### 스레드 정보
- 운영체제가 스레드에 대해 관리하는 정보
- 스레드 명, 스레드 ID, 스레드의 실행 소요 시간, 스레드의 우선 순위등

### 멀티태스킹과 멀티스레딩
#### 멀티프로세싱
- 하나의 응용프로그램이 여러 개의 프로세스를 생성하고, 각 프로세스가 하나의 작업을 처리하는 기법
- 각 프로세스 독립된 메모리 영역을 보유하고 실행
- 프로세스 사이의 문맥 교환(프로세싱)에 따른 과도한 오버헤드와 시간 소모의
문제점
#### 멀티스레딩
- 하나의 응용프로그램이 여러 개의 스레드를 생성하고, 각 스레드가
 하나의 작업을 처리하는 기법
- 하나의 응용프로그램에 속한 스레드는 변수 메모리, 파일 오픈 테이
블 등 자원으로 공유하므로, 문맥 교환에 따른 오버헤드가 매주 작음
- 현재 대부분의 운영체제가 멀티스레딩을 기본으로 하고 있음

### 자바 스레드와 JVM
#### 자바 스레드
- 자바 가상 기계(JVM)에 의해 스케쥴되는 실행 단위의 코드 블럭
- 스레드의 생명 주기는 JVM에 의해 관리됨 : JVM은 스레드 단위로 스케쥴링
### 자바 스레드 만들기
#### 스레드 만드는 2가지 방법
- java.lang.Thread 클래스를 상속받아 스레드 작성
- java.lang.Runnable 인터페이스를 구현하여 스레드 작성

### Thread 클래스를 상속받아 스레드 만들기(1)
- void run, void start 중요
### Thread 클래스를 상속받아 스레드 만들기(2)
#### Thread를 상속받아 run() 오버라이딩
- Thread 클래스 상속. 새 클래스 작성
- run() 메소드 작성
- run() 메소드를 스레드 코드라고 부름
- run() 메소드에서 스레드 실행 시작
#### 스레드 객체 생성
- 생성된 객체는 필드와 메소드를 가진 객체일 뿐
스레드로 작동하지 않음
#### 스레드 시작
- start() 메소드 호출
- 스레드로 작동 시작
- 스레드 객체의 run()이 비로소 실행
- JVM에 의해 스케쥴되기 시작함

### 예제 12-1 : Thread를 상속받아 1초 단위 타이머 스레드 만들기
```java
package java2;
import java.awt.*;
import javax.swing.*;

class TimerThread extends Thread {
    private JLabel timerLabel; // 타이머 값이 출력되는 레이블
    public TimerThread(JLabel timerLabel) {
    this.timerLabel = timerLabel;
    }

// 스레드 코드. run()이 종료하면 스레드 종료
    @Override
    public void run() {
      int n=0; // 타이머 카운트 값
        while(true) { // 무한 루프
            timerLabel.setText(Integer.toString(n));
            n++; // 카운트 증가
            try {
                Thread.sleep(1000); // 1초동안 잠을 잔다.
            }
            catch(InterruptedException e) { return;}
        }
    }
}
public class ThreadTimerEx extends JFrame {
    public ThreadTimerEx() {
        setTitle("Thread를 상속받은 타이머 스레드 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        
        // 타이머 값을 출력할 레이블 생성
        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
        c.add(timerLabel);
        
        TimerThread th = new TimerThread(timerLabel);
        setSize(250,150);
        setVisible(true);
        th.start(); // 타이머 스레드의 실행을 시작하게 한다.
    }
    public static void main(String[] args) {
    new ThreadTimerEx();
    }
    }
```
### 스레드 종료와 타 스레드 강제 종료
#### 스스로 종료
- run() 메소드 리텅
#### 타 스레드에서 강제 종료
- interrupt() 메소드 사용

### 예제 12-4 정답
```java
package java2;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class VibratingFrame extends JFrame implements Runnable
{
    private Thread th; // 진동하는 스레드
    public VibratingFrame() {
        setTitle("진동하는 프레임 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);
        setLocation(300,300);
        setVisible(true);
        
        getContentPane().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(!th.isAlive()) return;
                    th.interrupt();
            }
        });
        
        th = new Thread(this); // 진동하는 스레드 객체 생성
        th.start(); // 진동 시작
    }
    @Override
    public void run() { // 프레임의 진동을 일으키기 위해
            // 20ms마다 프레임의 위치를 랜덤하게 이동
            Random r = new Random();
            while(true) {
                try {
                    Thread.sleep(20); // 20ms 잠자기
                }
                catch(InterruptedException e){
                return; // 리턴하면 스레드 종료
                }
                int x = getX() + r.nextInt()%5; // 새 위치 x
                int y = getY() + r.nextInt()%5; // 새 위치 y
                setLocation(x, y); // 프레임의 위치 이동
            }
        }
        public static void main(String [] args) {
        new VibratingFrame();
        }
}
```
### 스레드 동기화
#### 멀티스레드 프로그램 작성시 주의점
#### 스레드 동기화
- 스레드 사이의 실행순서 제어, 공유데이터에 대한 접근을 원활하게 하는 기법
#### 멀티스레드의 공유 데이터의 동시 접근 문제 해결
- (방법1)공유 데이터를 접근하는 모든 스레드의 한 줄 세우기
- (방법2)한 스레드가 공유 데이터에 대한 작업을 끝낼 때까지 다른 스레드가 대기 하도록 함
#### 자바의 스레드 동기화 방법
- synchronized 키워드로 동기화 블록 지정
- wait()-notify() 메소드로 스레드의 실행 순서 제어

### synchronized 블록 지정
#### 스레드가 독점적으로 실행해야 하는 부분을 표시하는 키워드
- 임계 영역 표기 키워드
- synchronized 블록 지정 방법 = 메소드 전체 혹은 코드블록

### wait-notify()를 이용한 스레드 동기화
#### wait-notify()가 필요한 경우
- 공유 데이터로 두 개 이상의 스레드가 데이터를 주고 받을 때
- ex)producer-consumer문제
### 동기화 메소드
- wait() : 다른 스레드가 notify를 불러줄 때까지 기다린다.
- notify() : wait()를 호출하여 대기중인 스레드를 깨운다.
### 예제 12-6 정답
```java
package java2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyLabel extends JLabel {
    private int barSize = 0; // 바의 크기
    private int maxBarSize;

    public MyLabel(int maxBarSize) {
        this.maxBarSize = maxBarSize;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        int width = (int)(((double)(this.getWidth()))
            /maxBarSize*barSize);
        if(width==0) return;
        g.fillRect(0, 0, width, this.getHeight());
    }

    synchronized void fill() {
        if(barSize == maxBarSize) {
            try {
                wait();
            } catch (InterruptedException e) { return; }
        }
        barSize++;
        repaint(); // 바 다시 그리기
        notify();
    }
    synchronized void consume() {
        if(barSize == 0) {
            try {
                wait();
            } catch (InterruptedException e)
                { return; }
    }
    barSize--;
    repaint(); // 바 다시 그리기
    notify();
    }
}
class ConsumerThread extends Thread {
    private MyLabel bar;

    public ConsumerThread(MyLabel bar) {
        this.bar = bar;
    }
    @Override
    public void run() {
        while(true) {
            try {
            sleep(200);
            bar.consume();
            } catch (InterruptedException e)
            { return; }
         }
    }
}
public class TabAndThreadEx extends JFrame
{
    private MyLabel bar = new MyLabel(100);
    public TabAndThreadEx(String title) {
        super(title);
        this.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);
        bar.setBackground(Color.ORANGE);
        bar.setOpaque(true);
        bar.setLocation(20, 50);
        bar.setSize(300, 20);
        c.add(bar);

        c.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e)
        {
            bar.fill();
        }
    });
    setSize(350,200);
    setVisible(true);

    c.setFocusable(true);
    c.requestFocus();
    ConsumerThread th = new
        ConsumerThread(bar);
    th.start(); // 스레드 시작
    }
    public static void main(String[] args) {
    new TabAndThreadEx(
    "아무키나 빨리 눌러 바 채우기");
    }
}
```
## 2024-05-31 13주차
# 10 : 스윙 컴포넌트 활용
### 자바의 GUI 프로그래밍 방법(2종류)
#### 자바의 GUI 프로그래밍
- 스윙 컴포넌트를 이용하여 쉽게 GUI 구축
자바에서 제공하는 컴포넌트의 한계를 벗어나지 못함
#### 그래픽 기반 GUI 프로그래밍
- 그래픽을 이용하여 GUI 구축
#### 컴포넌트 기반 GUI 프로그래밍에 사용되는 스윙 컴포넌트 
- **p392** 참고
### 스윙 컴포넌트의 상속 구조
#### Jcomponent
- 스윙 컴포넌트는 모두 상속받는 슈퍼 클래스, 추상 클래스
- 스윙 컴포넌트들이 상속받는 공통 메소드와 상수 구현
- JComponent의 주요 메소드 사례(**p393** 참고)

### 스윙 컴포넌트 공통 기능, JComponent의 메소드
```java
package java2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JComponentEx extends JFrame {
    public JComponentEx() {
        super("JComponent의 공통 메소드 예제");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton b1 = new JButton("Magenta/Yellow Button");
        JButton b2 = new JButton(" Disabled Button ");
        JButton b3 = new JButton("getX(), getY()");
        b1.setBackground(Color.YELLOW); 
        b1.setForeground(Color.MAGENTA);
        b1.setFont(new Font("Arial", Font.ITALIC, 20)); 
        b2.setEnabled(false); 
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
             setTitle(b.getX() + "," + b.getY()); 
        }
    });
    c.add(b1); c.add(b2); c.add(b3);
    setSize(260,200); setVisible(true);
}
    public static void main(String[] args) {
    new JComponentEx();
    }
}
```
### JLabel로 문자열과 이미지 출력
#### JLabel의 용도
- 문자열이나 이미지를 화면에 출력하기 위한 목적
#### JLabel 이용 문자열과 이미지 출력 예제
```java
package java2;

import javax.swing.*;
import java.awt.*;
    public class LabelEx extends JFrame {
        public LabelEx() {
            setTitle("레이블 예제");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container c = getContentPane();
            c.setLayout(new FlowLayout());
            JLabel textLabel = new JLabel("제임스 고슬링 입니더!");
            ImageIcon img = new ImageIcon("images/img1.jpg"); 
            JLabel imageLabel = new JLabel(img);
            ImageIcon icon = new ImageIcon("images/img2.jpg"); 
            JLabel label = new JLabel("커피한잔 하실래예, 전화주이소",
            icon, SwingConstants.CENTER);
            c.add(textLabel); c.add(imageLabel); c.add(label);
            setSize(300,500);
            setVisible(true);
        }
        public static void main(String [] args) {
        new LabelEx();
        }
}
```
### 이미지 버튼 만들기
#### 하나의 버튼에 3개의 이미지 등록
- 마우스 조작에 따라 3개의 이미지 중 적절한 이미지 자동 출력
#### 3개의 버튼 이미지
##### - normalicon
- 버튼의 보통 상태때 출력되는 이미
- 생성자에 이미지 아이콘 전달 혹은 JButton의 setIcon(normlIcon);
##### - rollovericon
- 버튼에 마우스가 올라갈 때 출력되는 이미지
- 이미지 설정 메소드 : JButton의 setRolloverIcon(rolloverIcon);
##### pressedicon
- 버튼을 누른 상태 때 출력되는 이미지
- 이미지 설정 메소드 : JButton의 setPressedIcon(pressdIcon);
#### JButton을 이용한 이미지 버튼 만들기 예제
```java
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
```
### JCheckBox로 체크박스 만들기
#### JCheckBox의 용도
- 선택(selected)과 비선택(deselected) 두 상태만 가지는 버튼
#### 체크 박스 생성
- JChekBox() : 빈 체크박스
- JCheckBox(Icon image) : 이미지 체크박스
- JCheckBox(Icon image, boolean selected) : 이미지 체크 박스
- JCheckBox(String text, Icon image) : 문자열과 이미지를 가진 체크박스
- JCheckBox(String text, Icon, booLean selected) : 문자열과 이미지 체크박스

#### 문자열을 가진 체크박스 생성 예
- JCheckBox apple = new JCheckBox("사과"); //"사과" 체크박스 생성
- JCheckBox pear = new JCheckBox("배",true); // 선택 상태의 "배" 체크박스 생성

### 예제 10-4 :JCheckBox로 체크박스 만들기
```java
package java2;
import javax.swing.*;
import java.awt.*;
    public class CheckBoxEx extends JFrame {
        public CheckBoxEx() {
        setTitle("체크박스 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        // 3개의 체크박스를 생성한다.
        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배", true);
        JCheckBox cherry = new JCheckBox("체리");
        c.add(apple);
        c.add(pear);
        c.add(cherry);
        setSize(250,150);
        setVisible(true);
    }
    public static void main(String [] args) {
    new CheckBoxEx();
    }
}

```
### 체크박스에 item 이벤트 처리
#### Item 이벤트
##### 체크박스의 선택 상태에 변화가 생길 때
- 사용자가 마우스나 키보드로 체크박스를 선택/해체할 때
- 프로그램에서 체크박스를 선택/해제하여 체크 상태에 변화가 생길 때
    JCheckBox("사과");
    c.setsSelected(true); // 선택 상태로 변경
##### 이벤트가 발생하면 itemEvent 객체 생성
##### itemListener 리스너를 이용하여 이벤트 처리

#### ItemListener 리스너의 추상 메소드
- void itemStateChanged(ItemEvent e)체크박스의 선택 상태가 변하는 경우 호출
#### ItemEvent의 주요 메소드
- int getStateChange() //체크박스가 선택되니 경우 ItemEvent.SELECTED를, 해체된 경우 ItemEvent.DESELECTED를 리턴한다.
- Object getItem() // 이벤트를 발생시킨 아이템 객체를 리턴한다. 체크박스의 경우 JCheckBox 컴포넌트의 레퍼런스를 리턴한다.
### 10-5 예제
**포인트( 핸들러 함수가 어떻게 사용되는지)**
```java
package java2;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
    public class CheckBoxItemEventEx extends JFrame {
    private JCheckBox [] fruits = new JCheckBox [3]; 
    private String [] names = {"사과", "배", "체리"}; 
    private JLabel sumLabel;
    public CheckBoxItemEventEx() {
    setTitle("체크박스와 ItemEvent 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
    MyItemListener listener = new MyItemListener();
    for(int i=0; i<fruits.length; i++) {
        fruits[i] = new JCheckBox(names[i]); 
        fruits[i].setBorderPainted(true);
        c.add(fruits[i]);
        fruits[i].addItemListener(listener);
    }
    sumLabel = new JLabel("현재 0 원 입니다."); 
    c.add(sumLabel);
    setSize(250,200);
    setVisible(true);
    }
    // Item 리스너 구현
    class MyItemListener implements ItemListener {
        private int sum = 0; // 가격의 합
        public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) { 
            if(e.getItem() == fruits[0])
                sum += 100;
            else if(e.getItem() == fruits[1])
                sum += 500;
        else
            sum += 20000;
        }
        else {
        if(e.getItem() == fruits[0])
            sum -= 100;
        else if(e.getItem() == fruits[1])
            sum -= 500;
        else
            sum -= 20000;
        }
        sumLabel.setText("현재 " + sum + "원 입니다."); 
        }
    }
    public static void main(String [] args) {
    new CheckBoxItemEventEx();
    }
 }
    
```
### JRadioButton으로 라디오 버튼 만들기
#### JRadioButton의 용도
##### 버튼 그룹을 형성하고, 그룹에 속한 버튼 중 하나만 선택되는 라디오 버튼
##### 체크박스와의 차이점
- 체크박스는 각각 선택/해제가 가능하지만, 라디오버튼은 그룹에 속한 버튼 중 하나만 선택
### 라디오버튼 생성 및 item 이벤트 처리
#### 버튼 그룹과 라디오 버튼 생성 과정
```
1. 버튼 그룹 객체 생성
ButtonGroup group = new ButtonGroup();

2.라디오 버튼 생성
JRadioButton apple= new JRadioButton("사과");
JRadioButton pear= new JRadioButton("배");
JRadioButton cherry= new JRadioButton("체리");

3.라디오버튼을 버튼 그룹에 삽입
group.add(apple);
group.add(pear);
group.add(cherry);

4.라디오 버튼을 컨테이너에 삽입
container.add(apple);
container.add(pear);
container.add(cherry)
```
### 예제 10-6 : JRadioButton으로 라디오 버튼 만들기
```java
import javax.swing.*;
import java.awt.*;

public class RadioButtonEx extends JFrame {
    public RadioButtonEx() {
        setTitle("라디오버튼 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        ButtonGroup g = new ButtonGroup(); // 버튼 그룹 객체 생성
        JRadioButton apple = new JRadioButton("사과");
        JRadioButton pear = new JRadioButton("배", true);
        JRadioButton cherry = new JRadioButton("체리");
    // 버튼 그룹에 3개의 라디오버튼 삽입
    g.add(apple);
    g.add(pear);
    g.add(cherry);
    // 컨텐트팬에 3개의 라디오버튼 삽입
    c.add(apple); c.add(pear); c.add(cherry);
    setSize(250,150);
    setVisible(true);
    }
    public static void main(String [] args) {
    new RadioButtonEx();
    }
}

```
### JTextField로 한 줄 입력 창 만들기
#### JTextField
#### 한 줄의 문자열을 입력 받는 창(텍스트 필드)
- 텍스트 입력 도중<Enter>키가 입력되면 Action 이벤트 발생
- 입력 가능한 문자 개수와 입력 창의 크기는 서로 다름
#### 텍스트 필드 생성
- JTextField() // 빈 텍스트필드
- JTextField(int cols) // 입력 창의 열의 개수가 cols개인 텍스트필드
- JTextField(String text)// text 문자열로 초기화된 텍스트필드
- JTextField(String text, int cols) // 입력 창의 열의 개수는 cols개이고 text문자열로 초기화된 텍스트 필드
#### "컴퓨터공학과"로 초깃값을 가지는 텍스트 필드 생성 예
- JTextField tf2 = new JTextField("컴퓨터공학과");
### 예제 10-7 : JTextField로 텍스트필드 만들기
```java
package java2;

import javax.swing.*;
import java.awt.*;

public class TextFieldEx extends JFrame {
    public TextFieldEx() {
        setTitle("텍스트필드 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
            
    c.setLayout(new FlowLayout());
    c.add(new JLabel("이름 "));
    c.add(new JTextField(20));
    c.add(new JLabel("학과 "));
    c.add(new JTextField("컴퓨터공학과", 20)); 
    c.add(new JLabel("주소 "));
    c.add(new JTextField("서울시 ...", 20)); 
    setSize(300,150);
    setVisible(true);
    }
    public static void main(String [] args) {
        new TextFieldEx();
    }
}
```
### JTextArea로 여러 줄의 입력 창 만들기
#### JTextArea
##### 여러 줄의 문자열을 입력받을 수 있는 창(텍스트영역)
- 스크롤바를 지원하지 않는다.
- JScrollPane 객체에 삽입하여 스크롤바 지원받음
#### 생성자
- JTextArea() // 빈텍스트영역
- JTextArea(int rows, int cols) // 입력창이 rows x cols개의 문자 크기인 텍스트 영역
- JTextArea(String text) //text 문자열로 초기화된 텍스트영역
- JTextArea(String text,int **rows**, int cols) //입력 창이 **rows** x cols개의 문자 크기이며 text문자열로 초기화된 텍스트 영역
### 예제 10-8 :JTextArea로 여러 줄이 입력되는 창 만들기
```java
package java2;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextAreaEx extends JFrame {
    private JTextField tf = new JTextField(20);
    private JTextArea ta = new JTextArea(7, 20); 

    public TextAreaEx() {
        setTitle("텍스트영역 만들기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
        c.add(tf);
        c.add(new JScrollPane(ta));

        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField t = (JTextField)e.getSource();
                ta.append(t.getText() + "\n"); 
                t.setText(""); 
            }
        });
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String [] args) {
    new TextAreaEx();
    }
}
```
### JList<E>
#### JList<E>
##### 하나 이상의 아이템을 보여주고 아이템을 선택하도록 하는 리스트
##### JAVA 7부터 제네릭 리스트로 바뀜
- <E>에 지정된 타입의 객체만 저장하는 리스트
##### JScrollPane에 JList<E>를 삽입하여 스크롤 가능
#### 리스트 생성
- JList<E>() // 빈 리스트
- JList<E>(Vector listData) //벡터로부터 아이템을 공급받는 리스트
- JList<E>(Object [] listData) // 배열로부터 아이템을 공급받는 리스트
#### 예) 9개의 과일 이름 문자열이 든 리스트 만들기
- String []fruits={"apple","banana","kiwi","mango","pear","peach","berry","strawberry", "blackberry"};  
JList <String> strList = new JList<String>(fruits);
### 예제 10-9 : JList<E>로 다양한 리스트 만들기
```java
package java2;

import javax.swing.*;
import java.awt.*;
public class ListEx extends JFrame {
    private String [] fruits= {"apple", "banana", "kiwi", "mango", 
        "pear", "peach", "berry", "strawberry", "blackberry"};
    private ImageIcon [] images = { new ImageIcon("images/icon1.png"),
                            new ImageIcon("images/icon2.png"),
                            new ImageIcon("images/icon3.png"),
                            new ImageIcon("images/icon4.png") };

public ListEx() {
    setTitle("리스트 만들기 예제");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(new FlowLayout());

    JList<String> strList = new JList<String>(fruits); 
    c.add(strList);

    JList<ImageIcon> imageList = new JList<ImageIcon>(); 
    imageList.setListData(images); 
    c.add(imageList);

    JList<String> scrollList = new JList<String>(fruits); 
    c.add(new JScrollPane(scrollList)); 

    setSize(300,300); setVisible(true);
    }
    public static void main(String [] args) {
    new ListEx();
    }
}
```
### JComboBox<E>
#### JComboBox<E>
- 텍스트필드와 버튼, 그리고 드롭다운 리스트로 구성되는 콤보박스
-드롭다운 리스트에서 선택한 것이 텍스트필드에 나타남
#### 콤보박스 생성
- JComboBox<E>() // 빈콤보박스
- JComboBox<E>(Vector listData) // 벡터로부터 아이템을 공급받는 콤보박스
- JComboBox<E>(Object[]listData) // 배열로부터 아이템을 공급받는 콤보박스
##### 예) 텍스트를 아이템으로 가진 콤보 박스 생성
```
String [] fruits = {"apple", "banana", "kiwi", 
        "mango", "pear", "peach", 
        "berry", "strawberry", "blackberry" };
JComboBox<String> combo = new JComboBox<String>(fruits);
```
### JComboBox<E>로 콤보박스 만들고 활용하기
```java
package java2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class ComboActionEx extends JFrame {
    private String [] fruits = {"apple", "banana", "mango"}; 
    private ImageIcon [] images = { new ImageIcon("images/apple.jpg"),
                        new ImageIcon("images/banana.jpg"),
                        new ImageIcon("images/mango.jpg") };
    private JLabel imgLabel = new JLabel(images[0]); 

    public ComboActionEx() {
    setTitle("콤보박스 활용 예제");
    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    JComboBox<String> combo = new JComboBox<String>(fruits); 
    c.add(combo); c.add(imgLabel);

    // 콤보박스에 Action 리스너 등록. 선택된 아이템의 이미지 출력
    combo.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JComboBox<String> cb = (JComboBox<String>)e.getSource(); 
            int index = cb.getSelectedIndex(); 
            imgLabel.setIcon(images[index]); 
            }
    });
    setSize(300,250);
    setVisible(true);
    }
    public static void main(String [] args) {
    new ComboActionEx();
    }
}
```

### 메뉴 구성
#### 메뉴 만들기에 필요한 스윙 컴포넌트
##### 메뉴아이템 - JMenuItem
##### 메뉴 - JMenu
- 여러 개의 메뉴 아이템을 가짐
##### 메뉴바 – JMenuBar
- 여러 개의 메뉴를 붙이는 바이며, 프레임에 부착됨
##### 분리선
- 메뉴아이템 사이의 분리선으로 separator라고 부름
- JMenu의 addSeparator()를 호출하여 삽입함

### 메뉴 만드는 과정
```
(1) JMenuBar 컴포넌트 생성 
JMenuBar mb = new JMenuBar();
(2) JMenu 컴포넌트를 생성하여 JMenuBar에 붙인다
JMenu screenMenu = new JMenu("Screen");
mb.add(screenMenu);
(3) JMenuItem 컴포넌트를 생성하여 JMenu에 붙인다.  
(3’) 여러 개의 메뉴와 메뉴 아이템을 생성한다.
screenMenu.add(new JMenuItem("Load"));
screenMenu.add(new JMenuItem("Hide"));
screenMenu.add(new JMenuItem("ReShow"));
screenMenu.addSeparator();
screenMenu.add(new JMenuItem("Exit"));
(4) JMenuBar 컴포넌트를 JFrame에 붙인다.
frame.setJMenuBar(mb)
```
#### 예제 10-11 : 메뉴 만들기
```java
package java2;

import javax.swing.*;

public class MenuEx extends JFrame {
public MenuEx() {
    setTitle("Menu 만들기 예제");
    createMenu(); // 메뉴 생성, 프레임에 삽입
    setSize(250,200);
    setVisible(true);
}
public void createMenu() {
    JMenuBar mb = new JMenuBar(); 

    JMenu screenMenu = new JMenu("Screen");
    screenMenu.add(new JMenuItem("Load"));
    screenMenu.add(new JMenuItem("Hide"));
    screenMenu.add(new JMenuItem("ReShow"));
    screenMenu.addSeparator();
    screenMenu.add(new JMenuItem("Exit"));

    mb.add(screenMenu);
    mb.add(new JMenu("Edit"));
    mb.add(new JMenu("Source"));
    mb.add(new JMenu("Project"));
    mb.add(new JMenu("Run"));
    setJMenuBar(mb);
    }
    public static void main(String [] args) {
    new MenuEx();
    }
}
```
### 메뉴아이템에 Action 이벤트 달기
#### 메뉴아이템을 클릭하면 Action 발생
- 메뉴아이템은 사용자로부터의 지시나 명령을 받는데 사용
- ActionListener 인터페이스로 리스너 작성
- 각 메뉴아이템마다 이벤트 리스너 설정  

##### 예) Load 메뉴아이템에 Action 리스너를 작성하는 경우
```
JMenuItem item = new JMenuItem("Load");
item.addActionListener(new MenuActionListener()); // 메뉴아이템에 Action 리스너 설정
screenMenu.add(item);
class MenuActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
    // 사용자가 Load 메뉴아이템을 선택하는 경우 처리할 작업 구현...
    }
}
```

### 예제 10-12 : 메뉴에 Action 리스너 활용
```java
package java2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class MenuActionEventEx extends JFrame {
    private JLabel imgLabel = new JLabel(); // 빈 레이블

    public MenuActionEventEx() {
        setTitle("Menu에 Action 리스너 만들기 예제");
        createMenu();
        getContentPane().add(imgLabel, BorderLayout.CENTER);
        setSize(250,200); setVisible(true);
    }
    
    public void createMenu() { 
        JMenuBar mb = new JMenuBar(); // 메뉴바 생성
        JMenuItem [] menuItem = new JMenuItem [4];
        String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};
        JMenu screenMenu = new JMenu("Screen");
        MenuActionListener listener = new MenuActionListener(); 

        for(int i=0; i<menuItem.length; i++) {
            menuItem[i] = new JMenuItem(itemTitle[i]); 
            menuItem[i].addActionListener(listener); 
            screenMenu.add(menuItem[i]);
        }
    mb.add(screenMenu); 
    setJMenuBar(mb); // 메뉴바를 프레임에 부착
    }
    class MenuActionListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand(); 
            switch(cmd) { // 메뉴 아이템의 종류 구분
                case "Load" :
                    if(imgLabel.getIcon() != null) return; 
                                            // 이미 로딩되었으면 리턴
                    imgLabel.setIcon(new 
                                ImageIcon("images/img.jpg")); 
                    break;
                case "Hide" :
                    imgLabel.setVisible(false); break;
                case "ReShow" :
                    imgLabel.setVisible(true); break;
                case "Exit" :
                    System.exit(0); break;
                }
            }
        }
        public static void main(String [] args) {
        new MenuActionEventEx();
        }
}

```

### 팝업 다이얼로그, JOptionPane
#### 팝업 다이얼로그
#####  사용자에게 메시지를 전달하거나 문자열을 간단히 입력받는 용도
##### JOptionPane 클래스를 이용하여 생성
- static 타입의 간단한 메소드 이용
#### 입력 다이얼로그 - JOptionPane.showInputDialog()
##### 한 줄을 입력 받는 다이얼로그
```
String name = JOptionPane.showInputDialog("이름을 입력하세요.");
// name에 "Java Kim"이 리턴
// 취소 버튼이나, 입력 없이 다이얼로그가 닫히면 null 리턴
```
### 확인 다이얼로그
#### 확인 다이얼로그 - JOptionPane.showConfirmDialog()
##### 사용자로부터 Yes/No 응답을 입력 받는 다이얼로그
- JOptionPane.showConfirmDialog(Component parentComponent, Object msg, String title, int optionType)
- parentComponent : 다이얼로그의 부모 컴포넌트로서 다이얼로그가 출력되는 영역의 범위 지정을 위해 사용(예: 프레임). null이면 전체 화면 중앙에 출력
- msg : 다이얼로그 메시지
- title : 다이얼로그 타이틀
- optionType : 다이얼로그 옵션 종류 지정
    YES_NO_OPTION, YES_NO_CANCEL_OPTION, OK_CANCEL_OPTION
- 리턴 값 : 사용자가 선택하나 옵션 종류
    YES_OPTION, NO_OPTION, CANCEL_OPTION, OK_OPTION, CLOSED_OPTION

### 메시지 다이얼로그
####  메시지 다이얼로그 – showMessageDialog
##### 단순 메시지를 출력하는 다이얼로그
- static void JOptionPane.showMessageDialog(Component parentComponent, Object msg, String title, int messageType)
- parentComponent : 다이얼로그의 부모컴포넌트로써 다이얼로그가 출력되는 영역의 범위 지정을 위해 사용. null 이면 전체 화면 중앙 출력
- msg : 다이얼로그 메시지
- title : 다이얼로그 타이틀
- messageType : 다이얼로그의 종류로서 다음 중 하나
    ERROR_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, QUESTION_MESSAGE, PLAIN_MESSAGE

### 예제 10-13 : JOptionPane으로 3가지 팝업 다이얼로그 만들기
```java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class OptionPaneEx extends JFrame {
    public OptionPaneEx() {
        setTitle("옵션 팬 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        setSize(500,200);
        c.add(new MyPanel(), BorderLayout.NORTH);
        setVisible(true);
        }
    class MyPanel extends Panel {
        private JButton inputBtn = new JButton("Input Name");
        private JTextField tf = new JTextField(10);
        private JButton confirmBtn = new JButton("Confirm");
        private JButton messageBtn = new JButton("Message");

        public MyPanel() {
            setBackground(Color.LIGHT_GRAY);
            add(inputBtn);
            add(confirmBtn);
            add(messageBtn);
            add(tf);
        
            inputBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String name = 
                        JOptionPane.showInputDialog("이름을 입력하세요.");
                if(name != null)
                        tf.setText(name);
            }
            });
            confirmBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int result = JOptionPane.showConfirmDialog(null, 
                        "계속할 것입니까?", "Confirm", 
                                JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.CLOSED_OPTION)
                        tf.setText("Just Closed without Selection");
                    else if(result == JOptionPane.YES_OPTION)
                        tf.setText("Yes");
                    else
                        tf.setText("No");
                        }
                    });
                    messageBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JOptionPane.showMessageDialog(null, 
                                "조심하세요", "Message", 
                                        JOptionPane.ERROR_MESSAGE); 
                        }
                    });
                }
            }
            public static void main(String [] args) {
            new OptionPaneEx();
            }

}

```
## 2024-05-24 12주차
수업 진행 -> 9장 -> 12,13장 -> 10장 스윙 컴포넌트(버튼 라벨 제외 전에 배웠기 때문에)  

### 이벤트 기반 프로그래밍 
#### 이벤트 기반 프로그래밍  
이벤트의 발생에 의해 프로그램 흐름이 결정되는 방식
- 이벤트가 발생하면 이벤트를 처리하는 루틴 실행
- 실행할 코드는 이벤트의 발생에 의해 견적으로 결정
#### 반대되는 개념 : 베치 실행
프로그램의 개발자가 프로그램의 흐름을 결정하는 방식
#### 이벤트 종류
- 사용자의 입력 : 마우스 드레그, 마우스 클릭, 키보드 누름
- 센서부터의 입력, 네트워크로부터 데이터 송수신
- 다른 응용프로그램이나 다른 스레드로부터의 메세지
#### 이벤트 기반 응용 프로그램의 구조
- 각이벤트마다 처리하는 리스너 코드 보유
#### GUI 응용프로그램은 이벤트 기반 프로그래밍으로 작성됨
- GUI 라이브러리 종류(C++의 NFC, C#GUI, Visual Basic, X Window, Android등, 자바의 AWT와 Swing)
### 자바 스윙 프로그램에서 이벤트 처리 과정
### 이벤트가 처리되는 과정
#### 이벤트 발생
- 예: 마우스의 움직임 혹은 키보드 입력
#### 이벤트  객체 생성
- 현재 발생한 이벤트에 대한 정보를 가진 객체
#### 응용프로그램에 작성된 이벤트 리스너 찾기
#### 이벤트 리스너 실행
- 리스너에 이벤트 객체 전달
- 리스너 코드 실행

### 이벤트 객체
#### 이벤트 객체
- 발생한 이벤트에 고나한 정보를 가진 객체
- 이벤트 리스너에 전달됨(이벤트 리스너 코드가 발생한 이벤트에 대한 상황을 파악할 수 있게 함)

### 이벤트 객체가 포함하는 정보
- 이벤트 종류와 이벤트 소스
- 이벤트가 발생한 화면 좌표 및 컴포넌트 내 좌표
- 이벤트가 발생한 버튼이나 메뉴 아이템의 문자열
- 클릭된 마우스 버튼 번호 및 마우스의 클릭 횟수
- 키의 코드 값과 문자 값
- 체크박스, 라디오 버튼 등과 같은 컴포넌트에 이벤트가 발생하였다면 체크 상태

### 이벤트 소스를 알아내는 메소드
### Object getSour0ce()
- 발생한 이벤트의 소스 컴포넌트 리턴
- object 타입으로 리턴하므로 캐스팅하여 사용
- 모든 이벤트 객체에 대해 적용

### 이벤트 객체, 이벤트 소스, 발생하는 경우
- p358 한번씩 읽어보기

### 리스터 인터페이스
#### 이벤트 리스너
- 이벤트를 처리하는 자바 로그램 코드, 클래스로 작성
#### 자바는 다양한 리스터 인터페이스 제공
- 예) ActionListerner 인터페이스 - 버튼 클릭 이벤트를 처리하기 위한 인터페이스
- 예) MouseListener 인터페이스 - 마우스 조작에 따른 이벤트를 처리하기 위한 인터페이스
#### 사용자의 이벤트 리스터 작성
- 자바의 리스너 인터페이스를 상속받아 구현


### 이벤트 리스너 작성 과정 사례
1. 이벤트와 이벤트 리스너 선택
- 버튼 클릭을 처리하고자 하는 경우
- 이벤트 : Action 이벤트, 이번트 리스너 :ActionListener
2. 이벤트 리스너 클래스 작성 : ActionListener 인터페이스 구성 ***p361***
3. 이벤트 리스너 등록 
- 이벤트를 받아 처리하고자 하는 컴포넌트에 이벤트 리스너 등록
- componentaddXXXListener(listener)
- xxx : 이벤트 명, listener : 이벤트 리스너 객체 
***p361***

### 이벤트 리스너 작성 방법
### 3가지 방법
#### 독립 클래스로 작성
- 이벤트 리스너를 완전한 클래스로 작성
- 이벤트 리스너를 여러 곳에서 사용할 때 적합
## 예제
```java package java2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class IndepClassListener extends JFrame{
    public IndepClassListener() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        setSize(250,120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new IndepClassListener();
    }

    
}


class MyActionListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action"))
        b.setText("액션");
        else
        b.setText("Action");
}
}
```
#### 내부 클래스(inner class)로 작성
- 클래스 안에 멤버처럼 클래스 작성
- 이벤트 리스너를 특정 클래스에서만 사용할 때 적합
## 예제
```java package java2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InnerClassListener extends JFrame{
    public InnerClassListener() {
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        setSize(250,120);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action"))
        b.setText("액션");
        else
            b.setText("Action");

            InnerClassListener.this.setTitle(b.getText());
        }
    }
    public static void main(String[] args) {
        new InnerClassListener();
    }

}
```
#### 익명 클래스(anonymous class)로 작성
- 클래스의 이름 없이 간단히 리스너 작성
- 클래스 조차 만들 필요 없이 리스너 코드가 간단한 경우에 적합


### 익명 클래스로 이벤트 리스너 작성
#### 익명 클래스(annoymous class):아름 없는 클래스
- (클레스 선언 + 인스턴스 생성)을 한번에 달성
- 간단한 리스너의 경우 익명 클레스 사용 추천
#### ActionListener를 구현하는 익명의 이벤트 리스너 작성 예
- P364
## 예제
```java package java2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnonymousClassListener extends JFrame{
    public AnonymousClassListener() {
        setTitle("Action 이벤트 리스너 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        c.add(btn);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action"))
                b.setText("액션");
                else
                b.setText("Action");

                setTitle(b.getText());
            }
        });

        setSize(200,120);
        setVisible(true);
    }
    public static void main(String[] args) {
        new AnonymousClassListener();
    }

    
}
```
### 예제 9-4 마우스 이벤트 리스너 작성 연습 - 마우스로 문자열 이동 시키기
```java package java2;

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

```
### 어댑터 클래스
#### 이벤트 리스너 구현에 따른 부담
- 리스너의 추상 메소드를 모두 구현해야 하는 부담
- 예) 마우스 리스너에서 마우스가 눌러지는 경우(mousePressed())만 처리하고자 하는 경우도 나머지 4개의 메소드를 모두 구현해야 하는 부담

### Key 이벤트와 포커스
#### 키 입력 시, 다음 세 경우 각각 Key 이벤트 발생
- 키를 누르는 순간
- 누른 키를 떼는 순간
- 누른 키를 떼는 순간(Unicode키의 경우에만)

#### 키 이벤트를 받을 수 있는 조건 
- 모든 컨포넌트
- 현재 포커스(focus)를 가진 컴포넌트가 키 이벤트 독점

#### 포커스(focus) - 강제로 지정할 때 사용하는 것
- 컴포넌트나 응용프로그램이 키 이벤트를 독점하는 권한
- 컴포넌트에 포커스 설정 방법 : 다음 2라인 코드 필요
- compoent.setFocusable(true);  // compenent가 포커스를 받을 수 있도록 설정한다.
- compoent.requestFocus(); // component에게 포커스를 주어 키 입력을 방을 수 있게 함

### 유니코드(Unicode) 키
#### 유니코드 키의 특징
- 국제 산업 표준
- 전 세계의 문자를 컴퓨터에서 일관되게 표현하기 위한 코드 체계
- 문자들에 대해서만 키 코드 값 정의 (A-Z,a-z,0-9,@,&등)
- 문자가 아닌 키 경우에는 표준호된 키코드 값 없음

#### 유니코드 키가 입력되는 경우
- KeyPressed(),KetTyped(), KeyReleased()가 순서대로 호출

#### 유니코드 키가 아닌 경우

### 가상 키와 입력된 키 판별
#### KetEvent 객체
- 입력된 키 정보를 가진 이벤트 객체
- KeyEvent 객체의 메소드로 입력된 키 판별
#### KeyEvent 객체의 메소드로 입력된 키 판별
#### char KeyEventgetKeyChar()
- 키의 유니코드 문자 값 리턴
- Unicode 문자 키인 경우에만 의미 있음
- 입력된 키를 판별하기 위해 문자 값과 비교하면 됨
#### int KeyEventgetKeyCode()
- 유니코드 키 포함
- 모든 키에 대한 정수형 키 코드 리턴
- 입력된 키를 판별하기 위해 가상키 값과 비교하여야 함
- 가상 키 값은 ㅏeyEvent 키의 상수로 선언

### 가상 키(Virtual Key)
#### 가상 키는 keyEvent 클래스에 상수로 선언
#### 가상 키의 일부 소개
- ***p372*** 참고

### 예제 9-6 KeyListener 활용 - 입력된 문자 키 판별
```java package java2;

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
            switch (e.getKeyChar()) { // 입력된 키 문자
                case '\n': // <Enter> 키 입력
                    la.setText("r=" +r+ ", g="+ g + ", b="+b);
                    getContentPane().setBackground(new Color(r, g, b));

                    break;
                    case 'q' : System.exit(0); 
            }
        }
    }
    public static void main(String[] args) {
        new KeycharEx();
    }
    
}
```

### Mouse 이벤트와 MouseListener, MouseMotionListener
### 마우스 리스너 달기와 MouseEvent 객체 활용
#### 마우스 리스너 달기
##### pg 376 의 표 9-6의 처음 5가지 경우 발생하는 Mouse 이벤트를 처리하고자 한다면, Mouse 리스너를 작성하여 컴포넌트에 다음과 같이 등록한다.
    compoenet,addMouseListener(MouseListener);
 ##### 컴포넌트가 마우스 무브나 마우스 드레깅을 함께 처리하고자 하면, Mouse 리스너 따로 등록

        component.addMouseMotionListener(myMouseMotionListener);

### 9-7 예제 해보기
## 해야할 일 : 교수님 강의시간에 한 챕터씩 나가고 미리 코드 쳐보고 정리해보기

## 2024-05-17 11주차
#### 컨테이너와 배치, 배치관리자 개념
- Flowlayout 배치 관리자  
컴포넌트가 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치  
배치할 공강이 없으면 아래로 내려와서 반복한다.
- BorderLayout 배치 관리자  
컨테이너의 공간을 동,서, 남, 북, 중앙의 5개 영역에 컴포넌트 배치
- Gridlayout 배치 관리자
컨테이너를 프로그램에서 설정한 동일한 크기의 2차원 격자로 나눔  
컴포넌트는 삽입 순서대로 좌에서, 우로 다시 위에서 배치 된다.
- cardLayout 관리자

## 컨테이너와 디폴트 배치 관리자
컨테이너 생성시 자동으로 생성되는 배치 관리자

## 컨테이너에 새로운 배치 관리자 설정, setLayout()메소드
setLayout(LayoutManager lm)메소드 호출  
Im을 새로운 배치 관리자로 설정

사례

## FlowLayout 배치 관리자
- 배치 방법 

## Flowlayout의 생성자
FlowLayout()  
FlowLayout(int align, int Gap, int VGap)
설명

### 예제 코드
의문이 들면 주석처리 해보기 주석처리 : //  
주석까지 같이 써보면서 이해하기

## BorderLayout 배치 관리자
배치 방법
- 컨테이너 공강을 5구역으로 분할, 배치 (동,서, 남, 북)

## GridLayout 배치 관리자

## GridLayout 생성자
생성자
- Gridlayout()
- GridLayout(int rows, int cols)
- GridLayout(int rows, int cols, int hGap, int vGap


## 배치 관리자없는 컨테이너
#### 배치 관리자가 없는 컨테이너가 필요한 경우
- 응용 프로그램에서 직접 컴포넌트의 크기의 위치를 결정하고자 하는 경우
    1. 

## 컴포넌트의 절대 위치와 크기 설정
#### 배치 관리자가 없는 컨테이너에 컴포넌트를 삽입할 떄
- 프로그램에서 컴포넌트의 절대 크기와 위치 설정
- 컴포넌트들이 서로 겹치게 할 수 있음.

#### 컴포넌트의 크기와 위치 설정 메소드
- void setSize(int width, int height) = width x height 크기로 설정
- void setLocation(int x, int y)  = 컴포넌트의 왼쪽 상단 모서리 좌표를 (x,y)로 설정
- void setBounds(int x, int y, int width, int height) = 크기와 위치 동시설정





## 2024-05-03 9주차
# 컬랙션과 제네릭  

## 컬렉션의 특징
### 컬렉션의 중요성과 개념
- 컬랙션 = 안드로이드를 비롯한 자바 프로그램을 작성하는 데 중요한 도구이다. ( 컬랙션은 제네릭이라는 기법으로 구현되어 있기 때문에 제네릭에 대한 공부도 필요)  
장점 : 배열은 여러 개의 데이터를 다루는 데 매우 편리한 자료 구조임   
단점 : 삽입 삭제가 빈번하고, 데이터의 크기를 예측할 수 없는 으용프로그램에 사용하기 불편(컬렉션은 고정 크기의 배열이 가지는 단점을 극복하고, 요소라고 불리는 객체들의 삽입, 삭제, 검색 기능을 갖춘 가변 크기의 컨테이너이다.)  

# 자바 GUI 스윙 기초
## 8.3 스윙 GUI 프로그램 만들기
1. import javax.swing.*;
2. import javax.swing.event.*;

- 스윙 프레임과 컨텐트팬
- 프레임 만들기, JFrame클래스
(생성자 알아보기)  
new Myframe(); 스윙 프로그램 생성  
setTitle("300X300 스윙 프레임 만들기") -프레임 타이틀 설정  
setSize-(300, 300);- 폭 300, 높이 300 크기로 프레임 크기 설정
setVisible(true)- 프레임이 화면에 나타나도록 지시. false의 경우 프레임이 숨겨짐  
- 프레임에 컴포넌트 붙이기
## 4월 19일 (7주차)
메소드 오버라이딩  
서브 클래스에서 슈퍼클래스에 선언된 메소드를 중복 작성하여 슈퍼클래스에 작성된 메소드를 무력화 시키고, 객체의 주인 노릇을 하는 것이다.(쉽게 말해 덮어쓰기) 

단 서브클래스에 오버라이딩한 메소드는 반드시 슈퍼 클래스에 작성된 메소드의 이름, 이턴 타입, 매개 변수 리스트가 모두 같도록 작성되어야 한다.  

동적 바인딩 : 서브 클래스에 오버라이딩되니 메소드가 무조건 실행되는 것  
오버라이딩의 목적 : '하나의 인터페이스(같은 이름)에 서로 다른 내용 구현'객체 지향의 다형성을 실현하는 도구 

super(정적 바인딩):동적 바인딩에 의해 항상 서브 클래스에 오버라이딩한 메소드가 호출되었지만 슈퍼클래스의 메소드를 호출 할 수 있는 접근 방법, 멤버에도 접근 가능  

*super로 슈퍼 클래스의 필드와 메소드 모두 접근 가능하다.  
오버로딩과 오버라이딩 비교
관계 : 동일한 클래스 내 혹은 상속 관계/ 상속관계  
바인딩 : 정적바인딩/동적바인딩  

추상 클래스 : abstract 키워드와 함께 원형만 선언되고, 코드는 작성되지 않는 메소드이다.  
추상클래스에는 추상 메소드가 선언된 클래스와 그 반대인 클래스로 나뉘어 진다.  
** 추상 메소드를 가지고 있으면 반드시 추상 클래스로 선언되어야 한다.  
** 추상 클래스의 인스턴스(객체)를 생성 할수없다.

추상 클래스의 목적  
상속을 위한 슈퍼클래스로 활용하기 위한 것  
메소드의 원형을 알려주는 인터페이스의 역할, 서브 클래스의 다형성을 실현  

인터페이스  
인터페이스는 5종류의 멤버로 구성된다.(* 필드(멤버 변수)를 만들수 없다.
)  
상수, 추상 메소드, default 메소드, private 메소드, static 메소드
상수 : public static final 속성이며, 속성은 생략가능
default 메소드 : (JAVA 8) 접근 지정은 public으로 고정  
private 메소드 : (JAVA 9) 인터페이스 내에 다른 메소드에서만 호출가능  
static 메소드 : (JAVA 9) 접근지정이 생략되면 public이며, private으로 지정가능  
인터페이스는 객체를 생성할 수 없다.  

## 6장 모듈과 패키지 개념, 자바 패키지 활용
패키지 : 파일들을 하나의 디렉터리에 모아 놓은 것.(확장자 : .jmod)  
모듈 : 여러 개의 패키지들을 모은 것  

import문 
java.util.Scanner처럼 긴 경로명을 사용하는 번거로움을 줄여줌  
* 선언 방법
1. import.패키지.클래스;
2. import 패키지.*;  

패키지 만드는 법  
ctrl + shift + p -> java create java project 클릭 -> no build tools -> 내가 사용할 workspace 폴더 선택 -> 프로젝트명 설정해주면 끝!  

모듈 :패키지들을 담는 컨테이너  

JAVA 모듈화의 목적  
자바 컴포넌트들을 필요에 따라 조립하여 사용하기 위함 = 가볍게 사용하기 위해서 (컴퓨터 시스템에 불필요한 부담을 줄인다.)  

JDK 주요 패키지  
- java.lang 
- java.util
- java.io  
- java.awt  
- javax.swing  

Object 클래스의 특징
Object는 java.lang 패키지에 속한 클래스이며, 모든 클래스는 강제로 Object를 받는다.(자바 클래스 계층 구조의 최상위 클래스)  

객체 속성  
hashCode(),toString() = 객체의 해시 코드 값 객체를 나타내는 문자열 정보를 제공
getName() = 객체의 클래스 명을 알아낼 수 있다.  

toString() 메소드 = 객체를 문자열로 변환  

객체 비교와 equal() 메소드  
두 객체가 같은지 비교하는 경우에 많이 사용(기본타임은 ==)

Wrapper 클래스 개념  
기본 타입의 값을 객체로 만들어 사용할 수 있도록 제공하는 클래스  

String의 생성과 특징
스트링 리터럴과 new String()으로 생성된 스트링은 서로 다르게 관리된다. 리터럴 테이블은 동일한 리터럴은 공유시키지만  new String에 의해 생성된 스트링은 힙 메모리에 별도로 생성한다.
(*스트링 객체는 수정이 불가)
Math class = 산술 연산을 수행하는 메소드

boxing과 unboxing  
기본타입의 값을 Wrapper 객체로 변환하는 것을 박싱 반대의 경우를 언박싱이라고 한다.  

시험 팁
-
for, if문 알기  
class 생성 방법(생성자)  
상속  
패키지  알기  
project 생성->git 초기화.commit  

오픈 북, 인터넷 검색 가능

## 4월 12일 (6주차)
클래스 접근 지정  
- 다른 클래스에서 사용하도록 접근 허용
- 디폴트 클래스(접근지정자 생략)  
static 멤버 선언  
- static 지시어로 선언된 멤버를 static 멤버라고 부른다.  
static 멤버는 클래스당 하나만 생성되는 멤버로서, 동일한 클래스의 모든 객체들이 공유하므로 클래스 멤버라고 부른다.  
static 메소드 조건 
- static 메소드는 객체가 생성되지 않은 상황에서도 사용이 가능하므로 객체에 속한 인스턴스 메소드, 변수등을 사용할 수 없고, static 멤버들만 사용가능.  
객체 지향 언어에서의 상속은 부모 유전자를 자식이 물려받는 유전적 상속과 비슷하다(ex:내 아들은 내 코를 닮았구나.)
------------------------------------------------------
서브 클래스 슈퍼 클래스 생성자  
슈퍼클래스에 여러 개의 생성자가 있을 수 있다.
서브 클래스의 개발자가 서브 클래스의 각 생성자에 대해, 함께 실행할 슈퍼 클래스의 생성자를 지정.  
슈퍼 클래스의 기본 생성자가 묵시적으로 선택  
업캐스팅 - 서브클래스 객체가 슈퍼클래스 타입으로 변환되는 것
다운캐스팅 - 슈퍼클래스 객체가 서브클래스 타입으로 변환되는 것
### 5장 상속


## 4월 5일 (5주차)
2차원 배열의 초기화  
메소드의 배열 리턴  
-배열의 래퍼런스만 리턴  
finally는 선택적 구문으로 생략가능  
자바의 예외 처리
- 오류 처리  
try-catch-finally

### 4장 클래스와 객체
상속 : 상위 개체의 속성이 하위 개체에 물려져서, 하위 개체가 상위 개체의 속성을 모두 가는 관계  
확장 = 자식클래스가 부모클래스의 속성을 몰려받는 기능  
다형성 = 같은 이름의 메소드가 클래스 혹은 객체에 따라 다르게 구현  
절차 대로 프로그래밍 하는 것 = 절차 지향 프로그래밍  
객체 : 클래스의 틀로 찍어낸 실체 = 인스턴스라고도 부름
클래스에 대한 public 접근 지정 : 다른 모든 클래스에서 클래스 사용  
캡슐화 = 객체를 캡슐로 싸서 그 내부를 보호하고 볼수 없게 하는 것  
필드와 메소드 모두 클래스 내에 모두 구현됨  
생성자 = 객체가 생성될 때 초기화를 위해 실행되는 메소드(클래스의 이름과 동일)  
기본 생성자 : 아무 일도 하지 않고 단순 리턴하는 생성자 = 디폴트 생성자  
this() : 클래스 내에서 생성자가 다른 생성자를 호출할 때 사용하는 자바 코드  
객체 배열 : 객체에 대한 레퍼런스를 원소로 갖는 배열  
배열 선언 및 생성  
1. 배열에 대한 래퍼런스 선언
2. 래퍼런스 배열 생성  
3. 객체 생성  


맴버에 대한 public 접근 지정: 다른 모든 클래스에게 멤버 접근 허용  
this 레퍼런스 : 객체 자신에 대한 레퍼런스
## 3월 29일
실수 타입 리터럴은 double 타입으로 컴파일  
\u00 - 뒤에 00에 오는 문자는 유니코드를 뜻한다.  
\n = 라인 피드, \r = 캐리지 리턴  
null 리터럴 = 기본타입에 사용 불가 String str = null; 처럼 사용가능
스트링 리터럴 = String = str = "Good";  
상수란?  
실행중 값 변경 불가 
 상수 선언은 전부 대문자로 작성

var = 타입을 생략하고 변수 선언 가능, 지역 변수 선언에만 한정  
자바의 키 입력 : System.in  
Scanner클래스(System.in)=Scanner클래스를 사용해 입력을 받는 방법  
증감연산자를 설명 할수 있다.(++a,a++)  
비교연산자, 논리연산자, 삼항연산자, 비트연산(AND,OR,XOR,NOT)  
swich문은 break를 만나기 전까지 계속 실행됨  

### 3장(반복문과 배열 그리고 예외 처리)
do-while문-조건식이 참인 동안 계속 반복  
break문-하나의 반복문을 즉시 벗어날 때 사용하며 아래와 같이 그 자체가 하나의 문장이다.  
for-each 문-배열이나 나열의 원소를 순차 접근하는데 유용한 for문  
1차원 배열을 잘 이해 할것

## 3월 22일 
ctrl + shift + p = >를 나오게 하는 명령어  
java 프로젝트 파일 만드는 방법 >java create java project -> no build tools -> working dir에 파일 생성  
복사해서 가져온 파일이 디버깅이 안되는 경우 조치방법  

(1) vs code 재부팅


(1) vs code 재부팅  
javac. 파일명.java : 생성한 파일로 들어가는 명령어  
java 파일명 : 파일에 있는 데이터를 보여줌  
*팁 dir을 입력하면 파일 리스트를 볼수 있다., java는 대소문자 구별을 한다.  
교재 수업 진행 방식  
- 1~3장은 빠르게
### 1장
고급 언어 - java, C, C## 보통 우리가 배우는 언어들  
저급 언어 - 기계어(이진수로 구성된 언어), 어셈블리어(기계어)  
자바(초기 이름 : 오크)  
플랫폼 = 하드웨어 플랫폼 + 운영체제 플랫폼 
플랫폼 마다 실행 파일이 다르다.
WORA : 한번 작성된 코드는 모든 플랫폼에서 바로 실행되는 자바의 특징  
컴파일:  
컴파일러 : 내가 짠 코드를 실행하는 것
WORA를 가능하게 하는 자바의 특징  
바이트 코드  
JVM : 한가지 파일로 여러 플랫폼에서 사용할 수 있게 해주는 파일
JDK : 개발에 필요한 도구 포함
JRE : 개발자가 아닌 경우 JRE만 따로 다운 가능 (게임만 할 경우)  
jmods - java 모듈들이 모여있는 파일  
자바 API : JDK 에 포함된 클래스 라이브러리  
자바 패키지 : 서로 관련된 클래스들을 분류하여 묶어 놓은 것(계층 구조로 되어 있음)

실행 코드 배포  
#### 자바의 특징
- 패키지: 서로 관련 있는 여러 클래스를 패키지로 묶어 관리(ex:System.calss)  
- 멀티스레드 :  여러 스레드의 동시 수행 환경 지원
- 실시간 응용프로그램에 부적합 : 실행 도중 예측할 수 없는 가비지 컬랙션 실행 때문  
- 자바 프로그램은 안전 : 1. 타입 체크 엄격, 2.물리적 주소를 사용하는 포인터 개념 없음
- 프로그램 작성 쉬움 : 1. 포인터 개념이 없음, 2. 동적 메모리 반환하지 않음
- 실행 속도 개선을 위한 JIT 컴파일러 사용

### 2장
클래스 만들기
-public class 사용할 클래스명
주석 만들기 명령어 : ctrl + /  
메소드 호출 s = sum(i,10);    
자바의 기본 데이터 타입 : boolean, char(문자),byte short(정수형)  
String 클래스 문자열 표현  
문자열 연결시킬때는 +사용(문자열 사용)  
리터럴 : 015-0으로 시작하면 8진수 0x15 - 0x로 시작하면 16진수
)
## 3월 15일
Repository name : java-2-2-name
snackcase : _를 사용한 파일명 (ex: python_name)  

commit 할때 한글 명령어로 입력하기  
(파일 이름보고 쉽게 알아볼수 있는게 중요, 영어 명령어로 치는게 좋음)
최신본이 맨위 쪽에 올수 있게 작성하기  
git 명령어 자세히 더 알아보고 싶으면 https://git-scm.com/book/en/v2
접속  

## 3월 8일
# Markdown 문법
## 폰트 관련 태그

# h1
## h2
### h3
#### h4
##### h5
  일반 글씨는 그냥 작성  <br></br>
  안녕  
  *이텔릭체*  
  **굵게**  
  *** 이테리체 굵게 ***  


  ## 리스트 (list)  
  1. 첫번째  
  2. 두번째
  3. 세번째

* 첫번째


## 코드 블럭
## 링크
[구글 링크](https://google.com)  
[리스트](#리스트-list)  
![유럽](./유럽사진.jpg)
![절대경로](https://search.pstatic.net/common/?src=http%3A%2F%2Fcafefiles.naver.`net%2FMjAxODA5MjFfMTE3%2FMDAxNTM3NTI3MjU2MzAw.sLjqzjaU21hKiC47SGqlq1TF0wKTdWhX0fjq3VTfB74g.84eZJhNrawRExrrwOV-4-9oZtNpdRPZ46iFYYmgQVWog.JPEG.soakdma84%2FexternalFile.jpg&type=sc960_832)


Repository name : 하이픈을 사용한 파일명(ex:java-2-2-name)  
snackcase : _를 사용한 파일명 (ex: python_name)  

commit 할때 한글 명령어로 입력하기  
(파일 이름보고 쉽게 알아볼수 있는게 중요, 영어 명령어로 치는게 좋음)
최신본이 맨위 쪽에 올수 있게 작성하기  
git 명령어 자세히 더 알아보고 싶으면 https://git-scm.com/book/en/v2
접속  
오늘 할 작업이 모두 끝났으면 push 해주기
123


