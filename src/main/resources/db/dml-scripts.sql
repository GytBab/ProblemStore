INSERT INTO position (name)
    VALUES
        ('Specialist'),
        ('Engineer'),
        ('Manager');

INSERT INTO employee (employee_uuid, name, surname, email, position_id)
    VALUES
        ('962fad3c-b5a5-4f44-abca-4c5ebc1502a5', 'Gytis', 'Babaitis', 'g.babaitis@ekspla.com', 2),
        ('f8d1adf6-dbbe-47a0-8ce2-2b1e7ca55491', 'Aistis', 'Jurkonis', 'a.jurkonis@ekspla.com', 3),
        ('2a5e1441-0c73-4163-a4a7-fa1cba75a273', 'Mantas', 'Slipkauskas', 'm.slipkauskas@ekspla.com', 2),
        ('ce465807-b5ce-4148-b333-8c1ccf919479', 'Matas', 'Mitrikas', 'm.mitrikas@ekspla.com', 2),
        ('4209ab7e-9695-4f7a-aed4-2c605c39d7ae', 'Kęstutis', 'Snarskis', 'k.snarskis@ekspla.com', 1),
        ('1de796c5-27ba-4e25-88d3-fdf62274ef30', 'Arūnas', 'Paliukas', 'a.paliukas@ekspla.com', 3),
        ('e7ecc54d-37bf-47d4-b245-48461835ca52', 'Andrius', 'Stašaitis', 'a.stasaitis@ekspla.com', 2),
        ('9bb1f0a1-e561-4838-90f1-766bcdf5b71d', 'Julius', 'Butkus', 'j.butkus@ekspla.com', 3),
        ('486fb750-cf2a-47d2-8058-de69cc1d4606', 'Arūnas', 'Dapkus', 'a.dapkus@ekspla.com', 3),
        ('46291268-f42f-457f-8530-5d38a5f12faf', 'Romanas', 'Samuilovas', 'r.samuilovas@ekspla.com', 3),
        ('89425470-3832-4bca-ae97-8285c1be20ff', 'Eglė', 'Krištopavičiūtė-Grybauskė', 'e.kristopaviciute@ekspla.com', 3),
        ('e72d4c70-b301-4020-8a63-ee272db00264', 'Mykolas', 'Lipnickas', 'm.lipnickas@ekspla.com', 3);

INSERT INTO laser_data (team_lead, pulse_length, type, model)
    VALUES
        ('2', 'Nanosecond', 'NLL', 'NL300'),
        ('10', 'Nanosecond', 'HNL', 'NL200'),
        ('8', 'Nanosecond', 'DNL', 'NL230'),
        ('8', 'Picosecond', 'FPL', 'PL2250'),
        ('11', 'Picosecond', 'DPL', 'Atlantic'),
        ('8', 'Picosecond', 'PLD', 'PL2210'),
        ('8', 'Picosecond', 'PLD', 'PL2230'),
        ('12', 'Picosecond', 'FP', 'FPS10'),
        ('12', 'Picosecond', 'FP', 'FPS100'),
        ('12', 'Picosecond', 'FP', 'FPS200'),
        ('12', 'Femtosecond', 'FF', 'FFS100'),
        ('12', 'Femtosecond', 'FF', 'FFS200'),
        ('12', 'Femtosecond', 'FSL', 'FemtoLux 3'),
        ('12', 'Femtosecond', 'FSL', 'FemtoLux 30'),
        ('12', 'Femtosecond', 'FSL', 'FemtoLux 30'),
        ('2', 'Nanosecond Tunable', 'PGL', 'PhotoSonus M'),
        ('2', 'Nanosecond Tunable', 'PGL', 'PhotoSonus X'),
        ('2', 'Nanosecond Tunable', 'PGL', 'PhotoSonus T'),
        ('2', 'Nanosecond Tunable', 'PGL', 'NT340'),
        ('2', 'Nanosecond Tunable', 'PGL', 'NT350'),
        ('2', 'Nanosecond Tunable', 'PGL', 'NT370'),
        ('8', 'Nanosecond Tunable', 'PGD', 'NT230'),
        ('8', 'Nanosecond Tunable', 'PGD', 'NT240'),
        ('8', 'Nanosecond Tunable', 'PGD', 'NT250'),
        ('8', 'Nanosecond Tunable', 'PGD', 'NT260'),
        ('8', 'Picosecond Tunable', 'PLD', 'PT403'),
        ('8', 'Picosecond Tunable', 'PLD', 'PT277-XIR'),
        ('8', 'Picosecond Tunable', 'PLD', 'PT277-IR'),
        ('2', 'Picosecond Tunable', 'PG', 'PGx01'),
        ('2', 'Picosecond Tunable', 'PG', 'PGx11'),
        ('2', 'Picosecond Tunable', 'SFG', 'SFG');

