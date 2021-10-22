insert into public.users (id, name, surname, phone, passport_series, passport_number, email, driver_license_number, login, password, gender)
values  (1, 'Nick', 'Eagle', 1441234, 'TR', 1241234, 'qwerqw@mnail.com>', 53456345, 'nick', '123456', 'NOT_SELECTED'),
        (2, 'Dima', 'Qwert', 345678, 'WO', 7457457, 'bnbnbn@mail.ru', 54645645, 'dima', '12345678', 'NOT_SELECTED'),
        (6, 'sasha', 'wqwewe', 23231423423, 'rf', 23423, 'string@dbdb', 3245234, 'sasha1', '123', 'NOT_SELECTED'),
        (7, 'sasha', 'wqwewe', 23231423423, 'rf', 23423, 'string@dbdb', 3245234, 'sasha1', '123', 'NOT_SELECTED'),
        (8, 'sasha', 'wqwewe', 23231423423, 'rf', 23423, 'string@dbdb', 3245234, 'sasha1', '123', 'MALE'),
        (9, 'sasha', 'wqwewe', 23231423423, 'rf', 23423, 'string@dbdb', 3245234, 'sasha1', '123', 'FEMALE'),
        (10, 'Dima', 'wqwewe', 23231423423, 'rf', 23423, 'string@dbdb', 3245234, 'qwert', '111', 'MALE'),
        (11, 'Dima', 'wqwewe', 23231423423, 'rf', 23423, 'string@dbdb', 3245234, 'dim', '222', 'MALE');


insert into public.orders (id, received_date, return_date, order_status, user_id)
values  (1, '2021-10-08 21:00:04.000000', '2021-10-09 21:00:11.000000', 'NOT_CONFIRMED', 9),
        (2, '2021-10-14 18:26:43.000000', '2021-10-15 18:26:51.000000', 'NOT_CONFIRMED', 9),
        (3, '2021-10-14 18:26:43.000000', '2021-10-15 18:26:51.000000', 'NOT_CONFIRMED', 8),
        (4, '2021-10-14 18:26:43.000000', '2021-10-15 18:26:51.000000', 'NOT_CONFIRMED', 8);





insert into public.cars (id, name_car, model, birthday_car, color, v_motor, power, transmission, cost_per_day, car_status)
values  (1, 'Mercedes', 'CLK', '2019-10-11 10:06:34.000000', 'black', 320, 200, 'AUTO', 60, 'AVAILABLE'),
        (2, 'Mercedes', 'CLK', '2015-10-11 10:06:34.000000', 'white', 200, 150, 'MECHANICAL', 50, 'AVAILABLE'),
        (3, 'Mercedes', 'CLK', '2015-10-11 10:07:34.000000', 'green', 150, 200, 'AUTO', 60, 'AVAILABLE'),
        (4, 'Mercedes', 'CLK', '2017-10-11 10:06:34.000000', 'white', 300, 200, 'MECHANICAL', 50, 'AVAILABLE'),
        (5, 'Mercedes', 'CLK', '2017-10-11 10:06:34.000000', 'black', 320, 200, 'AUTO', 60, 'AVAILABLE');


insert into public.contracts (id, number_contract, payment_date, total_price, contract_status, order_id)
values  (1, 1, '2021-10-12 19:46:03.000000', 30, 'AWAITING_PAYMENT', 1),
        (3, 2, '2021-10-12 19:46:03.000000', 30, 'AWAITING_PAYMENT', 1);



insert into public.roles (id, role_name)
values  (1, 'ROLE_ADMIN'),
        (2, 'ROLE_USER'),
        (3, 'ROLE_MANAGER'),
        (4, 'ROLE_TEST');

insert into public.user_roles (id, role_id, users_id)
values  (1, 1, 1),
        (2, 2, 2),
        (3, 3, 7),
        (4, 2, 7),
        (5, 1, 7),
        (6, 3, 8),
        (7, 2, 8),
        (8, 1, 8),
        (9, 3, 9),
        (10, 2, 9),
        (11, 1, 9),
        (12, 3, 10),
        (13, 2, 10),
        (14, 1, 10),
        (15, 3, 11),
        (16, 2, 11),
        (17, 1, 11),
        (18, 4, 1),
        (19, 4, 8),
        (20, 3, 2),
        (21, 2, 2);


