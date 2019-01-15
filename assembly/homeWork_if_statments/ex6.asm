org 100h   

mov si,201h
mov di,200h
mov al,[si]
sub al,[di]
jnc isFalse
inc si
mov al,[si]
sub al,[di]
mov si,205h
jnc isFalse
mov al,80h
jmp done
isFalse:
mov al,90h
done:
mov [si],al 

ret