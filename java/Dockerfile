FROM openjdk:8-jdk

WORKDIR /app

COPY target/SimpleHttpServer-1.0-SNAPSHOT.jar edu1.jar 
COPY target/jmx_prometheus_javaagent.jar jmx_exporter.jar
COPY target/config.yaml config.yaml

ENV JAVA_OPTS="-Xms512m -Xmx1024m"

EXPOSE 8080 9404

ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -javaagent:jmx_exporter.jar=9404:config.yaml -jar edu1.jar"]



