#include<stdio.h>

void checkBalance();
void deposit(double amount);
void withdraw(double amount);
double readAccount();
void writeIntoAccount(double balance);
double readAmountFromUser();
void login();
void menu();
void proceed();

double mainBalance;

void main() {
    login();
}

void proceed() {
    char ch;
    printf("Press Y to continue...\n");
    scanf(" %c",&ch);
    if(ch == 'Y' || ch == 'y') {
        system("cls");
        menu();
    }
}

void menu() {
    int opt;
    printf("Press : \n1. Check Balance\n2. Withdraw\n3. Deposit\n4. Exit\n Select : ");
    scanf("%d",&opt);
    mainBalance = readAccount();
    switch(opt) {
    case 1:
        checkBalance();
        break;
    case 2:
        withdraw(readAmountFromUser());
        break;
    case 3:
         deposit(readAmountFromUser());
         break;
    case 4:
        exit(0);
    default:
        printf("\nInvalid Input\n");
    }
    proceed();
}

void login() {
    char sysUser[20] = "Admin";
    char sysPwd[20] = "pass";

    char usr[20], pwd[20];

    printf("Enter username : ");
    gets(usr);

    printf("Enter password : ");
    gets(pwd);

    if((strcmp(strlwr(sysUser), strlwr(usr)) == 0) &&(strcmp(sysPwd, pwd) == 0)) {
        printf("Login SuccessFull!");
        menu();
    } else {
        printf("username or password is incorrect!");
    }
}

double readAmountFromUser(){
    double amount;
    printf("Enter Amount : ");
    scanf("%lf",&amount);
    return amount;
}


void writeIntoAccount(double balance) {
    FILE *fp;
    fp = fopen("my_account.txt","w");
    fprintf(fp, "%lf", balance);
    fclose(fp);
}

double readAccount() {
    FILE *fp;
    double balance;
    fp = fopen("my_account.txt","r");
    if(fp == NULL) {
        printf("Internal Error!");
        exit(0);
    }
    fscanf(fp, "%lf", &balance);
    fclose(fp);
    return balance;
}


void withdraw(double amount) {
    mainBalance -= amount;
    writeIntoAccount(mainBalance);
    printf("\nAmount Deducted : $%.2lf\n",amount);
    checkBalance();
}

void deposit(double amount) {
    mainBalance += amount;
    writeIntoAccount(mainBalance);
    printf("\nAmount Deposited : $%.2lf\n",amount);
    checkBalance();
}

void checkBalance() {
    mainBalance = readAccount();
    printf("\nYour Available Balance : $%.2lf\n",mainBalance);
}


//login ==> menu
// deposit ==> limit
// withdraw ==>


