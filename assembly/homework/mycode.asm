
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h
          
mov bx,3000h
mov ax,1234h
mov [bx],ax
ret




