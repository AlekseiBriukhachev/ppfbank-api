# Use the official Microsoft SQL Server image as the base image
FROM mcr.microsoft.com/mssql/server:2019-latest AS mssql

USER root

# Install SQL Server tools
RUN apt-get update && \
    apt-get install -y curl apt-transport-https && \
    curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add - && \
    curl https://packages.microsoft.com/config/ubuntu/20.04/prod.list > /etc/apt/sources.list.d/mssql-release.list && \
    apt-get update && \
    ACCEPT_EULA=Y apt-get install -y msodbcsql17 mssql-tools unixodbc-dev && \
    echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> /etc/bash.bashrc && \
    /bin/bash -c "source /etc/bash.bashrc"

# Copy initialization scripts
COPY src/main/resources/db /src/main/resources/db

# Run Microsoft SQL Server and initialization script (at the same time)
CMD /bin/bash /src/main/resources/db/entrypoint.sh & /opt/mssql/bin/sqlservr

# Switch back to mssql user
USER mssql

# Use the official OpenJDK image as the base image for the application
FROM openjdk:17-jdk-slim

WORKDIR /ppfbank-api

# Copy the built JAR file
COPY build/libs/*.jar ppfbank-api.jar

# Expose the application port
EXPOSE 8081

# Set the entrypoint for the application
ENTRYPOINT ["java", "-jar", "ppfbank-api.jar"]