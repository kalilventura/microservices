FROM gradle:8.0.2-jdk17-alpine
COPY --chown=gradle:gradle . .
WORKDIR .
RUN gradle build -x test --no-daemon
EXPOSE 8081
CMD [ "gradle", "bootRun" ]