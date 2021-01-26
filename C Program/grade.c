/*70-80 (n>=70 && n<=80) ==>
user==> mark
80-100 ==>A
60-79 ==> B
40-59 ==> C
0-39 ==> Fail
100+, 0- ==> invalid
*/

#include<stdio.h>
void main() {
    int m;
    printf("Enter your percentage : ");
    scanf("%d",&m);
    if(m>=80 && m<=100) {
        printf("Grade A!");
    }
    else if(m>=60 && m<80) {
        printf("Grade B!");
    }
    else if(m>=40 && m<60) {
        printf("Grade C!");
    }
    else if(m>=0 && m<40) {
        printf("FAIL!");
    }
    else {
        printf("Invalid Percentage!");
    }
}



// leap ==> 4

1700
1996
1997
400 800 1200 1600 2000 2400
(y%400 == 0)||(y%100 != 0 && y%4==0)
2016 2020 2024


if(n%2 == 0) {

}





