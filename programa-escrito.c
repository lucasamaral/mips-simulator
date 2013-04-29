#include <stdio.h>
int main()
{
	int n = 5;
	int i = 1;
	int calc = 0;
	int val = 1;
	int prev = 0;
	do
	{
		calc = val + prev;
		prev = val;
		val = calc;
		i++;
	} while (i != n);
	printf("%d",val);
	return 0;
}
