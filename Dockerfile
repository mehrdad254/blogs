FROM adoptopenjdk/openjdk11:latest
LABEL maintainer="lost.mhr69@gmail.com"
WORKDIR /usr/app/
COPY ./target/blog-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java","-jar","blog-0.0.1-SNAPSHOT.jar" ]