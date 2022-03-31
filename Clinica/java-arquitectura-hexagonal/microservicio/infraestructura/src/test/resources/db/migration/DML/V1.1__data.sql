insert into usuario (
id,
identificacion,
nombre,
primer_apellido,
segundo_apellido,
fecha_nacimiento,
fecha_creacion
) values (
1,
'1117522443',
'Juan Manuel',
'Velasquez',
'Rivera',
'2020-12-21',
'2022-03-29 08:03:22'
);

insert into solicitud_cita (
id,
fk_medico,
fk_usuario,
fk_especialidad,
fk_horario,
fecha_solicitud,
fecha_cita,
valor,
aplica_descuento
) values (
1,
1,
1,
1,
1,
'2022-03-30 08:03:22',
'2022-04-12',
500000,
TRUE
);