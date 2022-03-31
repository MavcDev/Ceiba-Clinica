insert into especialidad (nombre, valor) values ('General', 50000);
insert into especialidad (nombre, valor) values ('Cardiología', 150000);
insert into especialidad (nombre, valor) values ('Neurología', 200000);
insert into especialidad (nombre, valor) values ('Oncología médica', 300000);
insert into especialidad (nombre, valor) values ('Oncología radioterápica', 350000);
insert into especialidad (nombre, valor) values ('Pediatría', 90000);
insert into especialidad (nombre, valor) values ('Psiquiatría', 100000);
insert into especialidad (nombre, valor) values ('Reumatología', 130000);
insert into especialidad (nombre, valor) values ('Alergología', 80000);
insert into especialidad (nombre, valor) values ('Geriatría', 60000);

insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1145822447', 'Juan Andres', 'Perez', null, 1, '1990-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1115585857', 'Carlos', 'Beltran', 'Rojas', 1, '1990-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1117554548', 'Yadir Orlando', 'Cuervo', null, 2, '1989-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1875563754', 'Wilmer Antonio', 'Arteaga', null, 2, '1985-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1188989547', 'Eliana Maria', 'Velasquez', 'Suarez', 3, '1985-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1125475257', 'Emma Victroia', 'Suarez', 'Castaño', 4, '1985-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1144585857', 'Diana', 'Cuenca', 'Perez', 5, '1975-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('40564899', 'Cristian', 'Betancur', 'Niño', 6, '1985-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('10565585', 'Liliana', 'Mora', null, 7, '1985-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1152121252', 'Cesar', 'Augusto', 'Salinas', 8, '1975-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1485855252', 'Linda Maria', 'Agudelo', 'Zapata', 9, '1965-03-25');
insert into medico (identificacion, nombre, primer_apellido, segundo_apellido, fk_especialidad, fecha_nacimiento) values ('1222455258', 'Pedro', 'Ramirez', 'Sanchez', 9, '1985-12-24');

insert into horariodia (hora_inicial, hora_final) values ('07:00 AM', '07:30 AM');
insert into horariodia (hora_inicial, hora_final) values ('07:31 AM', '08:01 AM');
insert into horariodia (hora_inicial, hora_final) values ('08:02 AM', '08:32 AM');
insert into horariodia (hora_inicial, hora_final) values ('08:33 AM', '09:03 AM');
insert into horariodia (hora_inicial, hora_final) values ('09:04 AM', '09:34 AM');
insert into horariodia (hora_inicial, hora_final) values ('09:35 AM', '10:05 AM');
insert into horariodia (hora_inicial, hora_final) values ('10:06 AM', '10:36 AM');
insert into horariodia (hora_inicial, hora_final) values ('10:37 AM', '11:07 AM');
insert into horariodia (hora_inicial, hora_final) values ('11:08 AM', '11:38 AM');
insert into horariodia (hora_inicial, hora_final) values ('11:39 AM', '12:09 PM');
insert into horariodia (hora_inicial, hora_final) values ('12:10 PM', '12:40 PM');
insert into horariodia (hora_inicial, hora_final) values ('12:41 PM', '01:11 PM');
insert into horariodia (hora_inicial, hora_final) values ('01:12 PM', '01:42 PM');
insert into horariodia (hora_inicial, hora_final) values ('01:43 PM', '02:13 PM');
insert into horariodia (hora_inicial, hora_final) values ('02:14 PM', '02:44 PM');
insert into horariodia (hora_inicial, hora_final) values ('02:45 PM', '03:15 PM');
insert into horariodia (hora_inicial, hora_final) values ('03:16 PM', '03:46 PM');
insert into horariodia (hora_inicial, hora_final) values ('03:47 PM', '04:17 PM');
insert into horariodia (hora_inicial, hora_final) values ('04:18 PM', '04:48 PM');


