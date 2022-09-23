/* Criando valores de níveis de acesso */

INSERT INTO tb_Access_Level(nameaccess,orderlevel) VALUES ('Recepcionista', 1);
INSERT INTO tb_Access_Level(nameaccess,orderlevel) VALUES ('Medico', 2);
INSERT INTO tb_Access_Level(nameaccess,orderlevel) VALUES ('Paciente', 3);


/* Criando usuários */

INSERT INTO tb_user(cpf,password,access_level) VALUES ('078.627.719-07', 'senha123', 3)
INSERT INTO tb_user(cpf,password,access_level) VALUES ('435.028.350-12', 'senha123', 2)
INSERT INTO tb_user(cpf,password,access_level) VALUES ('115.474.840-55', 'senha123', 2)
INSERT INTO tb_user(cpf,password,access_level) VALUES ('138.917.200-76', 'senha123', 3)
INSERT INTO tb_user(cpf,password,access_level) VALUES ('210.105.310-18', 'senha123', 1)


/* Criando Pacientes */ 

INSERT INTO tb_pacients(name,cel,email,userp_id) VALUES ('Akio Andrei', '+5544988471531', 'akioandrei@email.com',1)
INSERT INTO tb_pacients(name,cel,email,userp_id) VALUES ('Leoni', '+5544997349126', 'Leoni@email.com',4)

/* Criando Recepcionista */

INSERT INTO tb_receptionists(name,userr_id) VALUES ('Sueli Hitomi',5)

/* Criando Médicos */

INSERT INTO tb_doctors(name,spec,userd_id) VALUES ('Francisco Buarque', 'Geral',2)
INSERT INTO tb_doctors(name,spec,userd_id) VALUES ('Flora Beatriz', 'Odontologia',3)

/* Criando UBS */

INSERT INTO tb_ubs(loc,name) VALUES ('Av. Guedener - 1630', 'UBS Aclimação')

/* Criando relacionamentos */

INSERT INTO tb_receptionist_ubs(ubs_id,receptionist_id) VALUES (1,5)
INSERT INTO tb_doctor_ubs(ubs_id,doctor_id) VALUES (1,3)
INSERT INTO tb_doctor_ubs(ubs_id,doctor_id) VALUES (1,2)

/* Criando horários */

INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T08:00:07Z', '2022-10-20T07:00:07Z', 2)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T09:00:07Z', '2022-10-20T08:00:07Z', 2)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T10:00:07Z', '2022-10-20T09:00:07Z', 2)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T11:00:07Z', '2022-10-20T10:00:07Z', 2)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T12:00:07Z', '2022-10-20T11:00:07Z', 2)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T08:00:07Z', '2022-10-20T07:00:07Z', 3)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T09:00:07Z', '2022-10-20T08:00:07Z', 3)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T10:00:07Z', '2022-10-20T09:00:07Z', 3)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T11:00:07Z', '2022-10-20T10:00:07Z', 3)
INSERT INTO tb_schedule(condition,day_schedule,hr_end,hr_ini,doc_schedule) VALUES ('Free', '2022-10-20T07:00:07Z', '2022-10-20T12:00:07Z', '2022-10-20T11:00:07Z', 3)

/* Criando consultas */
INSERT INTO tb_appointment(appointment_status, ubs_id, pacient_userp_id, schedule_id) VALUES (1,1,1,1)
