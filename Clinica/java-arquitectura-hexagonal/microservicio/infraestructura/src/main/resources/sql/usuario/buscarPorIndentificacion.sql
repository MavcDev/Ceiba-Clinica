select
id,
identificacion,
concat_ws(' ', nombre, primer_apellido, segundo_apellido) as nombre_completo,
fecha_nacimiento,
fecha_creacion
from usuario
where identificacion = :identificacion