@echo off
if not exist .mvn\wrapper\maven-wrapper.jar (
    echo Downloading Maven Wrapper...
    mkdir .mvn\wrapper
    curl -o .mvn\wrapper\maven-wrapper.jar https://repo.maven.apache.org/maven2/io/takari/maven-wrapper/0.6.6/maven-wrapper-0.6.6.jar
)
.\mvn.bat %*
