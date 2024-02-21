// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen
// by writing 'black' in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen by writing
// 'white' in every pixel;
// the screen should remain fully clear as long as no key is pressed.

//// Replace this comment with your code.


@8192
D=A

@width
M=D

@i
M=0

// (LOOP) // Will Inclode everything
(CHECKING) // To check the status of the KBD
@KBD
D=M
@MAKE_WHITE
D;JEQ
@MAKE_BLACK
D;JNE
(MAKE_WHITE) // Block for making white
@width
D=M
@REFRESH
D;JEQ
@i
D=M
@SCREEN
A=A+D
M=0
@i
M=M+1
@width
M=M-1
@CHECKING // // Can also be @MAKE_WHITE
0;JMP
(MAKE_BLACK) // Block for making black
@width
D=M
@REFRESH
D;JEQ
@i
D=M
@SCREEN
A=A+D
M=-1
@i
M=M+1
@width
M=M-1
@CHECKING // Can also be @MAKE_BLACK
0;JMP
(REFRESH) // setting back the variables + getting back to the loop
@i
M=0
@8192
D=A
@width
M=D
@CHECKING
0;JMP

