## Include code
``` #include <stdio.h>
#include <stdlib.h>
#include <wchar.h>
#define PASSWORD "ABCD1234!"
/*You need not worry about other include statements if at all any are missing */
```
Password hard coded!!!

## Function 1

```c
void func1()
{
    char * data;
    char * dataBuffer = (char *)ALLOCA(100*sizeof(char));
    memset(dataBuffer, 'A', 100-1);
    dataBuffer[100-1] = '\0';
    data = dataBuffer - 8;
    {
        char source[100];
        memset(source, 'C', 100-1); 
        source[100-1] = '\0'; 
        strcpy(data, source);
        if(data != NULL) 
        {
            printf("%s\n", data);
        }
    }
}
```
### Explanation
A function is loaded into stack, it has following structure
1st return address, then few registers(including pointer), then Local Variables, then code(think of assembly level instructions). data pointer and databuffer pointer will be in the stack as part of local variables. we pushed character 'A' and end of string into databuffer's address (which would be after local variables). Now, data is pointing to 8 byte address before dataBuffer (databuffer - 8). Since, data would be stored before databuffer, it should point to itself, assuming 64bit system, so pointer should be 8 bytes. 
In the inner block, we are overriding(strcpy function) the 100 bytes of information at data pointer, which can be all local variables(if it's 64 bit system) or few registers(including framepointer) if  32 bit system. 

Generally, an exploit happens, because, we can override the instruction with our malicious instructions and Pointer to execute our instructions. malicious instructions are generated with msfvenom.

## Function 2
```c
void func2()
{
    char * data;
    data = NULL;
    data = (char *)calloc(100, sizeof(char));
    strcpy(data, "A String");
    if(data != NULL) 
    {
        printf("%s\n", data);
    }
}
```
### Explanation 
This looks okay. "A String" is less than 100 characters. we can check for calloc's successful allocation. 

## Function 3
```c
void func3()
{
    char * password;
    char passwordBuffer[100] = "";
    password = passwordBuffer;
    strcpy(password, PASSWORD);
    {
        HANDLE pHandle;
        char * username = "User";
        char * domain = "Domain";
        /* Let's say LogonUserA is a custon authentication function*/
        if (LogonUserA(
                    username,
                    domain,
                    password,
                    &pHandle) != 0)
        {
            printf("User logged in successfully.\n");
            CloseHandle(pHandle);
        }
        else
        {
            printf("Unable to login.\n");
        }
    }
}
```
### Explanation 
if 'PASSWORD' is controlled by end user, it will lead to buffer overflow attack, Because password buffer size is 100. Also, end of string is not marked '\0', so Custom authentication function won't know where password string is ending. 
## Function 4
```c
static void func4()
{
    char * data;
    data = NULL;
    data = (char *)calloc(20, sizeof(char));
    if (data != NULL)
    {
        strcpy(data, "Initialize");
        if(data != NULL) 
        {
            printf("%s\n", data);
        }
        free(data);
    }
}
```
### Explanation 
"Initialize" with of end of string is 11 characters which should fit into calloc's 20 character space. This is okay.
## Function 5
```c
void func5() 
{
    int i = 0;
    do
    {
        printf("%d\n", i);
        i = (i + 1) % 256;
    } while(i >= 0);
}
```
### Explanation 
This is an infinite loop. value of i start at 0. In the loop, it go from 0 to 255 and then reset to 0. So, `i >= 0` never violates.
## Function 6
```c
void func6()
{
    char dataBuffer[100] = "";
    char * data = dataBuffer;
    printf("Please enter a string: ");
    if (fgets(data, 100, stdin) < 0)
    {
        printf("fgets failed!\n");
        exit(1);
    }
    if(data != NULL) 
    {
        printf("%s\n", data);
    }

}
```
### Explanation 
This is okay. fgets's input size and dataBuffer size is equal.
## Function 7
```c
void func7()
{
    char * data;
    data = "Fortify";
    data = NULL;
    printf("%s\n", data);
}
```
### Explanation 
Securiy wise okay but will lead issue as data is pointing to null.
## Main Function
```c
int main(int argc, char * argv[])
{
    printf("Calling func1\n");
    func1();

    printf("Calling func2\n");
    func2();

    printf("Calling func3\n");
    func3();

    printf("Calling func4\n");
    func4();

    printf("Calling func5\n");
    func5();

    printf("Calling func6\n");
    func6();

    printf("Calling func7\n");
    func7();

    return 0;
}
```