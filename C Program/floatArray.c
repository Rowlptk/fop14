#include<stdio.h>

void main() {
    float num[6] = {10.1, 12.3, 0.99, 3.01, 7.8, -1.6};
    float sum = 0;

    printf("Values of array : ");
    for(int i=0;i<6;i++) {
        printf("%.2f ",num[i]);
    }

    for(int i=0;i<6;i++) {
        sum = sum + num[i];
    }
    printf("\nSum = %.2f",sum);
    printf("\nAvg = %.2f",sum/6);


}
