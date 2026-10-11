FROM tomcat:11.0-jdk21-temurin

COPY target/cen4802-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/cen4802.war

EXPOSE 8080

CMD ["catalina.sh", "run"]