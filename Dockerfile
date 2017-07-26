FROM opavlova/tomcat
ADD ./out/artifacts/Art/Art.war $CATALINA_HOME/webapps/
