#!/usr/bin/env bash

# Wait for the SQL Server to come up
sleep 30s

echo "Running database initialization script"
# Run the setup script to create the DB and the schema in the DB
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P MyStrongPass123 -d master -i /src/main/resources/db/ta_database_init.sql

echo "Running table creation script"
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P MyStrongPass123 -d ppfbank -i /src/main/resources/db/ta_database.sql

echo "Running data population script"
/opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P MyStrongPass123 -d ppfbank -i /src/main/resources/db/ta_populate.sql