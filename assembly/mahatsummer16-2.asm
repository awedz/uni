MODUL EQU 10;const
SIZE EQU 8;ARRSIZE
DSEG SEGMENT;data
    arr db -3,8,9,12,5,32,64,1;0101 0110
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
    LEA di,arr;array
    
    push di
    push 8
        
    call asd
        
    
    MOV AH,4CH
    INT 21H
    
    
    asd:
    mov dl,0
    mov ax,0
    mov bp,sp
    
    mov cx,[bp+2]
    mov si,[bp+4]
    
    nextnum:
    push cx
    mov bl,[si]
    rcl bl,1
    jc no
    rcr bl,1 
    mov cx,7
        pow:

        rcr bl,1
        jnc next 
        inc dl
     
        next:
        cmp dl,1
        js no
     
        loop pow
    jmp yes
    
    no:
    rol al,1
    jmp done
    
    yes:
    inc al
    rol al,1      
    done:
    pop cx
    inc si
    mov dl,0
    loop nextnum
    
    ret 2
 
CSEG ENDS
END BEGIN