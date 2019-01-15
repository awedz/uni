org 100h   

mov si,4000h
;mov [si],2h
mov di,5000h
;mov [di],5h

mov al,[si]
mov ah,[di]
inc si
inc di
add al,[si]
add ah,[di]
mov si,6000h
sub al,ah
jz isEven
jc isSmaller
mov [si],88h
jmp done 
isEven:
isSmaller:
sub [si],12h
done:

ret