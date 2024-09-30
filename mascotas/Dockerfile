FROM openjdk:17
WORKDIR /app
COPY target/mascotas-0.0.1-SNAPSHOT.jar app.jar
COPY Wallet_RMKNXQLAHHEARTIA /app/oracle_wallet
EXPOSE 8080
CMD [ "java", "-jar", "app.jar" ]
