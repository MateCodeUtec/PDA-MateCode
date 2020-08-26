--------------------------------------------------------
-- Archivo creado  - miércoles-agosto-26-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence SEQ_ID_FUNCIONALIDAD
--------------------------------------------------------

drop sequence SEQ_ID_FUNCIONALIDAD;
drop sequence SEQ_ID_PERSONA;
drop sequence SEQ_ID_ROL;
drop sequence SEQ_ID_ROL_FUNCION;

drop table PERSONA;
drop table ROL_FUNCION;
drop table FUNCIONALIDAD;
drop table ROL;



   CREATE SEQUENCE  "PRESENCIAL"."SEQ_ID_FUNCIONALIDAD"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 61 NOCACHE NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ID_PERSONA
--------------------------------------------------------

   CREATE SEQUENCE  "PRESENCIAL"."SEQ_ID_PERSONA"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 121 NOCACHE NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ID_ROL
--------------------------------------------------------

   CREATE SEQUENCE  "PRESENCIAL"."SEQ_ID_ROL"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 101 NOCACHE NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Sequence SEQ_ID_ROL_FUNCION
--------------------------------------------------------

   CREATE SEQUENCE  "PRESENCIAL"."SEQ_ID_ROL_FUNCION"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 101 NOCACHE NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;
