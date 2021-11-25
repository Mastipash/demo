insert into nomenclature (code, description, price)
values ('46022','Бенгальские огни', 200.00);
insert into nomenclature (code, description, price)
values ('46025','LED гирлянда 240 ламп', 400.00);
insert into nomenclature (code, description, price)
values ('46025','Новогодняя шапка', 100.00);
insert into nomenclature (code, description, price)
values ('46025','Ёлочная игрушка шар', 150.00);

insert into storage (name, address, is_pvz)
values ('Основной склад', 'Проспект Мира д.1', false);
insert into storage (name, address, is_pvz)
values ('ПВЗ №1', 'Проспект Мира д.2', true);
insert into storage (name, address, is_pvz)
values ('ПВЗ №2', 'Проспект Мира д.3', true);

insert into doc_status (id, name)
values (1, 'Создан');
insert into doc_status (id, name)
values (2, 'Доставлен в ПВЗ');
insert into doc_status (id, name)
values (3, 'Выдан');
insert into doc_status (id, name)
values (4, 'Отменен');

insert into product (dt_start, dt_end, nomenclature_id, cnt, storage_id)
values (current_timestamp, current_timestamp, 1, 10000, 1);
insert into product (dt_start, dt_end, nomenclature_id, cnt, storage_id)
values (current_timestamp, current_timestamp, 2, 10000, 1);
insert into product (dt_start, dt_end, nomenclature_id, cnt, storage_id)
values (current_timestamp, current_timestamp, 3, 10000, 1);
insert into product (dt_start, dt_end, nomenclature_id, cnt, storage_id)
values (current_timestamp, current_timestamp, 4, 10000, 1);

insert into product (dt_start, dt_end, nomenclature_id, cnt, storage_id)
values (current_timestamp, current_timestamp, 1, 5, 3);

insert into document (doc_num, nomenclature_id, cnt, status_id, storage_id)
values ('заказ №1', 1, 4, 1, 2);

insert into document (doc_num, nomenclature_id, cnt, status_id, storage_id)
values ('заказ №2', 1, 20, 3, 3);

insert into emp_role (role) values ('Продавец');
insert into emp_role (role) values ('Сотрудник склада');
insert into emp_role (role) values ('Сотрудник ПВЗ');

insert into employee (fio, role_id) VALUES ('Иванов Иван Иванович',1);
insert into employee (fio, role_id) VALUES ('Смирнов Сергей Николаевич',2);
insert into employee (fio, role_id) VALUES ('Петров Александр Сергеевич',3);





