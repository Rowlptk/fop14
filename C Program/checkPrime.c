#include<stdio.h>

void main() {
    int n;
    int count;
    //printf("Enter any Number: ");
    //scanf("%d",&n);
    for(int n=1; n<=100; n++) {
        count = 0;
        for(int i=1; i<=n; i++) {
            if(n%i == 0) {
                count++;
            }
        }
        if(count == 2) {
            printf("%d\n",n);
        }
    }
    /*
    if(count == 2) {
        printf("%d is a prime number",n);
    } else {
        printf("%d is not a prime number",n);
    }*/
}
