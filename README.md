# 202130103 김민서
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

#### 2024-05-03 9주차
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


