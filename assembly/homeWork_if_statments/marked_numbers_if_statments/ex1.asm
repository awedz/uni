org 100h   

mov si,1000h
mov al,00h
mov ah,69h
add al,[si]
inc si
add al,[si]
inc si
cmp al,ah
jnb isFalse
mov al,00h
jmp done
isFalse:
mov al,0ffh
done:
mov [si],00h
ret