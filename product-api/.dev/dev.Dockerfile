FROM gradle:8.0.2-jdk17-alpine as builder

ARG HOME_DIR="/home/app"
RUN addgroup -S -g 1001 xyz \ && adduser -S -u 1001 -h $HOME_DIR -G xyz app
WORKDIR $HOME_DIR

COPY src src/
COPY build.gradle settings.gradle ./

RUN chown -R app:xyz $HOME_DIR
USER app

RUN gradle clean bootJar

FROM amazoncorretto:20.0.2-alpine3.18

RUN apk add --no-cache curl

ARG HOME_DIR="/home/app"
RUN addgroup -S -g 1001 xyz \ && adduser -S -u 1001 -h $HOME_DIR -G xyz app
WORKDIR $HOME_DIR

COPY --from=builder $HOME_DIR/build/libs/api.jar ./

RUN chown -R app:xyz $HOME_DIR
USER app

CMD [ "gradle", "bootRun" ]