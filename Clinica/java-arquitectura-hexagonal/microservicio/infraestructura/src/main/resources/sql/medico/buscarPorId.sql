select
id,
identificacion,
nombre,
primer_apellido,
segundo_apellido,
fk_especialidad,
fecha_nacimiento
from medico
where id = :id