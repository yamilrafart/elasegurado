-- CREACION DE LA BASE DE DATOS
CREATE DATABASE ElAseguradoBD;

-- CREACION DE ENUMS
CREATE TYPE TipoDocumento AS ENUM('DNI','LE','PASAPORTE', 'LC');
CREATE TYPE EstadoPoliza AS ENUM('GENERADA','SUSPENDIDA','VIGENTE', 'NO_VIGENTE');
CREATE TYPE EnumTipoCobertura AS ENUM('RESPONSABILIDAD_CIVIL',
									  'RESP_CIVIL_ROBO_O_INCENDIO_TOTAL',
									  'TODO_TOTAL',
									  'TERCEROS_COMPLETOS',
									  'TODO_RIESGO_CON_FRANQUICIA'
);
CREATE TYPE AccionAuditoria AS ENUM('CREACION','MODIFICACION','ELIMINACION');
CREATE TYPE Rol AS ENUM('GERENCIA','PRODUCTOR_SEGURO','COBRADOR');
CREATE TYPE CantidadSiniestros AS ENUM('NINGUNO','UNO','DOS', 'MAS_DE_DOS');
CREATE TYPE CondicionCliente AS ENUM('NORMAL','ACTIVO','PLATA');
CREATE TYPE FormaPago AS ENUM('MENSUAL','SEMESTRAL');
CREATE TYPE CondicionIVA AS ENUM('RESPONSABLE_INSCRIPTO','SUJETO_EXENTO','CONSUMIDOR_FINAL');
CREATE TYPE EstadoCivil AS ENUM('SOLTERO','CASADO','VIUDO', 'DIVORCIADO');
CREATE TYPE EstadoPagoCuota AS ENUM('ADELANTADA','MORA','EN_TERMINO');
CREATE TYPE EstadoCuota AS ENUM('PAGO','IMPAGO');
CREATE TYPE Sexo AS ENUM('MASCULINO','FEMENINO');

-- CREACION DE TABLAS
CREATE TABLE pais (
	id_pais SERIAL CONSTRAINT pk_id_pais PRIMARY KEY,
	nombre_pais VARCHAR(30)
);

CREATE TABLE provincia (
	id_provincia SERIAL CONSTRAINT pk_id_provincia PRIMARY KEY,
	nombre_provincia VARCHAR(50),
	id_pais INTEGER,
	CONSTRAINT fk_id_pais FOREIGN KEY(id_pais) REFERENCES pais(id_pais)
);

CREATE TABLE localidad (
	id_localidad SERIAL CONSTRAINT pk_id_localidad PRIMARY KEY,
	nombre_localidad VARCHAR(50),
	codigo_postal VARCHAR(4),
	id_provincia INTEGER,
	CONSTRAINT fk_id_provincia FOREIGN KEY(id_provincia) REFERENCES provincia(id_provincia)
);

CREATE TABLE tipo_cobertura (
	id_tipo_cobertura SERIAL CONSTRAINT pk_id_tipo_cobertura PRIMARY KEY,
	nombre_tipo_cobertura enumtipocobertura
);

CREATE TABLE usuario (
	id_usuario SERIAL CONSTRAINT pk_id_usuario PRIMARY KEY,
	rol_usuario rol,
	nombre_usuario VARCHAR(15),
	contrasenia VARCHAR(20)
);

CREATE TABLE registro_auditoria (
	id_registro_auditoria SERIAL CONSTRAINT pk_id_registro_auditoria PRIMARY KEY,
	accion accionauditoria,
	fecha_modificacion DATE,
	id_usuario INTEGER,
	CONSTRAINT fk_id_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE ajuste_localidad (
	id_ajuste_localidad SERIAL CONSTRAINT pk_id_ajuste_localidad PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	valor_porcentual DECIMAL,
	id_localidad INTEGER,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_localidad FOREIGN KEY(id_localidad) REFERENCES localidad(id_localidad),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id_registro_auditoria)
);

CREATE TABLE ajuste_tipo_cobertura (
	id_ajuste_tipo_cobertura SERIAL CONSTRAINT pk_id_ajuste_tipo_cobertura PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	valor_porcentual DECIMAL,
	id_tipo_cobertura INTEGER,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_tipo_cobertura FOREIGN KEY(id_tipo_cobertura) REFERENCES tipo_cobertura(id_tipo_cobertura),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id_registro_auditoria)
);

CREATE TABLE pago (
	id_pago SERIAL CONSTRAINT pk_id_pago PRIMARY KEY,
	nro_poliza VARCHAR(13),
	hora time,
	nro_recibo INTEGER,
	fecha DATE,
	importe DECIMAL,
	vuelto DECIMAL,
	id_usuario INTEGER,
	CONSTRAINT fk_id_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id_usuario)
);

