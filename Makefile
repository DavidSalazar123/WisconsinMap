run: compile
	java --module-path javafx-sdk-17.0.1/lib/ --add-modules javafx.controls mapApp

test: compile
	 java -cp .:junit5.jar --module-path javafx-sdk-17.0.1/lib/ --add-modules javafx.controls functionalityTest

compile:
	javac MapData.java
	javac GraphADT.java
	javac CS400Graph.java
	javac MapBackEnd.java
	javac MapLoader.java
	javac -cp .:junit5.jar --module-path javafx-sdk-17.0.1/lib/ --add-modules javafx.controls  MapFrontEnd.java functionalityTest.java

clean: 
	rm *.class
