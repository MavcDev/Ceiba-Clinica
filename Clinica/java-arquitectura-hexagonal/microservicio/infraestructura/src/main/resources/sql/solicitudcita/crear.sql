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
:id,
:fk_medico,
:fk_usuario,
:fk_especialidad,
:fk_horario,
:fecha_solicitud,
:fecha_cita,
:valor,
:aplica_descuento
)