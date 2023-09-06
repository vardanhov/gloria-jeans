FROM maven:3-openjdk-11-slim AS builder
RUN mkdir builddir
COPY . builddir
WORKDIR builddir
COPY ./gj-ca-root.crt /usr/local/share/ca-certificates/gj-ca-root.crt
RUN chmod 644 /usr/local/share/ca-certificates/gj-ca-root.crt
RUN update-ca-certificates
RUN mvn clean package -DskipTests -s docker-settings.xml

FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine AS runner
ENV onec.md.path="/tmp/****" \
    directory.printed.file="/tmp/Orders/" \
    spring.datasource-onec-database.jdbcUrl="jdbc:sqlserver://localhost:1433;databaseName=POS;encrypt=false" \
    spring.datasource-onec-database.username="*****" \
    spring.datasource-onec-database.password="*****" \
    spring.datasource-onec-database.driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver" \
    spring.datasource-internal-database.jdbcUrl="jdbc:sqlserver://localhost:1433;databaseName=gj_orders;encrypt=false" \
    spring.datasource-internal-database.username="*****" \
    spring.datasource-internal-database.password="*****" \
    spring.datasource-internal-database.driverClassName="com.microsoft.sqlserver.jdbc.SQLServerDriver" \
    server.port=8083 \
    server.address=0.0.0.0 \
    server.jetty.threads.min=2 \
    server.jetty.threads.max=4 \
    idd-generator.url="http://localhost:8089/idd/generator"
RUN apk --no-cache add msttcorefonts-installer fontconfig freetype && \
    update-ms-fonts && \
    fc-cache -f
RUN apk add dumb-init
RUN mkdir /app
COPY --from=builder /builddir/target/orders-1.0.48589-SNAPSHOT-spring-boot.jar /app/service.jar
WORKDIR /app
CMD "dumb-init" "java" "-Xmx256m" "-Xss256k" "-jar" "service.jar"
