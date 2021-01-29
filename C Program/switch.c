#include<stdio.h>

void main() {
    int n;
    printf("Enter n:");
    scanf("%d",&n);
    switch(n){

    case 1:
        printf("Sunday!");
        break;
    case 2:
        printf("Monday!");
        break;
    case 3:
        printf("Tuesday!");
        break;
    case 4:
        printf("Wednesday!");
        break;
    case 5:
        printf("Thursday!");
        break;
    default:
        printf("Holiday!");

    }

}


