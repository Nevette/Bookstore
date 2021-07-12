@echo off
setlocal
set PGPASSWORD=postgres
psql -h localhost -p 5432 -U postgres -f queries/create-db.sql
endlocal