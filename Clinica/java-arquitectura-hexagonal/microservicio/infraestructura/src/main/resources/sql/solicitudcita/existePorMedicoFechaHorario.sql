select
count(1)
from solicitud_cita
where
fk_medico = :medico
and fk_horario = :horario
and fecha_cita = :fecha_cita

