import sys
from cs50 import get_int

def main():
    while True:
        number = get_int("Number: ")
        if number >= 0:
            break

    if (len(str(number)) < 13 or 16 < len(str(number))) and (luhn_checksum(number) != 0):
        print("INVALID")
        sys.exit(0)
    else:
        number = str(number)
        which_operator(number)


def luhn_checksum(number):

    def digits_of(n):
        return [int(d) for d in str(n)]

    digits = digits_of(number)
    odd_digits = digits[-1::-2]
    even_digits = digits[-2::-2]
    checksum = 0
    checksum += sum(odd_digits)
    for d in even_digits:
        checksum += sum(digits_of(d*2))
    return checksum % 10

def which_operator(number):
    if number[0:2] in ["34", "37"]:
        print("AMEX")
    elif number[0:2] in ["51", '52', '53', '54', '55']:
        print("MASTERCARD")
    elif number[0:1] in ["4"]:
        print("VISA")

if __name__ == "__main__":
    main()
