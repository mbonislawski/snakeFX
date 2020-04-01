rd /s /q out
mkdir out
javac -d out src\App.java src\Board.java src\Food.java src\GameEngine.java src\Point.java src\Snake.java
cd out
java SnakeFX
pause