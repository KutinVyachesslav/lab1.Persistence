::chcp 65001
::mvn clean compile assembly:single
::mvn clean
mvn package spring-boot:repackage
