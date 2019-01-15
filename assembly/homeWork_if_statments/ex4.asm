org 100h   

mov si,4000h
mov [si],03h
mov al,[si]
inc si
mov [si],02h
mov ah,[si]
add al,ah
mov si,3000h
mov [si],1h
sub al,[si]
mov si,1000h 
jnc isFalse
mov [si],7h
jmp quit
isFalse:
mov [si],-7h
quit:

ret