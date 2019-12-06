# FROM image
# ADD /my/Test.java /dir1/dir23/Test.java
# RUN apk add openjdk8
# ENV JAVA_HOME=/some/path
# WORKDIR /dir1/dir2
# EXPOSE 8050
# ENTRYPOINT sleep 5
# Any comments

FROM openjdk:8u191-jre-alpine3.9

RUN apk add curl jq

# Working directory in container
WORKDIR /usr/share/udemy

# Add all the .jar files from the target folder on the host machine into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# Add testng suite files
ADD bookFlight.xml bookFlight.xml
ADD duckTestng.xml duckTestng.xml
# Add any other dependency files as well e.g. json/xml/xls  Add healthcheck
ADD healthcheck.sh healthcheck.sh

# Parameters BROWSER, HUB_HOST, SUITE FILE
# ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB=$HUB_HOST org.testng.TestNG $MODULE
ENTRYPOINT sh healthcheck.sh






