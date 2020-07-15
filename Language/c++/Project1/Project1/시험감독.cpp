#include<stdio.h>
#include <limits.h>
int n, b, c;
int p[1000000];



int main() {

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &p[i]);
	}

	scanf("%d %d", &b, &c);


	long long ret=0;
	for (int i = 0; i < n; i++) {
		p[i] -= b;
		++ret;
		if (p[i] > 0) {
			int candi = p[i] / c;
			if (p[i] % c != 0) {
				candi++;
			}
			ret += candi;
		}
	}
	printf("%lld\n", ret);

	for (int i = 0; i < 10; i++) {
		printf("%d\t", p[i]);
	}
	printf("\nlonglong 형 최대수 :%lld", LLONG_MAX);
	printf("\nlong 형 최대수 : %ld", LONG_MAX);
	printf("\nint 형 최대수 : %d", INT_MAX);

	return 0;
}