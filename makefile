JUNIT_JAR = /usr/share/java/junit-4.10.jar
HAMCREST_JAR = /usr/share/java/hamcrest/core-1.1.jar

default: 
	@echo "usage: make target"
	@echo "available targets: compile, test, clean"

compile: Matrix.java MatrixTest.java
	 javac -cp .:$(JUNIT_JAR)  MatrixTest.java  
	 javac Matrix.java

clean:
	rm -f Matrix.class
	rm -f MatrixTest.class


test: Matrix.class
	java -cp .:$(JUNIT_JAR):$(HAMCREST_JAR) org.junit.runner.JUnitCore MatrixTest
