org 100h   

mov si,1000h
mov al,69h
sub al,[si]
jz notSmaller              
jnc notSmaller
inc si
mov al,69h
sub al,[si]
jz notSmaller              
jnc notSmaller
smaller:
inc si   
mov al,0ffh
mov [si],al
jmp quit
notSmaller:
mov si,1002h
mov [si],00h
quit:
ret