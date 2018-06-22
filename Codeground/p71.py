'''
You should use the statndard input/output

in order to receive a score properly.

Do not use file input and output

Please be very careful.
'''

import sys

'''
	The method below means that the program will read from input.txt, instead of standard(keyboard) input.
	To test your program, you may save input data in input.txt file,
	and call below method to read from the file when using open() method.
	You may remove the comment symbols(#) in the below statement and use it.
	But before submission, you must remove the open function or rewrite comment symbols(#).
'''

# inf = open('input.txt');
inf = sys.stdin

T = inf.readline()

for t in range(0, int(T)):
    Answer = 0

    flt = False
    arr = []
    N = inf.readline()

    for n in range(0,int(N)):
        arr.append(int(inf.readline()))
    #############################################################################################
    #
    #  Implement your algorithm here.
    #  The answer to the case will be stored in variable Answer.
    #
    arr.sort()
    length = len(arr)
    for i in range(0,length):
        if flt:
            flt = False
            Answer = Answer - arr[i]
        else:
            flt = True
            Answer = Answer + arr[i]
    #############################################################################################

    # Print the answer to standard output(screen).
    print('Case #%d' % (int(t) + 1))
    print(Answer)
inf.close()
