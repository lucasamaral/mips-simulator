#include <stdio.h>
int main(int argc, char const *argv[])
{
	int n = 10;
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

	return 0;
}
