MODUL EQU 10;const
SIZE EQU 8;ARRSIZE
DSEG SEGMENT;data
    arr db 255,1,-7,9
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
    LEA DI,arr;array
    
    
    mov ah,00
    mov dx,0
    push 3
    push 2
    push 1
    push 0
    
          
    pop si
    mov di,si 
    mov al,arr[di]
    call countbits    
    
    rpop si
    mov di,si 
    mov al,arr[di]
    call countbits
    
    pop si
    mov di,si 
    mov al,arr[di]
    call countbits
    
    pop si
    mov di,si 
    mov al,arr[di]
    call countbits 
    
    
    MOV AH,4CH
    INT 21H
         
        countbits:
    mov cx,8
     shl dx,4
    
    l1:
    shl al,1
    jnc zero
    inc dx
    zero:
    loop l1
    mov al,4

    ret     
CSEG ENDS
END BEGIN