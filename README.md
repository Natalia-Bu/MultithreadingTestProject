# MultithreadingTestProject
BostonGene test project
***
Сборка и запуск:  
1. javac -g -sourcepath ./src -d bin src/testProject/Main.java
2. java -classpath ./bin testProject.Main

Использование:

Вводите числительные на английском языке (от one до nine thousand nine hundred ninety nine).  
Для выхода из программы введите 'stop'.  
Числа записываются в память. Второй поток обращается к памяти один раз в пять секунд, удаляет из
памяти самое маленькое из записанных чисел и выводит его на экран.
