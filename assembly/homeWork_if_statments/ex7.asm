org 100h   

mov al,00h
mov ah,89h
mov si,1000h
;mov [si],30h
add al,[si]
jc isCarry;bigger then 8bit
inc si 
;mov [si],30h
add al,[si] 
jc isCarry
inc si   
;mov [si],30h
add al,[si] 
jc isCarry
inc si
sub al,ah
jz isZero
jc isCarry
mov ah,20h
jmp done
isZero:
isCarry:
mov ah,17h
done:
mov [si],ah 

ret