--------------------------------------------------------
--  DDL for Table FUNCIONALIDAD
--------------------------------------------------------

  CREATE TABLE "PRESENCIAL"."FUNCIONALIDAD" 
   (	"ID_FUNCIONALIDAD" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(30 BYTE), 
	"DESCRIPCION" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table PERSONA
--------------------------------------------------------

  CREATE TABLE "PRESENCIAL"."PERSONA" 
   (	"ID_PERSONA" NUMBER(*,0), 
	"DOCUMENTO" VARCHAR2(20 BYTE), 
	"APELLIDO1" VARCHAR2(45 BYTE), 
	"NOMBRE1" VARCHAR2(45 BYTE), 
	"FECHA_NAC" DATE, 
	"CLAVE" VARCHAR2(200 BYTE), 
	"ID_ROL" NUMBER(*,0), 
	"MAIL" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ROL
--------------------------------------------------------

  CREATE TABLE "PRESENCIAL"."ROL" 
   (	"ID_ROL" NUMBER(*,0), 
	"NOMBRE" VARCHAR2(30 BYTE), 
	"DESCRIPCION" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table ROL_FUNCION
--------------------------------------------------------

  CREATE TABLE "PRESENCIAL"."ROL_FUNCION" 
   (	"ID_ROL_FUNCION" NUMBER(*,0), 
	"ID_ROL" NUMBER(*,0), 
	"ID_FUNCION" NUMBER(*,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into PRESENCIAL.FUNCIONALIDAD
SET DEFINE OFF;
Insert into PRESENCIAL.FUNCIONALIDAD (ID_FUNCIONALIDAD,NOMBRE,DESCRIPCION) values ('1','Control de inventario','Control de inventario');
Insert into PRESENCIAL.FUNCIONALIDAD (ID_FUNCIONALIDAD,NOMBRE,DESCRIPCION) values ('2','Cuentas corrientes','Cuentas corrientes');
Insert into PRESENCIAL.FUNCIONALIDAD (ID_FUNCIONALIDAD,NOMBRE,DESCRIPCION) values ('3','Compras','Compras');
Insert into PRESENCIAL.FUNCIONALIDAD (ID_FUNCIONALIDAD,NOMBRE,DESCRIPCION) values ('4','Ventas','Ventas');
Insert into PRESENCIAL.FUNCIONALIDAD (ID_FUNCIONALIDAD,NOMBRE,DESCRIPCION) values ('5','Sueldos','Sueldos');
REM INSERTING into PRESENCIAL.PERSONA
SET DEFINE OFF;
Insert into PRESENCIAL.PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,NOMBRE1,FECHA_NAC,CLAVE,ID_ROL,MAIL) values ('1','50450780','Martins','Ignacio',to_date('06/08/97','DD/MM/RR'),'202cb962ac59075b964b07152d234b70','1','imartins@gmail.com');
Insert into PRESENCIAL.PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,NOMBRE1,FECHA_NAC,CLAVE,ID_ROL,MAIL) values ('101','50534867','Piegas','Lucas',to_date('21/02/95','DD/MM/RR'),'81dc9bdb52d04dc20036dbd8313ed055','61','lpiegas@gmail.com');
Insert into PRESENCIAL.PERSONA (ID_PERSONA,DOCUMENTO,APELLIDO1,NOMBRE1,FECHA_NAC,CLAVE,ID_ROL,MAIL) values ('102','48014413','Sainz','Alina',to_date('28/08/97','DD/MM/RR'),'827ccb0eea8a706c4c34a16891f84e7b','61','asainz@gmail.com');
REM INSERTING into PRESENCIAL.ROL
SET DEFINE OFF;
Insert into PRESENCIAL.ROL (ID_ROL,NOMBRE,DESCRIPCION) values ('61','Administración','Administración');
Insert into PRESENCIAL.ROL (ID_ROL,NOMBRE,DESCRIPCION) values ('1','Administrador de sistema','Administrador de sistema');
REM INSERTING into PRESENCIAL.ROL_FUNCION
SET DEFINE OFF;
Insert into PRESENCIAL.ROL_FUNCION (ID_ROL_FUNCION,ID_ROL,ID_FUNCION) values ('83','1','3');
Insert into PRESENCIAL.ROL_FUNCION (ID_ROL_FUNCION,ID_ROL,ID_FUNCION) values ('84','1','4');
Insert into PRESENCIAL.ROL_FUNCION (ID_ROL_FUNCION,ID_ROL,ID_FUNCION) values ('85','1','5');
Insert into PRESENCIAL.ROL_FUNCION (ID_ROL_FUNCION,ID_ROL,ID_FUNCION) values ('81','1','1');
Insert into PRESENCIAL.ROL_FUNCION (ID_ROL_FUNCION,ID_ROL,ID_FUNCION) values ('82','1','2');
--------------------------------------------------------
--  DDL for Index PK_FUNCIONALIDAD
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRESENCIAL"."PK_FUNCIONALIDAD" ON "PRESENCIAL"."FUNCIONALIDAD" ("ID_FUNCIONALIDAD") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ID_ROL_FUNCION
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRESENCIAL"."PK_ID_ROL_FUNCION" ON "PRESENCIAL"."ROL_FUNCION" ("ID_ROL_FUNCION") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_PERSONA
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRESENCIAL"."PK_PERSONA" ON "PRESENCIAL"."PERSONA" ("ID_PERSONA") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index PK_ROL
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRESENCIAL"."PK_ROL" ON "PRESENCIAL"."ROL" ("ID_ROL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index UK_PERSONA_DOCUMENTO
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRESENCIAL"."UK_PERSONA_DOCUMENTO" ON "PRESENCIAL"."PERSONA" ("DOCUMENTO") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PERSONA
--------------------------------------------------------

  ALTER TABLE "PRESENCIAL"."PERSONA" MODIFY ("ID_PERSONA" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."PERSONA" MODIFY ("DOCUMENTO" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."PERSONA" MODIFY ("APELLIDO1" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."PERSONA" MODIFY ("NOMBRE1" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."PERSONA" MODIFY ("CLAVE" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."PERSONA" MODIFY ("ID_ROL" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."PERSONA" MODIFY ("MAIL" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."PERSONA" ADD CONSTRAINT "PK_PERSONA" PRIMARY KEY ("ID_PERSONA")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PRESENCIAL"."PERSONA" ADD CONSTRAINT "UK_PERSONA_DOCUMENTO" UNIQUE ("DOCUMENTO")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "PRESENCIAL"."PERSONA" MODIFY ("FECHA_NAC" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table FUNCIONALIDAD
--------------------------------------------------------

  ALTER TABLE "PRESENCIAL"."FUNCIONALIDAD" MODIFY ("ID_FUNCIONALIDAD" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."FUNCIONALIDAD" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."FUNCIONALIDAD" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."FUNCIONALIDAD" ADD CONSTRAINT "PK_FUNCIONALIDAD" PRIMARY KEY ("ID_FUNCIONALIDAD")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ROL_FUNCION
--------------------------------------------------------

  ALTER TABLE "PRESENCIAL"."ROL_FUNCION" MODIFY ("ID_ROL_FUNCION" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."ROL_FUNCION" MODIFY ("ID_ROL" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."ROL_FUNCION" MODIFY ("ID_FUNCION" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."ROL_FUNCION" ADD CONSTRAINT "PK_ID_ROL_FUNCION" PRIMARY KEY ("ID_ROL_FUNCION")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ROL
--------------------------------------------------------

  ALTER TABLE "PRESENCIAL"."ROL" MODIFY ("ID_ROL" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."ROL" MODIFY ("NOMBRE" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."ROL" MODIFY ("DESCRIPCION" NOT NULL ENABLE);
  ALTER TABLE "PRESENCIAL"."ROL" ADD CONSTRAINT "PK_ROL" PRIMARY KEY ("ID_ROL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PERSONA
--------------------------------------------------------

  ALTER TABLE "PRESENCIAL"."PERSONA" ADD CONSTRAINT "FK_PERSONA_ROL" FOREIGN KEY ("ID_ROL")
	  REFERENCES "PRESENCIAL"."ROL" ("ID_ROL") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ROL_FUNCION
--------------------------------------------------------

  ALTER TABLE "PRESENCIAL"."ROL_FUNCION" ADD CONSTRAINT "FK_ROL_FUNCION_ROL" FOREIGN KEY ("ID_ROL")
	  REFERENCES "PRESENCIAL"."ROL" ("ID_ROL") ENABLE;
  ALTER TABLE "PRESENCIAL"."ROL_FUNCION" ADD CONSTRAINT "FK_ROL_FUNCION_FUNCION" FOREIGN KEY ("ID_FUNCION")
	  REFERENCES "PRESENCIAL"."FUNCIONALIDAD" ("ID_FUNCIONALIDAD") ENABLE;
