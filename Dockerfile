FROM ubuntu

RUN apt-get update
RUN apt-get upgrade -y

# Install Java SDK 11
RUN DEBIAN_FRONTEND=noninteractive TZ=Etc/UTC apt-get -y install tzdata
RUN apt install -y openjdk-11-jdk
RUN export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
RUN export PATH=$JAVA_HOME/bin:$PATH

# Install Maven
RUN apt install -y maven

COPY . .

ENTRYPOINT mvn test -PRegression