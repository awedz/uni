org 100h   

mov si,1000h    
mov [si],12h
mov bx,00ff00h
mov al,[si]
inc si
sub al,[si]
jnz isNotSame
mov al,[si]
inc si
sub al,[si]
jnz isNotSame      
mov si,1003h
mov [si],bl
jmp quit
isNotSame:
mov [si],bh
quit:

ret