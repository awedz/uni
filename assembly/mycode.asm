SIZE EQU 8;ARRSIZE
DSEG SEGMENT;data
     BLOCKA DB SIZE dup(?)
     BLOCKB DB SIZE dup(?)
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
    
    LEA SI,BLOCKA
    MOV AL,40h
    call MoveToMem
    
    LEA SI,BLOCKB
    MOV AL,50h
    call MoveToMem
    
    MOV AH,4CH
    INT 21H
    
    MoveToMem:
    MOV CX,SIZE
    again:
    MOV [SI],AL
    INC SI
    loop again
    RET
CSEG ENDS
END BEGIN