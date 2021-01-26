#include<stdio.h>

void main() {
    int y;
    printf("Enter any Year : ");
    scanf("%d",&y);
    if((y%400 == 0)||(y%100 != 0 && y%4==0)){
        printf("%d is a Leap Year", y);
    } else {
        printf("%d is not a leap Year", y);
    }
}

Nesting

2020-02-29

Valid,
