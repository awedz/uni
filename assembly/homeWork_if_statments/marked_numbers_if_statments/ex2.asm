mov si,1000h    
mov bx,00ff00h
mov al,[si]
inc si
cmp al,[si]
jne isNotSame
mov al,[si]
inc si
cmp al,[si]
jne isNotSame      
mov si,1003h
mov [si],bl
jmp quit
isNotSame:
mov [si],bh
quit: