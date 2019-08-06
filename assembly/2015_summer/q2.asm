DSEG SEGMENT;data
    BLOCK DB 10h dup(?)
DSEG ENDS       

SSEG SEGMENT STACK
     DB 100H DUP(?)
SSEG ENDS

CSEG SEGMENT
     ASSUME: CS:CSEG, DS:DSEG, SS:SSEG
BEGIN:
    mov al,11000001b
    
    call CHACK_AL
    
    
    

    
    MOV AH,4CH
    INT 21H
    
    
    CHACK_AL:
    mov cx,4
    again:
    ror al,1
    jc one      ;if bit is 1 jump to check if next is 1 else bit is 0
    ror al,1
    jc notEQ    ;if bit is 1 jump out, the pair is 10
    jmp next    ;jump to next pair
    one:        ;bit is 1
    ror al,1    ;check second bit
    jnc notEq   ;if bit is not 1 jump out 
    next:
    loop again
    mov cx,1
    jmp done
    notEq:
    mov cx,0
    done:
    ret

    
CSEG ENDS
END BEGIN