# 하둡 설정

* VMware 

  * WorkStation pro 로 설치
  * 설치후 새로운 Virtual Machine 생성

  ![image-20200520092515055](C:\Users\student\Desktop\Study\Study\md_img\image-20200520092515055.png)

  * 생성시 Customize Hardware 에서 메모리 용량만 증가시켜서 만들기.

    ![image-20200520092948956](C:\Users\student\Desktop\Study\Study\md_img\image-20200520092948956.png)

  

  * CentOS 설치

    * CentOS 7 ISO 이미지 파일을 받아 설치.
    * [사이트](http://mirror.kakao.com/centos/7.8.2003/isos/x86_64/)

    ![image-20200520101349023](../../Study/Study/md_img/image-20200520101349023.png)

    * 여기에 ISO 파일을 업로드

  * 언어설정 한후 

    ![image-20200520101645210](../../Study/Study/md_img/image-20200520101645210.png)

  * 네트워크 설정

    ![image-20200520101716890](../../Study/Study/md_img/image-20200520101716890.png)

    ![image-20200520101731542](../../Study/Study/md_img/image-20200520101731542.png)

  * 소프트웨어 설치

    ![image-20200520101806340](../../Study/Study/md_img/image-20200520101806340.png)

    ![image-20200520101857047](../../Study/Study/md_img/image-20200520101857047.png)

  * 파티션 설정

    ![image-20200520101944360](../../Study/Study/md_img/image-20200520101944360.png)

    ![image-20200520102012779](../../Study/Study/md_img/image-20200520102012779.png)

    ![image-20200520102056183](../../Study/Study/md_img/image-20200520102056183.png)

    ![image-20200520102129877](../../Study/Study/md_img/image-20200520102129877.png)

    ![image-20200520102219897](../../Study/Study/md_img/image-20200520102219897.png)

    ![image-20200520102309561](../../Study/Study/md_img/image-20200520102309561.png)

    ![image-20200520102352516](../../Study/Study/md_img/image-20200520102352516.png)

    ![image-20200520102543139](../../Study/Study/md_img/image-20200520102543139.png)

* 하둡 아키텍처 구조

  * Master Slave 구조
  * Hadoop 에서
    * Master : Namenode.
    * Slave : Datanode.
  * 실제 데이터는Datanode에 존재하고 Namenode 에는 어느 정보가 어디있는지 알수 있는 Metadata를 갖고 있다.
  * 실제 구조에서는 Secondary namenode를 갖고있다. (Namenode 분실 방지)
  * 보통 Secondary namenode는 Datanode중 한개가 겸하는 구조로 사용한다.

* `HDFS : Hadoop Distribye File System` 

  * 하둡 시스템을 사용하기 위해 API를 이용해 Master에게 요청한다.



* OS 설치후 clone을 이용하여 복사한다.
  * full clone으로 복사를 한다.



* 4대의 서버로 진행
  * `Hadoop01 : Namenode, host명 : namenode` 
  * `Hadoop02 : Datanode, host명 : datanode01` 
  * `Hadoop03 : Datanode, host명 : datanode02`
  * `Hadoop04 : Datanode, host명 : datanode03`
* 3가지 모드가 있음
  * standalone : 단일 노드. test용
  * pseudo distributed : 단일 Node에서 Cluster 구성
  * full distributed : 두 대 이상의 Node를 Cluster로 구성
* 사용하는 Hadoop 버전 : `2.9.2 버전`



## 준비

1. 각 서버마다 Java 를 다시설치하고 환경변수를 설정. 사용하는 Java버전은 8버전 이용.

   * 기존에 설치되어 있는 Java를 삭제

   * `rpm -qa | grep java` 로 버전 체크

     ![image-20200520111955450](../../Study/Study/md_img/image-20200520111955450.png)

   * `yum remove javapackage-~~~` 를 이용하여 삭제

2. 윈도우와 리눅스 폴더 마운트

   ![image-20200520112650969](../../Study/Study/md_img/image-20200520112650969.png)

   * 공유 권한을 줌
   * virtual machine에서 해당 virtual machine setting 들어가기
   * 아래와 같이 설정

   ![image-20200520112940284](../../Study/Study/md_img/image-20200520112940284.png)

   * 공유폴더는 /mnt 에서 보여짐.

   > 공유폴더 안될때
   >
   > 아래 커맨드 입력
   >
   > sudo mkdir /your_shared_folder(폴더명)
   >
   > sudo vmware-hgfsclient
   >
   > sudo vmhgfs-fuse /your_shared_folder

3. 자바설치

   * 받은 JDK를 압출을 풀어 /usr/local 로 압축해제
   * `tar zxvf jdk-8u251-linux-x64.tar.gz`

4. 환경설정

   * 자바, 하둡, classpath 설정
   * /etc/profile 설정파일에서 변경
     * `export JAVA_HOME=/usr/local/java`
     * `export HADOOP_HOME=/usr/local/hadoop`
     * `export CLASSPATH=$JAVA_HOME/lib:$CLASSPATH`
     * `export $PATH:$JAVA_HOME/bin:$HADOOP_HOME/bin:$HADOOP_HOME/sbin`

5. `source /etc/profile`로 환경변수 재설정

## SSH 설정

* 공개키와 개인키방식의 암호화를 이용한 통신
* 공갸키 : 암호화 할 때 사용하는 Key
* 공개키로는 복호화를 할 수 없다.
* 공개키느 나눠주는 키이고 개인키는 유출되면 안된다.
* 각각 Host 별로 공개키와 개인키를 갖고 있게 만든다.
* 공개키로 암호화된 데이터는 갖고있는 개인키로 복호화가 가능하다. 서로의 공개키를 주고 받아야 한다.



* 각자의 IP Address를 알아야 한다.

* 그후 `/etc/hosts` 파일을 편집.

  ![image-20200520145207482](../../Study/Study/md_img/image-20200520145207482.png)

  

* `/etc/hostname` 을 각각 자기 이름을 지정해서 저장

  ![image-20200520150539355](../../Study/Study/md_img/image-20200520150539355.png)

* `SSH`키를 각 서버마다 생성해서 모두 취합한 후 모든 서버에 배포한다.

  * 각각의 서버가 공개키와 개인키를 만든다.

  * `ssh-keygen`

    ![image-20200520151359279](../../Study/Study/md_img/image-20200520151359279.png)

  * 생성된 암호위치 `/root/.ssh`

    ![image-20200520151434996](../../Study/Study/md_img/image-20200520151434996.png)

  * `id_rsa : 개인키`,`id_rsa.pub : 공개키`

  * namenode(hadoop01)에서만 id_rsa.pub를 복사

    ```console
    cp id_rsa.pub authorized_keys
    ```

  * 각각 모두 ssh 를 해준 후 프로그램을 통해 공개키를 모음.

  * `ssh-copy-id root@namenode` 명령어를 통해 보내줌

    ![image-20200520152443921](../../Study/Study/md_img/image-20200520152443921.png)

  * 해당 줄 뜰시 root계정 암호 입력한후 설정.

  * 복사후 결과 authorized_keys 파일에 공개키가 모여짐.

    ![image-20200520152707317](../../Study/Study/md_img/image-20200520152707317.png)

  * 이제 나머지에게 전송

  * `scp -rp authorized_keys root@datanode01:~/.ssh/authorized_keys`

  * 똑같이 첫 접속이여서 해당 root의 암호를 입력

    ![image-20200520153141103](../../Study/Study/md_img/image-20200520153141103.png)

### 연결확인

* `date`명령어를 통해 확인.

  * 확인 할때 다른 컴퓨터가 동작하도록 설정해봄

  * `ssh datanode01 date`

    ![image-20200520153428231](../../Study/Study/md_img/image-20200520153428231.png)

  * 모든 datanode들이 각자가 각자에게 연결될수 있도록 연결해준다.

    ![image-20200520153834260](../../Study/Study/md_img/image-20200520153834260.png)





## Hadoop

* Apache의 최상위 프로젝트 중 하나로 대용량의 데이터를 저장하고 분석, 처리하기 위한 Framework
* Map reduce 를 이용. 이를 이용하기 위해 Hive와 연동
* 특징
  * 선형확장을 지원 : 데이터 사용의 증가를 보면서 추후에 용량증가가 굉장히 용이하다.
  * 분석처리에 사용 : Map/Reduce를 이용해서 대용량의 데이터 분석이 가능하다.
  * API 기반의 파일처리 시스템.
  * Immutable(불변의) 파일 시스템 : 파일이 한번 저장되면 변경이 되지 않는것을 가정하고 있다.
    * 하둡버전이 올라가면서 append, 삭제는 API를 통해서 가능
  * 하둡 시스템은 Master Slave 구조. : Master가 고장나면 시스템이 망가짐.



* 하둡은 각각의 서버가 특정 포트를 이용해서 SSH 통신을 하게된다.

* 이때 방화벽이 막혀있다면 통신이 불가능하다.

* 방화벽 해제를 해줘야 한다. 정확히 말하면 방화벽 포트를 열어줘야 하나 너무 복잡하여 그냥 열어서 사용하기로 함.

* 기본적으로 CentOS 설치시 방화벽이 켜져있다. 

* 아래의 커맨드로 방화벽 설정을 바꿔준다.

  ![image-20200520154138094](../../Study/Study/md_img/image-20200520154138094.png)

  1. 방화벽 중지.
  2. 재시작 시에도 방화벽 사용 안함.

  

