/*float m[10] ===> _ _ _ _ _ _ _ _ _ _
                 0 1 2 3 4 5 6 7 8 9

char str[10] ==> A P P L E /0 _ _ _ _

printf("%s",str);*/
#include<stdio.h>
#include<string.h>
void main() {
    char str[10] = "Apple A";
    char str2[20];
    // String copy
    strcpy(str2, str);
    // length of str
    printf("The length of str = %d\n",strlen(str));
    // UpperCase permanent change
    strupr(str);
    // Lowercase permanent change
    strlwr(str2);
    // reverse permanent change
    strrev(str);
    // concatenation
    char first[10] = "Hello";
    char second[10] = "World";

    strcat(first, second);
    puts(first);
    puts(second);

    puts(str);
    printf("Str = %s",str);
    printf("\n%c\n", str[4]);
    puts(str2);
}