CREATE TABLE direccion (
	id_direccion SERIAL CONSTRAINT pk_id_direccion PRIMARY KEY,
	calle VARCHAR(40),
	nro VARCHAR(5),
	piso VARCHAR(2),
	dpto VARCHAR(10),
	id_localidad INTEGER,
	CONSTRAINT fk_id_localidad FOREIGN KEY(id_localidad) REFERENCES localidad(id_localidad)
);

CREATE TABLE cliente (
	id_cliente SERIAL CONSTRAINT pk_id_cliente PRIMARY KEY,
	nro_cliente VARCHAR(4),
	apellido VARCHAR(50),
	nombre VARCHAR(50),
	tipo_documento tipodocumento,
	nro_documento VARCHAR(10),
	cuil VARCHAR(13),
	sexo_cliente sexo,
	fecha_nacimiento DATE,
	condicion_de_iva condicioniva,
	email VARCHAR(50),
	estado_civil estadocivil,
	profesion VARCHAR(50),
	anio_registro DATE,
	condicion condicioncliente,
	eliminado BOOLEAN,
	id_direccion INTEGER,
	CONSTRAINT fk_id_direccion FOREIGN KEY(id_direccion) REFERENCES direccion(id_direccion)
);

CREATE TABLE parametro_poliza (
	id_parametro_poliza SERIAL CONSTRAINT pk_id_parametro_poliza PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	porcentaje_por_cada_diez_mil_km DECIMAL,
	porcentaje_sin_siniestro DECIMAL,
	porcentaje_un_siniestro DECIMAL,
	porcentaje_dos_siniestro DECIMAL,
	porcentaje_mas_de_dos_siniestro DECIMAL,
	porcentaje_por_hijo_registrado DECIMAL,
	descuento_por_unidad_adicional DECIMAL,
	valor_derecho_de_emision DECIMAL,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id_registro_auditoria)
);

CREATE TABLE medida_seguridad (
	id_medida_seguridad SERIAL CONSTRAINT pk_id_medida_seguridad PRIMARY KEY,
	nombre_medida_seguridad VARCHAR(50)
);

CREATE TABLE ajuste_medida_seguridad (
	id_ajuste_medida_seguridad SERIAL CONSTRAINT pk_id_ajuste_medida_seguridad PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	valor_porcential DECIMAL,
	id_medida_seguridad INTEGER,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_medida_seguridad FOREIGN KEY(id_medida_seguridad) REFERENCES medida_seguridad(id_medida_seguridad),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id_registro_auditoria)
);

CREATE TABLE marca (
	id_marca SERIAL CONSTRAINT pk_id_marca PRIMARY KEY,
	nombre_marca VARCHAR(40)
);

CREATE TABLE modelo (
	id_modelo SERIAL CONSTRAINT pk_id_modelo PRIMARY KEY,
	nombre_modelo VARCHAR(40),
	id_marca INTEGER,
	CONSTRAINT fk_id_marca FOREIGN KEY(id_marca) REFERENCES marca(id_marca)
);

CREATE TABLE ajuste_modelo (
	id_ajuste_modelo SERIAL CONSTRAINT pk_id_ajuste_modelo PRIMARY KEY,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	valor_porcential DECIMAL,
	id_modelo INTEGER,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_modelo FOREIGN KEY(id_modelo) REFERENCES modelo(id_modelo),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id_registro_auditoria)
);

CREATE TABLE anio_fabricacion (
	id_anio_fabricacion SERIAL CONSTRAINT pk_id_anio_fabricacion PRIMARY KEY,
	anio VARCHAR(4)
);

CREATE TABLE suma_asegurada (
	id_modelo SERIAL,
	id_anio_fabricacion SERIAL,
	suma_asegruada DECIMAL,
	CONSTRAINT pk_id_modelo_id_anio_fabricacion PRIMARY KEY(id_modelo, id_anio_fabricacion),
	CONSTRAINT fk_id_modelo FOREIGN KEY(id_modelo) REFERENCES modelo(id_modelo),
	CONSTRAINT fk_id_anio_fabricacion FOREIGN KEY(id_anio_fabricacion) REFERENCES anio_fabricacion(id_anio_fabricacion)
);

