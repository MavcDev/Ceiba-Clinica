create table usuario (
    id int(11) not null auto_increment,
    identificacion varchar(11) not null,
    nombre varchar(50) not null,
    primer_apellido varchar(50) not null,
    segundo_apellido varchar(50),
    fecha_nacimiento date not null,
    fecha_creacion datetime not null,
    primary key (id)
);

create table medico(
    id int(11) not null auto_increment,
    identificacion varchar(11) not null,
    nombre varchar(50) not null,
    primer_apellido varchar(50) not null,
    segundo_apellido varchar(50),
    fk_especialidad int(11) not null,
    fecha_nacimiento date not null,
    primary key (id)
);

create table especialidad(
    id int(11) not null auto_increment,
    nombre varchar(50) not null,
    valor numeric not null,
    primary key (id)
);

create table horariodia(
    id int(11) not null auto_increment,
    hora_inicial varchar(50) not null,
    hora_final varchar(50) not null,
    primary key (id)
);

create table solicitud_cita(
    id int(11) not null auto_increment,
    fk_medico int(11) not null,
    fk_usuario int(11) not null,
    fk_especialidad int(11) not null,
    fk_horario int(11) not null,
    fecha_solicitud datetime not null,
    fecha_cita date not null,
    valor numeric not null,
    aplica_descuento boolean not null,
    primary key (id)
);