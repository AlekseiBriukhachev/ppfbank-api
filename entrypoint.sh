#!/bin/bash

# Start SQL Server in the background
/opt/mssql/bin/sqlservr &

# Wait for SQL Server to be ready
echo "Waiting for SQL Server to start..."
until /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P MyStrongPass123 -Q "SELECT 1" &> /dev/null
do
  echo -n "."
  sleep 1
done

echo "SQL Server is up and running."

# Grant permissions to the user
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P MyStrongPass123 -Q "USE [ppfbank-db]; GRANT ALTER, CONTROL, CREATE TABLE TO [admin1]"

# Run the database initialization script
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P MyStrongPass123 -i /src/main/resources/db/ta_database_init.sql

echo "Running table creation script"
/opt/mssql-tools/bin/sqlcmd -S localhost -U admin1 -P Pass1234 -d ppfbank-db -i /src/main/resources/db/ta_database.sql

echo "Running data population script"
/opt/mssql-tools/bin/sqlcmd -S localhost -U admin1 -P Pass1234 -d ppfbank-db -i /src/main/resources/db/ta_populate.sql

# Keep the container running
wait