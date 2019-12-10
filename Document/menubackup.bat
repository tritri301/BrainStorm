@ECHO OFF
C:
CD\
CLS

### Initialiser chemins backup et restore 

:MENU
CLS

ECHO ============= MENU NAME =============
ECHO -------------------------------------
ECHO 1.  Backup complet
ECHO 2.  Backup partiel (NON FONCTIONNEL)
ECHO 3.  Restore
ECHO 4.  Voir backup
ECHO -------------------------------------
ECHO ==========PRESS 'Q' TO QUIT==========
ECHO.

SET INPUT=
SET /P INPUT=Please select a number:

IF /I '%INPUT%'=='1' GOTO Selection1
IF /I '%INPUT%'=='2' GOTO Selection2
IF /I '%INPUT%'=='3' GOTO Selection3
IF /I '%INPUT%'=='4' GOTO Selection4
IF /I '%INPUT%'=='Q' GOTO Quit

CLS

ECHO ============INVALID INPUT============
ECHO -------------------------------------
ECHO Please select a number from the Main
echo Menu [1-4] or select 'Q' to quit.
ECHO -------------------------------------
ECHO ======PRESS ANY KEY TO CONTINUE======

PAUSE > NUL
GOTO MENU

:Selection1

START C:\backup\backupcomplet.bat
pause
GOTO MENU
:Selection2

pause 
GOTO MENU

:Selection3

START C:\backup\restore.bat

pause
GOTO MENU

:Selection4

DIR c:\MYSQLBACKUPS
pause
GOTO MENU

:Quit
CLS

ECHO ==============THANKYOU===============
ECHO -------------------------------------
ECHO ======PRESS ANY KEY TO CONTINUE======

PAUSE>NUL
EXIT