select
count(1)
from solicitud_cita
where
fk_usuario = :usuario
and fecha_cita = :fecha_cita