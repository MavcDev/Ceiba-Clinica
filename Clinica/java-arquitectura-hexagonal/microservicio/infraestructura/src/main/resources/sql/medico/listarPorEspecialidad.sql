select
id,
concat_ws(' ', nombre, primer_apellido, segundo_apellido) as nombre_completo
from medico
where fk_especialidad = :especialidad