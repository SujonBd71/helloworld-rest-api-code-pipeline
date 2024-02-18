FROM openjdk:11
VOLUME /tmp
EXPOSE 80
ADD target/*.jar app.jar
ENV JAVA_OPTS=""

RUN apt-get update; \
    apt-get install -y --no-install-recommends curl;

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
