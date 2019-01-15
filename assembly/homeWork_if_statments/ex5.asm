org 100h   

mov bx,1000h;point to score ad
mov si,2000h
mov al,[si]
inc si
add al,[si]
mov si,3000h
mov ah,[si]
inc si
add ah,[si]
sub al,ah
jz isTrue;is even
jc isTrue;ah sum is bigger then al sum 
mov ax,7070h
jmp done
IsTrue:  
mov ax,3030h
done:
mov [bx],ax
ret