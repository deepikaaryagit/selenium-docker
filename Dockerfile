FROM openjdk:19-jdk-alpine3.16
RUN apk add curl jq
#WorkSpace
WORKDIR /Users/deearya/myShare/
#Add .jar files under target from this host into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
#Add libs to the image
ADD target/libs libs
#Add .xml files to image 
ADD testng.xml testng.xml
#Add Health Check .sh 
ADD healthcheck.sh healthcheck.sh
#Entry point in image
ENTRYPOINT sh healthcheck.sh
#ENTRYPOINT java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DHUB_HOST=$HUB_HOST -DBROWSER=$BROWSER org.testng.TestNG $MODULE