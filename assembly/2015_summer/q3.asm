DSEG SEGMENT;data
     ;arr db 'abccccdr',0
     arr db 'abc',0
     result db 0
    
DSEG ENDS       

SSEG SEGMENT STACK
      BLOCK DB 10h dup(?)
SSEG ENDS

CSEG SEGMENT
     ASSUME: CS:CSEG, DS:DSEG, SS:SSEG
BEGIN:
    MOV AX,DSEG
    MOV DS,AX
    MOV ES,AX
    
    lea si,arr
    mov di,si
    inc si
    mov cx,0
    
    cmp [di],0
    jnz start
    inc di
    mov [di],0
    jz done

    next_char:
    cld
    cmp [si],0
    jz noMore
    start:
    cmpsb
    
    mov bl,[si]
    mov bh,[di] 
    jbe desc
    inc cl
    jmp next
    desc:
    inc ch
    next: 
    cmp [di],0
    jmp next_char
    noMore:
    lea si,result
    cmp cl,0;check asc
    jg isDesc
    mov [si],1
    mov dx,1
    jmp done
 
    isDesc:
    cmp ch,0
    jg isRand
    mov [si],2
    mov dx,2
    jmp done
    
    isRand:
    mov [si],3
    mov dx,3
    
    done:
    MOV AH,4CH
    INT 21H
        
CSEG ENDS
END BEGIN