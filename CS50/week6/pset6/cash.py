from cs50 import get_float

def main():
    while True:
        amount = get_float("Change owed: ")
        if (amount > 0):
            break

    counter = 0

    for x in [0.25, 0.10, 0.05, 0.01]:
        while amount >= x:
            amount = round(amount - x, 2)
            counter += 1

    print(f"The minimum amount of coins is {counter}")

if __name__ == "__main__":
    main()
