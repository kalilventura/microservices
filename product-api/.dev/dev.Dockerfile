FROM gradle:8.7.0-jdk11-alpine as builder

ARG HOME_DIR="/home/app"
WORKDIR $HOME_DIR

COPY src src/
COPY build.gradle settings.gradle ./

RUN gradle assemble

FROM amazoncorretto:21.0.3-alpine3.19

RUN apk add --no-cache curl

ARG HOME_DIR="/home/app"
RUN addgroup -g 1001 xyz && adduser -D -u 1001 -h $HOME_DIR -G xyz app
WORKDIR $HOME_DIR

COPY --from=builder $HOME_DIR/build/libs/product-0.0.1.jar ./

RUN chown -R app:xyz $HOME_DIR
USER app

CMD [ "gradle", "bootRun" ]