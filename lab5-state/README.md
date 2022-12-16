Challenge: Write software using a state design pattern that validates if an input statement (string) satisfies the gramma:

    G = <	
        { a, b, c },
        { Start, A, B, C },
        
        {
            Start   ->  aA | bC,
            A       ->  aA | bB | ε,
            B       ->  bB | a | ε,
            C       ->  cB | aC | ε
        }        

        Start 
        >


### How to check if words satisfy gramma?

Run **AppMain** and pass words as program arguments.

Example output:

    =========================
    Checking word 'abcaaaaac'
    Result:			false
    States list:		[Start, A, B]
    Productions list:	[aA, bB]
    =========================
    Checking word 'abbbb'
    Result:			true
    States list:		[Start, A, B, B, B, B]
    Productions list:	[aA, bB, bB, bB, bB, ε]
    =========================
    Checking word 'bcba'
    Result:			true
    States list:		[Start, C, B, B, null]
    Productions list:	[bC, cB, bB, a]
    =========================
    Checking word 'd'
    Result:			false
    States list:		[Start]
    Productions list:	[]
    =========================
    Checking word 'a'
    Result:			true
    States list:		[Start, A]
    Productions list:	[aA, ε]