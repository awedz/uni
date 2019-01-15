#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include<conio.h>

void RemoveVow(char string[]);
int IsChar(char *toCheck);

void main()
{
	char string[] = "Boaz is a papuaz";
	RemoveVow(string);
	printf("%s\n", string);
	_getch();
}
void RemoveVow(char string[])
{
	int size = strlen(string),l=0;
	for (int i = 0; i < size; i++)
		if (!IsChar(string + i))
		{
			if (i == size - 1)
				*(string + l+1) = '\0';
			*(string + l) = *(string + i); 
			l++;
		}
}
int IsChar(char *toCheck)
{
	switch (*(toCheck)) 
	{
	case 'a':
	case 'A':
	case 'e':
	case 'E':
	case 'i':
	case 'I':
	case 'o':
	case 'O':
	case 'u':
	case 'U':
		return 1;
	default:
		return 0;
	}
}