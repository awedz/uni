DSEG SEGMENT;data
    BLOCK1 DB 10h dub(1)
    BLOCK2 DB 10h dup(?)
DSEG ENDS       

SSEG SEGMENT STACK
     DB 100H DUP(?)
SSEG ENDS

CSEG SEGMENT
     ASSUME: CS:CSEG, DS:DSEG, SS:SSEG
BEGIN:
    MOV AX,DSEG
    MOV DS,AX
    MOV ES,AX
    
    LEA SI,BLOCK1 
    LEA DI,BLOCK2
    MOV CX,10h
    CLD
    
    again:
    mov al,[si]
    mov [di],al
    inc di
    inc si
    loop again
    
    
    
    
    
    ;REP MOVSB
    
    MOV AH,4CH
    INT 21H
    
CSEG ENDS
END BEGIN