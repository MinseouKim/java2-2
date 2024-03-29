# 김민서 202130103
<<<<<<< HEAD
=======
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

>>>>>>> a6c57e3 (3/29 4주차)

## 3월 22일 
ctrl + shift + p = >를 나오게 하는 명령어  
java 프로젝트 파일 만드는 방법 >java create java project -> no build tools -> working dir에 파일 생성  
복사해서 가져온 파일이 디버깅이 안되는 경우 조치방법  
<<<<<<< HEAD
(1) vs code 재부팅


=======
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
>>>>>>> a6c57e3 (3/29 4주차)
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
