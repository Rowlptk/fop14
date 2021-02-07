#include<stdio.h>

void main() {
    //int ary[5] = {23,6,-9,0,100};
    //printf("%d\n",ary[1]);
    //ary[1] = 33;
    //printf("%d\n",ary[1]);
    int ary[5];
    printf("Enter 5 values : \n");
    for(int i =0; i<5; i++) {
        printf("ary[%d] = ",i);
        scanf("%d",&ary[i]);
    }
    printf("\nArray Values are : \n");
    for(int i=0;i<5;i++) {
        printf("Value %d = ",i+1);
        printf("%d\n",ary[i]);
    }

    printf("\nEven Numbers : ");
    for(int i=0;i<5;i++) {
        if(ary[i]%2 == 0) {
            printf(" %d",ary[i]);
        }
    }

    printf("\nOdd Numbers : ");
    for(int i=0;i<5;i++) {
        if(ary[i]%2 == 1) {
            printf(" %d",ary[i]);
        }
    }
}







