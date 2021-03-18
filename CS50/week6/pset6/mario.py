
def main():
    height = int(input("Height: "))

    for i in range(height):
        spaces = height - i;
        for j in range(spaces):
            print(' ', end = '')
        for j in range(i):
            print("#", end='')
        print(' ', end = '')
        for j in range(i):
            print("#", end='')
        print()


if __name__ == "__main__":
    main()
