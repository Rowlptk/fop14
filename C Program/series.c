// 0 1 1 2 3 5 8 13 21 34
/*
x = 0
y = 1
sum = x + y

x = y
y = sum
sum = x + y
*/

#include<stdio.h>

void main() {
    int x = 0, y = 1;
    int sum = x + y;
    printf("%d %d %d", x, y, sum);
    /*for(int i = 1; i<=7; i++) {
        x = y;
        y = sum;
        sum = x + y;
        printf(" %d", sum);
    }*/
    while(sum <= 50) {
        x = y;
        y = sum;
        sum = x + y;
        if(sum >= 50)
            continue;
        printf(" %d", sum);
    }

}

/*

prime number ==>  user ==> 13 ==> prime number
==> 15 ==> not a prime number



// generate prime number from 50 to 100;
*/






