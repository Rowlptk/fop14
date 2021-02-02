#include<stdio.h>

void main() {
    int n, s, f;
    printf("Enter n: ");
    scanf("%d",&n);
    printf("Enter Start Point: ");
    scanf("%d",&s);
    printf("Enter Final Point: ");
    scanf("%d",&f);
    for(int i=s; i<=f; i++) {
        printf("%d x %d = %d\n",n,i,n*i);
    }
    getchar();getchar();
}

// generate multiple of 3 ==> 30 to 60
/*for(int i=30; i<=60; i++) {
    if(i%3 == 0) {
        printf("%d\n",i);
    }
}*/
// generate 1, 4, 9, 16, 25, 36, 49 64, 81, 100
for(int i = 1; i<=10; i++) {
    printf("%d\n", i*i);
}

// 1, 2, 9, 4, 25, 6, 49, 8, 81, 10

for(int i = 1; i<=10; i++) {
    if(i%2 == 1) {
        printf("%d\n", i*i);
    } else {
        printf("%d\n", i);
    }
}





