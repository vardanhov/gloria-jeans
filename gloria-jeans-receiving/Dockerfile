FROM maven:3-openjdk-11-slim AS builder
RUN mkdir builddir
COPY . builddir
WORKDIR builddir
COPY ./gj-ca-root.crt /usr/local/share/ca-certificates/gj-ca-root.crt
RUN chmod 644 /usr/local/share/ca-certificates/gj-ca-root.crt
RUN update-ca-certificates
RUN mvn clean package -DskipTests -s docker-settings.xml

FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine AS runner
ENV onec.md.path="/tmp/*****" \
    spring.datasource-onec-database.jdbcUrl="jdbc:sqlserver://localhost:1433;databaseName=ARM;encrypt=false" \
    spring.datasource-onec-database.username="****" \
    spring.datasource-onec-database.password="****" \
    spring.datasource-onec-database.driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver" \
    spring.datasource-internal-database.jdbcUrl="jdbc:sqlserver://localhost:1433;databaseName=gj_warehouse;encrypt=false" \
    spring.datasource-internal-database.username="****" \
    spring.datasource-internal-database.password="****" \
    spring.datasource-internal-database.driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver" \
    server.port=8082 \
    server.address=0.0.0.0 \
    server.jetty.threads.min=2 \
    server.jetty.threads.max=4 \
    idd-generator.url="http://id-generator:81/idd/generator" \
    marks.server.url="http://rnd-stamp-tst.gloria.aaanet.ru:8040" \
    marks.server.authorization.url="https://rnd-netsso-test.gloria.aaanet.ru/auth" \
    marks.server.authorization.username="*****" \
    marks.server.authorization.password="*****"
RUN apk add dumb-init
RUN mkdir /app
COPY --from=builder /builddir/target/receiving-1.0.0-SNAPSHOT-spring-boot.jar /app/service.jar
WORKDIR /app
CMD "dumb-init" "java" "-Xmx256m" "-Xss256k" "-jar" "service.jar"
