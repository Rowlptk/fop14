#include<stdio.h>

void main() {
    int num[5];
    int max;
    printf("Enter 5 array values : \n");
    for(int i=0;i<5;i++) {
        scanf("%d",&num[i]);
    }
    printf("Values of array : ");
    for(int i=0;i<5;i++) {
        printf("%d ",num[i]);
    }

    max = num[0];
    for(int i=1;i<5;i++) {
        if(max<num[i]) {
           max = num[i];
        }
    }
    printf("\nMax Value : %d", max);
}
