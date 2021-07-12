@echo off
setlocal
set PGPASSWORD=postgres
psql -h localhost -p 5432 -U postgres -f queries/create-db.sql
psql -h localhost -p 5432 -U postgres -d bookstore -f queries/db-setup.sql
endlocal