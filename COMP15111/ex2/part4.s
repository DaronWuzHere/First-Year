; Age History

	B  main

born	DEFB "you were born in \0"
were	DEFB "you were \0"
in	DEFB " in \0"
are	DEFB "you are \0"
this	DEFB " this year\n\0"
	ALIGN

	; int present = 2005
	; int birth = 1959
	; int year
	; int age = 1

present DEFW 2005
birth   DEFW 1999
age     DEFW 1
year    DEFW 0


main
	; this code does System.out.println("you were born in " + birth);
	ADR R0, born
	SVC 3
	LDR R0, birth ; make sure this will work!
        
	SVC 4
	MOV R0, #10
	SVC 0
        
        LDR R0, birth
        ADD R0, R0, #1
        STR R0, year
	; year = birth + 1

loop    LDR R1, present
        CMP R1, R0
        BEQ skip
        
	; while (year != present) 

	; this code does System.out.println("you were " + age + " in " + year);
	ADR R0, were
	SVC 3
	LDR R0, age ; make sure this will work!
	SVC 4
	ADR R0, in
	SVC 3
	LDR R0, year ; make sure this will work!
	SVC 4
	MOV R0, #10
	SVC 0
        
        LDR R0, age
        ADD R0, R0, #1
        STR R0, age
        LDR R1, year
        ADD R1, R1, #1
        STR R1, year

        LDR R2, present
        CMP R2, R1
        BNE loop

	;   year = year + 1;
	;   age = age + 1;
	; }

	; this code does System.out.println("you are " + age + "this year");
	ADR R0, are
	SVC 3
	LDR R0, age ; make sure this will work!
	SVC 4
	ADR R0, this
	SVC 3
skip
	SVC 2 ; stop