CREATE TABLE solicitud_poliza (
	id_solicitud_poliza SERIAL CONSTRAINT id_solicitud_poliza PRIMARY KEY,
	motor VARCHAR(20),
	chasis VARCHAR(50),
	patente VARCHAR(20),
	km_por_anio INTEGER,
	cantidad_siniestros cantidadsiniestros,
	id_anio_fabricacion INTEGER,
	id_modelo INTEGER,
	id_registro_auditoria INTEGER,
	CONSTRAINT fk_id_anio_fabricacion FOREIGN KEY(id_anio_fabricacion) REFERENCES anio_fabricacion(id_anio_fabricacion),
	CONSTRAINT fk_id_modelo FOREIGN KEY(id_modelo) REFERENCES modelo(id_modelo),
	CONSTRAINT fk_id_registro_auditoria FOREIGN KEY(id_registro_auditoria) REFERENCES registro_auditoria(id_registro_auditoria)
);

CREATE TABLE asociado_a (
	id_solicitud_poliza SERIAL,
	id_medida_seguridad SERIAL,
	CONSTRAINT pk_id_solicitud_poliza_id_medida_seguridad PRIMARY KEY(id_solicitud_poliza, id_medida_seguridad),
	CONSTRAINT fk_id_solicitud_poliza FOREIGN KEY(id_solicitud_poliza) REFERENCES solicitud_poliza(id_solicitud_poliza),
	CONSTRAINT fk_id_medida_seguridad FOREIGN KEY(id_medida_seguridad) REFERENCES medida_seguridad(id_medida_seguridad)
);

CREATE TABLE poliza (
	id_poliza SERIAL CONSTRAINT id_poliza PRIMARY KEY,
	motor VARCHAR(20),
	cantidad_siniestros cantidadsiniestros,
	fecha_inicio_vigencia DATE,
	fecha_fin_vigencia DATE,
	patente VARCHAR(20),
	estado_poliza estadopoliza,
	km_por_anio INTEGER,
	nro_poliza VARCHAR(13),
	forma_pago formapago,
	chasis VARCHAR(50),
	valor_descuento DECIMAL,
	valor_premio DECIMAL,
	id_modelo INTEGER,
	id_localidad INTEGER,
	id_parametro_poliza INTEGER,
	id_cliente INTEGER,
	id_tipo_cobertura INTEGER,
	CONSTRAINT fk_id_modelo FOREIGN KEY(id_modelo) REFERENCES modelo(id_modelo),
	CONSTRAINT fk_id_localidad FOREIGN KEY(id_localidad) REFERENCES localidad(id_localidad),
	CONSTRAINT fk_id_parametro_poliza FOREIGN KEY(id_parametro_poliza) REFERENCES parametro_poliza(id_parametro_poliza),
	CONSTRAINT fk_id_cliente FOREIGN KEY(id_cliente) REFERENCES cliente(id_cliente),
	CONSTRAINT fk_id_tipo_cobertura FOREIGN KEY(id_tipo_cobertura) REFERENCES tipo_cobertura(id_tipo_cobertura)
);

CREATE TABLE posee (
	id_poliza SERIAL,
	id_medida_seguridad SERIAL,
	CONSTRAINT pk_id_poliza_id_medida_seguridad PRIMARY KEY(id_poliza, id_medida_seguridad),
	CONSTRAINT fk_id_poliza FOREIGN KEY(id_poliza) REFERENCES poliza(id_poliza),
	CONSTRAINT fk_id_medida_seguridad FOREIGN KEY(id_medida_seguridad) REFERENCES medida_seguridad(id_medida_seguridad)
);

CREATE TABLE hijo_declarado (
	id_hijo_declarado SERIAL CONSTRAINT pk_id_hijo_declarado PRIMARY KEY,
	fecha_nacimiento DATE,
	sexo_hijo_declarado sexo,
	estado_civil estadocivil,
	id_poliza INTEGER,
	id_solicitud_poliza INTEGER,
	CONSTRAINT fk_id_poliza FOREIGN KEY(id_poliza) REFERENCES poliza(id_poliza),
	CONSTRAINT fk_id_solicitud_poliza FOREIGN KEY(id_solicitud_poliza) REFERENCES solicitud_poliza(id_solicitud_poliza)
);

CREATE TABLE cuota (
	id_cuota SERIAL CONSTRAINT pk_id_cuota PRIMARY KEY,
	nro_cuota INTEGER,
	mes_abonado VARCHAR(10),
	estado estadocuota,
	estado_pago_cuota estadopagocuota,
	recargo_mora DECIMAL,
	ultimo_dia_de_pago DATE,
	bonificacion_pago_adelantado DECIMAL,
	anio_abonado VARCHAR(4),
	monto DECIMAL,
	id_poliza INTEGER,
	id_pago INTEGER,
	CONSTRAINT fk_id_poliza FOREIGN KEY(id_poliza) REFERENCES poliza(id_poliza),
	CONSTRAINT fk_id_pago FOREIGN KEY(id_pago) REFERENCES pago(id_pago)
);