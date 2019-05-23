
    
    
    
    
    CALL PRINT_1
    CALL PRINT_2
    MOV AH,4CH
    INT 21H
    
    PRINT_1:

    MOV AH,1    ;set read mode
    INT 21H     ;read
    MOV CX,10   ;set counter 
    
    MOV AH,09         ; FUNCTION 9
    MOV BX,000AH      ; PAGE 0, COLOR 4
    INT 10H           ; INTERRUPT 10 -> BIOS
    
    MOV DL,AL   ;move input to DL
    CALL PRINT  ;call print function
    RET         ;return
    
    PRINT_2:

    MOV AH,1    ;set read mode
    INT 21H     ;read
    CMP AL,'1'  ;compare input
    JZ EQ       ;if equal jump
    MOV DL,'*'  ;set print char
    MOV CX,15   ;set repeats 
    JMP END     ;jump to print functaion call
    EQ:
    MOV DL,'#'  ;set print char
    MOV CX,8    ;set repeat
    END:
    
    MOV AH,09         ; FUNCTION 9
    MOV BX,000BH      ; PAGE 0, COLOR 4
    INT 10H           ; INTERRUPT 10 -> BIOS
    
    CALL PRINT  ;call print function
    RET         ;return
    
    
    ;print  function
    PRINT:     

    MOV AH,2    ;set write mode
    AGAIN:
    INT 21H     ;write
    LOOP AGAIN  ;loop to write
    MOV DL,0Dh  ;set go back to start char
    INT 21H     ;write
    MOV DL,0Ah  ;set new line char
    INT 21H     ;write

    RET         ;return