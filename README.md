# datemath
provide method to add minutes to a date string

# Setup
Install Java 8 JDK per OS requirements

run `java -version` and make sure it returns the expected version

clone this repo to a dir on your filesystem

Go to repo root dir

# Compile app
```bash
cd src
javac ./*
```

# Run CardRank app
after Compile app step run TimeMath like this:
```bash
java TimeMath "9:13 AM" 200
```

# Compile and Run Tests
after Compile app step, run these commands to compile
```bash
cd ../test
javac -cp ../src:../ext/lib/junit-4.12.jar ./*

```
Then run these commands to run the two test suite
```bash
java -cp .:../src:../ext/lib/junit-4.12.jar:../ext/lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore ChronosTest

```
The tests will run, each one is a . on the console. If there are failures they will be identified on the console.
