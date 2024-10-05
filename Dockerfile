FROM mcr.microsoft.com/mssql/server:2019-latest

# Set environment variables
ENV SA_PASSWORD=MyStrongPass123
ENV ACCEPT_EULA=Y
ENV MSSQL_PID=Express

# Install mssql-tools and unixODBC
USER root
RUN apt-get update \
    && apt-get install -y curl apt-transport-https gnupg \
    && curl https://packages.microsoft.com/keys/microsoft.asc | apt-key add - \
    && curl https://packages.microsoft.com/config/ubuntu/20.04/prod.list > /etc/apt/sources.list.d/mssql-release.list \
    && apt-get update \
    && ACCEPT_EULA=Y apt-get install -y msodbcsql17 mssql-tools \
    && echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bashrc \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Copy initialization scripts
COPY src/main/resources/db/entrypoint.sh /entrypoint.sh
COPY src/main/resources/db/ta_database_init.sql /src/main/resources/db/ta_database_init.sql
COPY src/main/resources/db/ta_database.sql /src/main/resources/db/ta_database.sql
COPY src/main/resources/db/ta_populate.sql /src/main/resources/db/ta_populate.sql

# Set entrypoint
ENTRYPOINT ["bash", "/entrypoint.sh"]