

def convert_string_to_list(input_string):
    # Split the input string into lines
    lines = input_string.strip().split('\n')
    
    # Initialize an empty list to store the result
    result = []
    
    # Iterate over each line
    for line in lines:
        # Initialize an empty list for the current line
        current_line = []
        
        # Iterate over each character in the line
        for char in line.strip():
            if char == '.':
                current_line.append(-1)
            else:
                current_line.append(int(char))
            #current_line.append(',')
        
        # Append the current line to the result list
        result.append(current_line)
    
    return result

def print_single(input):
    test = str(input)
    test = test.replace('],', ']')
    test = test[1:-1]
    print(test)
    
def print_list(input):
    for game in input:
        print_single(convert_string_to_list(game))

## generate test case from https://qqwing.com/generate.html and paste here.
## it will print the values into format required for input

listOfInput = [
        """.71....8.
        ..4.2....
        5.....3..
        2.36.....
        468..1.7.
        .5.......
        ..6.....5
        8..7.2.16
        ....3..4.""",
        
        """9..8.....
        .3729.1..
        ..4..7.6.
        ....2....
        14.6..39.
        ...1.....
        4......87
        ..8.6....
        7.2....19""",
        
        """5....893.
        ..64..5.1
        ....5..4.
        ...5.....
        7..63....
        ....7....
        37....86.
        9.....4.5
        ..8.1...9""",
        
        """4...76.9.
        3.6.5..7.
        7..3..48.
        ..9..3...
        ...847..9
        .5......1
        .37....6.
        ..1......
        ........4""",
        
        """8....2..5
        ....7....
        .965...87
        ..12.9..6
        .....7.5.
        ..4..18..
        ..8......
        ......1..
        5...6.9.2""",
        
        """2....9.6.
        5.67.....
        19..5..82
        ........5
        8...91...
        ...625...
        .........
        68...7.9.
        4.2.6...7""",
        
        """.9...65.3
        .......76
        ..4......
        .6...3.4.
        ..25....8
        ...96.3..
        ..8......
        ......75.
        327...6.4""",
        
        """......53.
        .4.5.....
        ..7.....6
        6...5..7.
        25..6.19.
        3.1.9....
        73..1.9..
        ...9.....
        1..7...54""",
        
        """3..2...68
        .8.......
        2.5...4..
        7........
        ...518...
        .13..7...
        5.8..2...
        .6...4.7.
        17..3.58.""",
        
        """8........
        9...7...3
        15243....
        ....98.51
        .9.5..2.8
        4........
        ...7...2.
        5.....8..
        ..4...93."""
    ]

print_list(listOfInput)
