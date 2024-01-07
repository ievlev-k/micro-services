FROM eclipse-temurin:17-jdk-jammy as build
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src

FROM build as run
CMD ["./mvnw", "spring-boot:run"]