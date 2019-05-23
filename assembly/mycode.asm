    CALL PRINT_1
    CALL PRINT_2
    MOV AH,4CH
    INT 21H
    
    PRINT_1:
    MOV AH,1
    INT 21H
    MOV CX,10
    MOV DL,AL
    CALL PRINT
    RET
    
    PRINT_2:
    MOV AH,1
    INT 21H
    CMP AL,1
    JZ EQ
    MOV DL,'*'
    MOV CX,15    
    JMP END     
    EQ:
    MOV DL,'#'
    MOV CX,8
    END:     
    CALL PRINT
    RET
    
    PRINT:
    MOV AH,2
    AGAIN:
    INT 21H
    LOOP AGAIN
    MOV DL,0Dh
    INT 21H
    MOV DL,0Ah
    INT 21H
    RET