#include <cs50.h>
#include <stdio.h>
#include <math.h>

int main(void)
{
    float money;

    // Validate user input
    do
    {
        money = get_float("Change owed: ");
    }
    while (money < 0);

    int intMoney = round(money * 100);

    int counter = 0;

    while (intMoney >= 25)
    {
        intMoney = intMoney - 25;
        counter++;
    }
    while (intMoney >= 10)
    {
        intMoney = intMoney - 10;
        counter++;
    }
    while (intMoney >= 5)
    {
        intMoney = intMoney - 5;
        counter++;
    }
    while (intMoney >= 1)
    {
        intMoney = intMoney - 1;
        counter++;
    }
    printf("%i\n", counter);
}
