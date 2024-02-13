insert into brand(name) values ('Lada'), ('Toyota'), ('Porsche'), ('ГАЗ');

insert into model(brand_id, name) values
    (1, 'Granta'),
    (1, 'Priora'),
    (1, 'Vesta'),
    (2, 'Camry'),
    (2, 'Land Cruiser'),
    (2, 'Corolla'),
    (3, '911 carrera'),
    (3, 'Cayman'),
    (3, 'Panamera'),
    (4, 'GAZ-24'),
    (4, 'GAZ-3307'),
    (4, 'GAZ-3308');

insert into configuration(model_id, name, is_new, count, specification, price) values
    (3, 'basic', true, 3, '{"color": "white", "hp": 99, "mileage": 19}'::jsonb, 1600000),
    (1, 'premium', false, 1, '{"color": "red", "hp": 101, "mileage": 78012}'::jsonb, 900000),
    (7, 'chill', false, 1, '{"color": "blue", "hp": 289, "mileage": 231044}'::jsonb, 200000),
    (3, 'basic', false, 1, '{"color": "black", "hp": 99, "mileage": 100000}'::jsonb, 1100000);

insert into request(configuration_id, count, client_name, client_email, client_phone, status) VALUES
    (1, 1, 'Иван', '1@1.1', '1111111111', 'created'),
    (1, 1, 'Fedor', '2@2.2', '2222222222', 'in_progress'),
    (12, 1, 'Petr', '3@3.3', '3333333333', 'completed'),
    (12, 1, 'Vlad', '4@4.4', '4444444444', 'canceled');

insert into manager(name, email, phone) values 
    ('manager1', '1@1.1', '1111111111'),
    ('manager2', '2@2.2', '2222222222'),
    ('manager3', '3@3.3', '3333333333');