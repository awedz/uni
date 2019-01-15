org 100h

mov si,1000h
mov [si],10h
mov bl,[si]
and bl,00000001b
jz isZero
mov si,0040h
mov bl,20h
mov[si],bl
jmp done
isZero:
mov si,2000h
mov bl,40h
mov [si],bl
done:
ret