INSERT INTO laser (laser_uuid, model, serial_number, status, start_date, end_date)
    VALUES
        ('423553e6-12e6-48b7-8ecb-50229903464d', 16, 'PGL628', 'Finished', '2023-05-25', '2023-11-15'),
        ('e9cf79ee-01f4-4750-81de-6ac265fd55a8', 5, 'DPL320', 'Manufacturing', '2022-09-02', null),
        ('d2db3ec8-4021-4b09-8210-e37391a67099', 1, 'NLL485', 'Quality Assurance', '2023-06-15', null),
        ('acb1ef66-6a15-47cf-a88e-c3645d61edc1', 2, 'HNL499', 'Orders', '2023-05-25', null),
        ('9535b028-75f6-4b2c-967d-1059c4ad76cc', 22, 'PGD220', 'Finished', '2023-11-25', '2024-01-15'),
        ('95bec6f2-8d7d-41cd-bd7f-51fa19ce21d6', 14, 'FSL163', 'Quality Assurance', '2023-12-01', null),
        ('99cd7e63-5831-4e84-ad1a-39fd466fdef0', 31, 'SFG059', 'Manufacturing', '2023-01-02', null);

INSERT INTO effect (name, parent_id)
    VALUES
        ('Problem Effect', null),
        ('Failed Tests', 1),
        ('Thermo-cycle', 2),
        ('Long-Term', 2),
        ('Vibro', 2),
        ('Cooling', 2),
        ('Humidity', 2),
        ('Spectral', 1),
        ('Incorrect Wavelengths', 8),
        ('Parameters', 1),
        ('Poor Beam Parameters', 10),
        ('Poor Stability', 10),
        ('Low Energy', 10),
        ('Electronics', 1),
        ('Synchronization', 14);

INSERT INTO cause (name, parent_id)
    VALUES
        ('Problem Cause', null),
        ('Optics', 1),
        ('Oscillator', 2),
        ('Pockels Cell', 3),
        ('Coating', 4),
        ('Laser Induced damage', 4),
        ('Dust Build Up', 4),
        ('End Mirror', 3),
        ('Coating', 7),
        ('Laser Induced damage', 7),
        ('Dust Build Up', 7),
        ('Output Mirror', 3),
        ('Coating', 12),
        ('Laser Induced damage', 12),
        ('Dust Build Up', 12),
        ('Laser', 2),
        ('Crystal', 16),
        ('Coating', 17),
        ('Laser Induced damage', 17),
        ('Dust Build Up', 17),
        ('Mirror', 16),
        ('Coating', 21),
        ('Laser Induced damage', 21),
        ('Dust Build Up', 21),
        ('Beam Splitter', 16),
        ('Coating', 25),
        ('Laser Induced damage', 25),
        ('Dust Build Up', 25),
        ('Phase Plate', 16),
        ('Coating', 29),
        ('Laser Induced damage', 29),
        ('Dust Build Up', 29),
        ('Electronics', 1),
        ('Laser', 33),
        ('Power Supply', 33),
        ('Mechanics', 1),
        ('Inside', 36),
        ('Exterior', 36),
        ('Software', 1),
        ('Laser', 39),
        ('Motors', 39),
        ('Engineer Fault', 1);

INSERT INTO problem (problem_uuid, laser_id, effect_id, cause_id, solution, start_time, end_time,
                          entry_date, part_no, comment, photos)
    VALUES
        ('910879c5-caa6-421b-81a7-9edf9e20207d', 1, 6, 2, 'Forgot to turn water on', null, null, '2023-12-12', 'xnt-042.05.001', '', null),
        ('57d69d83-ff99-461c-ba9b-9e7bd647dd4b', 5, 9, 10, 'Cleaning', null, null, '2024-01-18', 'kld-052.02.001', '', null),
        ('cbd54fca-ddda-434c-8750-a3cc389e86ac', 7, 8, 9, 'Replacing', null, null, '2022-08-25', 'xgt-042.04.012', '', null),
        ('bc1f3c58-c2fe-4d18-90db-7fb93bb67b81', 2, 9, 15, 'Removing', null, null, '2022-12-09', 'ffs-042.05.020', '', null),
        ('83a53c0a-8a7a-4993-b81e-e894ace17eab', 3, 10, 3, 'Remeasuring', null, null, '2023-02-02', 'ntf-042.04.005', '', null),
        ('7628e975-8f40-4430-a359-4e45c0a9ef72', 2, 15, 15, 'Cleaning', null, null, '2023-12-17', 'xnt-042.05.002', '', null),
        ('87f40f62-6b06-4b63-a4bd-c7c96f63f82f', 4, 12, 9, 'Throwing away', null, null, '2021-08-30', 'mly-052.05.001', '', null);

INSERT INTO laser_engineer (laser_id, employee_id)
    VALUES
        (1, 1),
        (2, 6),
        (5, 11),
        (2, 5),
        (4, 3);