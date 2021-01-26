#include<stdio.h>

void main() {
    int ary[6], max;

    printf("Enter array values : \n");
    for(int i = 0; i < 6; i++) {
        printf("ary[%d] = ",i);
        scanf("%d",&ary[i]);
    }

    printf("\nThe Even Numbers in Array are: \n");
    for(int i = 0; i < 6; i++) {
        if(ary[i]%2 == 0) {
            printf("%d ", ary[i]);
        }
    }

    printf("\nThe Odd Numbers in Array are: \n");
    for(int i = 0; i < 6; i++) {
        if(ary[i]%2 != 0) {
            printf("%d ", ary[i]);
        }
    }

    // max
    printf("\nThe Maximum Value is : ");
    max = ary[0];
    for(int i = 1; i < 6; i++) {
        if(max<ary[i]) {
           max = ary[i];
        }
    }
    printf(" %d", max);






}
