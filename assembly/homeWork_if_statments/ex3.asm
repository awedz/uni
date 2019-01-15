org 100h   

mov si,2000h ;insert data for test purpse
mov [si],1h
inc si 
mov di,3000h
mov ah,7h
mov al,[si]
dec si
sub al,[si]
jz isFalse
jnc isFalse
mov [di],ah
jmp quit
isFalse:
inc ah
sub [di],ah
quit:
ret