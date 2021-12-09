FROM jetty

ADD JettyApp.war /var/lib/jetty/webapps/root.war

EXPOSE 8080

