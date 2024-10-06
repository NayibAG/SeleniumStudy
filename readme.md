




STEPS FOR TEST SUITE RUN
1. Install Maven.
1.1 Set MAVEN_HOME path in the system variables.
   MAVEN_HOME
   C:\Program Files\Maven\apache-maven-3.9.1\bin
1.2 Add MAVEN_HOME in path variable. (OPTIONAL)
    %MAVEN_HOME%\bin
2. Go to project dir.
3.  RUN TEST
-- mvn test    //RUN all the test which have test keyword at the end in source test.
-- mvn test -P<Profile id> -D<Parameter name>=<Value>    
example: mvn test -PDemo -DbrowserName=Firefox     