package javanetwork;

/*
 * network : 유선, 무선을 이용해서 데이터 통신을 하기 위해 컴퓨터를 논리적, 물리적으로 묶어놓은 형태.
 * 
 * network 의 형태 - 크기에 따라서 여러가지 형태로 구분.
 * 1. `LAN(Local Area Network)` : 우리나라에서 주로 사용.
 * 2. `WAN(Wide Area Network)`
 * 3. `MAN(Metropolitan Area Network)` : 대도시
 * 
 * Internet : Network of Network
 * 			    물리적인 네트워크의 형태
 * Internet을 사용하기 위해서는 그 위에서 동작하는 Service가 있어야 한다.
 * 가장 대표적인 서비스 : Web, Email, Torrent, Streaming ....
 * 
 * Internet 위에서 각각의 서비스가 동작하려면 각 컴퓨터들이 서로를 인지할 수 있는 수단이 필요하다.
 * 각 컴퓨터마다 주소를 부여할 필요가 있다.
 * 정확하게 컴퓨터가 아니라 컴퓨터 부품중 NIC(Network Interface Card) 일반적으로 LAN 카드라 불린다.
 * 이 LAN 카드에 IP Address를 부여.
 * IPv4 => xxx.xxx.xxx.xxx(32bit) 초장기에 사용함.(아직까지도 사용중) 초기에는 문제없이 사용함.
 * 	시간이 지나면서 점점 주소가 모자라게 되었다. => IPv6 (128bit) 로 확장.
 * 
 * IP Address => LAN 카드에 부여된 논리적인 주소. 
 * 하지만 논리적인 주소만으로는 당연히 컴퓨터간의 통신을 할 수 없다.
 * 이 물리적인 주소가 있어야 통신을 할 수 있다.
 * 물리적인 주소 : MAC Address
 * => IP Address를 이용해서 특정 컴퓨터를 찾을 수 있다.
 * => IP Address는 숫자라서 기억하기 쉽지 않다 =>DNS(Domain Name Server)도입 =>www.naver.com
 * 
 * IP Address를 알아야 통신하고자 하는 상대방 컴퓨터를 인지할 수 있다.
 * 통신을 하려면 => Protocol 이 필요하다.
 * TCP, IP, ARP, TELNET, FTP, .... HTTP
 * 
 * Port 개념.: 숫자 0~65535 범위를 가지는 숫자 0~1023 번 까지는 예약되어 있다. 
 * 컴퓨터 내에 동작하고 있는 프로그램을 지칭하는 숫자이다.
 * 
 * 결론적으로 한 컴퓨터와 다른 컴퓨터가 데이터를 주고 받으려면!
 * 1. `protocol` 을 알아야 한다.
 * 2. `IP Address`를 알아야 한다.
 * 3. 특정 프로그램의 `Port` 번호를 알아야 한다.
 * 
 *  네트워크 프로그램이 너무 어렵다.
 *  Socket 이라는 개념을 만들어냄 (버클리대학)
 *  Socket을 만들면 복잡한 네트워크 처리를 Socket이 대신 알아서 처리하도록 만듬.
 *  
 *  Java Network 프로그램은 CS 구조를 갖는다 (Client Server 구조.)
 * 
 * */




public class Exam00_JavaNetwork {

	
}
