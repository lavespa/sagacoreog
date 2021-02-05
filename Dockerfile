ARG openjdkversion=11-jre-openj9
FROM maven:3.6-jdk-11-slim as builder
WORKDIR /app
#COPY settings.xml /root/.m2/
COPY ./consegne-services ./consegne-services
COPY ./cucine-services ./cucine-services
COPY ./ordini-service ./ordini-service
COPY pom.xml ./
RUN  --mount=type=cache,target=/root/.m2/ mvn  -e  -B package


FROM adoptopenjdk:$openjdkversion as ordini-service
COPY --from=builder  /app/ordini-service/target/ordini-service-0.0.1-SNAPSHOT.jar /usr/ordini-service/
WORKDIR /usr/ordini-service
EXPOSE 8090
CMD ["java", "-agentlib:jdwp=transport=dt_socket,address=8443,server=y,suspend=y", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=8090", "-jar", "ordini-service-0.0.1-SNAPSHOT.jar"]


FROM adoptopenjdk:$openjdkversion as cucine-services
COPY --from=builder  /app/cucine-services/target/cucine-services-0.0.1-SNAPSHOT.jar /usr/cucine-services/
WORKDIR /usr/cucine-services
EXPOSE 8080
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=8080", "-jar", "cucine-services-0.0.1-SNAPSHOT.jar"]


FROM adoptopenjdk:$openjdkversion as consegne-services
COPY --from=builder  /app/consegne-services/target/consegne-services-0.0.1-SNAPSHOT.jar /usr/consegne-services/
WORKDIR /usr/consegne-services
EXPOSE 8070
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dserver.port=8070", "-jar", "consegne-services-0.0.1-SNAPSHOT.jar"]