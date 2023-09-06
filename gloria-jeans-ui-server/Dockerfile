FROM maven:3-openjdk-11-slim AS builder
RUN mkdir builddir
COPY . builddir
WORKDIR builddir
COPY ./gj-ca-root.crt /usr/local/share/ca-certificates/gj-ca-root.crt
RUN chmod 644 /usr/local/share/ca-certificates/gj-ca-root.crt
RUN update-ca-certificates
RUN mvn clean package -DskipTests -s docker-settings.xml

FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine AS runner
ENV onec.base-server-url="${BASE_SERVER_URL}" \
    server.port=8080 \
    server.address=0.0.0.0 \
    server.jetty.threads.min=2 \
    server.jetty.threads.max=4 \
    services.receiving=http://0.0.0.0:8082/receiving \
    services.orders=http://0.0.0.0:8083/orders
RUN apk add dumb-init
RUN mkdir /app
COPY --from=builder /builddir/target/ui-server-1.0.0-SNAPSHOT-spring-boot.jar /app/service.jar
WORKDIR /app
CMD "dumb-init" "java" "-Xmx256m" "-Xss256k" "-jar" "service.jar"
