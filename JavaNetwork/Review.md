test review



Linux + R -> 필답평가, 수행평가.

Android -> 필답평가, 수행평가.



# Linux

여러사람이 같이 사용하는 운영체제.

커널, 쉘 다양한 기능을 제공하는 OS

대형시스템에서 사용했는데 요즘에는 PC급에서도 사용이 가능하다.

대소문자 구분하는 시스템

몇몇개의 명령어들이 있다.

* ps : 현재 프로세스의 정보를 출력.
* jps : JVM 에 의해서 생성된 프로세스 정보를 출력.
* ls : 현재 디렉토리의 파일 목록을 출력.
  * ls -al (a: all, l: 자세한정보출력)
* cd : change directory => 디렉토리 경로 변경
* cp : copy => 복사
* mv : move -> 이동.
* cat : 파일의 내용을 출력할 때 사용.
* head, tail : 파일의 앞,뒤 부분을 출력할 때 사용.
* vi : vi editor 실행시키는 명령어
  * -> 명령모드, 입력모드
  * 입력모드로 진입할 때 : i(insert), a(append)
  * 명령모드에서 1줄을 복사할때 : yy
  * 명령모드에서 1줄을 삭제할때 : dd
* rm : 삭제
  * rm -rf : ( -r: 하위폴더까지 싹다 삭제, -f: force(강제로) )



여러개의 파일을 하나로 묶을때 사용.

* tar cvf : 묶을때
* tar xvf : 풀때



로그인한 사용자가 누구인지 확인? 

* whoami

---

Linux 시스템에서 물리적인 장치 (CDROM, USB)를 파일시스템과 연동시키는 과정이 필요하다. => mount

Linux 에서 크기가 0인 파일을 만들려면 어떻게 해야 하나? => touch 명령이용.

Linux는 특이하게 파일에 대한 권한을 부여할 수 있다.  => chmod : 파일의 permission을 부여하여 특정 사람이나 그룹에게 파일 사용권한을 부여하거나 박탈할 수 있다. 

Linux 시스템의 파일은 inode 라는 자료구조를 이용하여 파일에 대한 정보를 담고 있다.

Linux도 많은 package들이 필요하다. 이런 package들을 설치하거나 삭제할 때 의존성 문제가 발생한다. => 이 문제가 너무 복잡하다. => 사람들이 package 사용에 문제가 많았음. 쉽게 하기 위한 가장 일반적인 Tool : yum

---

# R

* 데이터타입 : numeric, logical, character(문자열), complex

* 자료구조

  * vector : 1차원 선형 자료구조 - 같은 데이터 타입만 사용가능. 값 1개짜리 vector : scalar
  * matrix : 2차원 자료구조 - 같은 데이터 타입만 사용가능
  * array : 3차원 이상의 자료구조
  * list : 1차원 선형구조. 다른 데이터 타입도 사용가능.
  * data frame : 2차원 테이블 구조. 다른 데이터 타입도 사용가능.

* 패키지 사용

  * install.packages("") : 사용할 패키지를 설치.
  * remove.packages("") : 패키지 제거.
  * 가장 중요한 package
    * 문자열 처리 : stringr
    * 데이터 프레임 처리 : dplyr
    * 한글형태소 분석 : koNLP
    * 워드클라우드 : wordcloud

* EDA (탐색적 데이터 분석)

  



# Android

* 기본 컴포넌트
  * Activity : 화면 UI 담당 .
    * 화면에 UI 를 표현할 때 크게 두가지 방식
      * 자바코드로 구성. (추천하지 않음)
      * xml 을 이용하여 화면을 구성. (layout 폴더에 저장)
    * Activity 수행될 때 상태 전이 그에 따른 callback method.
      * onCreate() : Activity 가 처음에 생성
      * onStart() : Activity 가 생성된 후 바로 호출
      * onResume() : Activity 가 우리눈에 보일때 호출.
      * onPause() : Activity 의 화면 일부가 다른 Activity에 의해서 가려질때
      * onStop() : Activity 가 화면에서 완전히 안보이게 될때.
      * onDestroy() : Activity 가 종료될 때.
    * xml 속성
      * width, heigth, orientation, text, id, ...... 각 속성의 하는 일을 알아두어야 한다.
    * ID를 이용해서 widget(View)를 찾는 매서드 : findViewById(R.id.xxxxxx)
    * Intent : 하나의 컴포넌트에서 다른 컴포넌트를 호출하기 위해 사용되는 컴포넌트.
      * 데이터를 추가해서 다른 component에 전달할 수 있다. => putExtra()를 이용.
  * Service : 백그라운드에서 로직처리 담당.
    * Activity 에서는 화면처리만 하고 로직처리는 일반적으로 Service에서 한다.
    * ANR (Application Not Responding) 현상을 방지하기 위함.
    * Thread 를 이용한 로직처리를 하게 되는데 Thread와 Activity 간의 데이터 통신을 하기 위해서 Handler를 이용하여 처리.
  * Broadcast Receiver : 시스템에서 나오는 여러 signal 신호를 받아서 처리.
  * Content Provider : 다른 App과 데이터를 공유하기 위해서 사용.
* 우리 App의 모든 정보를 가지고 있는 xml 파일 : `AndroidManifest.xml`
* Listview 는 adapter 를 이용해야 Listview에 내가 원하는 데이터를 출력할 수 있다.
  * 이때 사용하는 adapter 는 BaseAdapter를 상속받아서 사용.
  * => Book Search App 만들때 사용.
* 보안설정
  1. AndroidManifest.xml 파일에 <uses-permission~~>을 이용하여 1차 보안처리.
     * 웹(인터넷)을 사용하기 위한 보안 : INTERNET 이라는 보안을 사용.
  2. 조금 더 필요한 보안은 사용자에게 직접 물어서 보안 해제. 







---

수행평가 : 금요일 까지

R : 로튼토마토 구현 내용 -> 워드파일로 작성. 소스코드, 실행된 결과 화면을 캡쳐해서 붙여넣기.

안드로이드 : 워드 파일로 작성. 도서검색프로그램 소스코드 + 실행된 결과 화면을 캡쳐하여 추가.



