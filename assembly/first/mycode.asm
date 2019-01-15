
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h
mov si,1000h 
mov di,1010h

mov al,[si]
mov [di],al 

ret




