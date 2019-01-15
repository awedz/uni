#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void RemoveChars(char str[]);
void PrintArr(char str[]);
int main()
{

	char str[] = "xxxabbbcdddcxxxyyz";

	PrintArr(str);
	RemoveChars(str);
	PrintArr(str);
	return 0;
}
void RemoveChars(char str[])
{
	int i, j, x, pos, cnt = 0, cCoun = 0, size = strlen(str);
	char temp, curr;

	for (i = 0;i< size; i++)
	{
		curr = str[i];
		cnt = 0;
		while (curr == str[cnt])
		{
			cnt++;
		}
		for (j = 0; j <= cnt; j++)
		{

			for (x = i; x < size; x++)
			{
				temp = str[j];
				str[j] = str[j + 1];
				str[j + 1] = temp;
				printf("%c", str[j]);
			}
		}
		printf("\n");
	}
}
void PrintArr(char str[])
{
	int i;
	for (i = 0; str[i]; i++)
	{
		printf("%c", str[i]);
	}
	printf("\n");
}
