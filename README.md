# PDA-S1-Presencial-Usuarios

# Levantar base:

- Ejecutar estos comandos como usuario SYSTEM en Oracle.

-/*Permitir script propios de oracle*/
-alter session set "_ORACLE_SCRIPT"=true;  

-/*Crear usuario instituto*/
-create user PRESENCIAL
identified by PRESENCIAL
default tablespace USERS;

-/*Conceder todos los permisos al usuario PRESENCIAL*/
-grant
ALL privileges
to PRESENCIAL;

-/*Conceder espacio para insertar datos*/
-ALTER USER PRESENCIAL quota unlimited on USERS;

-- Conectarse con el usuario PRESENCIAL
-- Luego el script que esta en la archivo PRESENCIAL-MateCode.sql
