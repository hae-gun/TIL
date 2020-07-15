#include<stdio.h>

// 전체 시험장수
int roomCount;
// 시험장당 사람수
int peopleByRoom;
// 주감독 감독가능인원, 부감독 감독가능인원.
int MainCan, SubCan;
// 주감독수, 각방부감독수.
int MainPro, SubProbyRoom;
// 모든감독수
int sumPro;


/*int main() {

	scanf_s("%d", &roomCount);

	scanf_s("%d", &peopleByRoom);

	scanf_s("%d %d", &MainCan, &SubCan);


	MainPro = roomCount;
	if (peopleByRoom - MainCan != 0) {
		SubProbyRoom = (peopleByRoom - MainCan) / SubCan + 1;

		sumPro = MainPro + (SubProbyRoom * roomCount);

	}
	else {
		sumPro = MainPro;
	}

	printf("%d", sumPro);
	return 0;
}*/