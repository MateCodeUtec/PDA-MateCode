# PDA-S1-Presencial-Usuarios

# Levantar base:

- Ejecutar estos comandos como usuario SYSTEM en Oracle.

-/*Permitir script propios de oracle*/
-alter session set "_ORACLE_SCRIPT"=true;  

-/*Crear usuario instituto*/
-create user PRESENCIAL
identified by PRESENCIAL
default tablespace USERS;

-/*Conceder permisos de Conexion, Creacion de objetos y Consultar diccionario de datos*/
-grant
ALL privileges
to PRESENCIAL;

-/*Conceder espacio para insertar datos*/
-/*Se hace con el usuario SYSTEM*/
-ALTER USER PRESENCIAL quota unlimited on USERS;

- Luego el script que esta en la archivo PRESENCIAL_BD
