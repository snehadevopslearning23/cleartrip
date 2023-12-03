 FROM tomcat:9.0.52 jre11-openjdk-slim
 COPY 1/target/cleartrip*.jar /usr/Local/tomcat/webapps
 EXPOSE 8080
 USER cleartrip
 WORKDIR /us/Local/tomcat/webapps
 CMD ["catalina.sh", "run")