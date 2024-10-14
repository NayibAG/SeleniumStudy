RUN TEST SUITE IN CHROME AND FIREFOX BROWSERS IN DOCKER COMPOSE USING AUTOSCRIPT
- sudo bash Script.sh

RUN TEST SUITE IN CHROME BROWSER USING DOCKER COMPOSE
- sudo docker-compose -f docker-compose-chrome.yaml up --build
- sudo docker-compose -f docker-compose-chrome.yaml down

RUN TEST SUITE IN FIREFOX BROWSER USING DOCKER COMPOSE
- sudo docker-compose -f docker-compose-firefox.yaml up --build
- sudo docker-compose -f docker-compose-firefox.yaml down

IN CASE YOU WANT TO LOOK TEST EXECUTION (WORKS ON BOTH BROWSERS)
http://localhost:7900/?autoconnect=1&resize=scale&password=secret


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
example: mvn test -PRegression -DbrowserName=Firefox     



RUN TEST SUITE USING DOCKER IMAGE
sudo docker build . -f Dockerfile -t seleniumstudy

RUN TEST SUITE USING AUTOMATE SCRIPT
- sudo bash Script.sh

