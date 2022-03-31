select
sc.id,
us.identificacion as identificacion_usuario,
concat_ws(' ', md.nombre, md.primer_apellido, md.segundo_apellido) as medico,
concat_ws(' ', us.nombre, us.primer_apellido, us.segundo_apellido) as usuario,
ep.nombre as especialidad,
ho.hora_inicial as horario_inicio,
ho.hora_final as horario_final,
sc.fecha_solicitud,
sc.fecha_cita,
sc.valor,
sc.aplica_descuento,
ep.valor as valor_base
from solicitud_cita sc
join usuario us
on sc.fk_usuario = us.id
join medico md
on sc.fk_medico = md.id
join especialidad ep
on sc.fk_especialidad = ep.id
join horariodia ho
on sc.fk_horario = ho.id
where fk_usuario = :usuario
