# Utilisation de l'image Eclipse Temurin JDK 21 Alpine
FROM eclipse-temurin:21-jdk-alpine

# Définir le répertoire de travail
WORKDIR /app

# Installer Maven
RUN apk add --no-cache maven

# Copier le fichier POM et télécharger les dépendances
COPY pom.xml .
RUN mvn dependency:go-offline

# Copier le reste des fichiers de l'application et construire le package
COPY src ./src
RUN mvn clean package -DskipTests

# Copier les fichiers de configuration nécessaires
COPY src/main/resources/application.properties application.properties

# Définir le point d'entrée de l'application
ENTRYPOINT ["java", "-jar", "target/gondorchic-0.0.1-SNAPSHOT.jar"]
