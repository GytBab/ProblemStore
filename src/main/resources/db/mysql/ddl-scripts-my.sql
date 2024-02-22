
CREATE TABLE IF NOT EXISTS effect (
                id INT AUTO_INCREMENT NOT NULL,
                name VARCHAR(50) NOT NULL,
                parent_id INT,
                PRIMARY KEY (id),

                FOREIGN KEY (parent_id)
                REFERENCES effect(id)
                ON UPDATE NO ACTION
                ON DELETE NO ACTION
);

ALTER TABLE effect COMMENT 'Table for storing possible problem effects on the laser occurring during laser manufacturing process
(Adjacency list model)';


CREATE TABLE IF NOT EXISTS cause (
                id INT AUTO_INCREMENT NOT NULL,
                name VARCHAR(50) NOT NULL,
                parent_id INT,
                PRIMARY KEY (id),

                FOREIGN KEY (parent_id)
                REFERENCES cause(id)
                ON UPDATE NO ACTION
                ON DELETE NO ACTION
);

ALTER TABLE cause COMMENT 'Table for storing possible problem effect causes occurring during laser manufacturing process
(Adjacency list model)';


CREATE TABLE IF NOT EXISTS position (
                id INT AUTO_INCREMENT NOT NULL,
                name VARCHAR(50) NOT NULL,
                PRIMARY KEY (id)
);

ALTER TABLE position COMMENT 'Table for possible work positions';


CREATE TABLE IF NOT EXISTS employee (
                id BIGINT AUTO_INCREMENT NOT NULL,
                employee_uuid BINARY(16) NOT NULL,
                name VARCHAR(50) NOT NULL,
                surname VARCHAR(50) NOT NULL,
                email VARCHAR(50) NOT NULL,
                password VARCHAR(100) NOT NULL,
                position_id INT NOT NULL,
                PRIMARY KEY (id),
                INDEX employee_idx (`employee_uuid`),

                FOREIGN KEY (position_id)
                REFERENCES position (id)
                ON UPDATE NO ACTION
                ON DELETE NO ACTION
);

ALTER TABLE employee COMMENT 'Table for storing information about users/employees';


CREATE TABLE IF NOT EXISTS laser_data (
                id INT AUTO_INCREMENT NOT NULL,
                team_lead BIGINT NOT NULL,
                pulse_length VARCHAR(30) NOT NULL,
                type VARCHAR(10) NOT NULL,
                model VARCHAR(30) NOT NULL,
                PRIMARY KEY (id),

                FOREIGN KEY (team_lead)
                REFERENCES employee (id)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION
);

ALTER TABLE laser_data COMMENT 'This table stores general information about products(lasers) offered by the user company';


CREATE TABLE IF NOT EXISTS laser (
                id BIGINT AUTO_INCREMENT NOT NULL,
                laser_uuid BINARY(16) NOT NULL,
                model INT NOT NULL,
                serial_number VARCHAR(50) NOT NULL,
                status VARCHAR(20) NOT NULL,
                start_date DATE,
                end_date DATE,
                PRIMARY KEY (id),
                INDEX laser_idx (`laser_uuid`),

                FOREIGN KEY (model)
                REFERENCES laser_data (id)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION
);

ALTER TABLE laser COMMENT 'Table for storing information throughout the manufacturing process of a specific laser';


CREATE TABLE IF NOT EXISTS problem (
                id BIGINT AUTO_INCREMENT NOT NULL,
                problem_uuid BINARY(16) NOT NULL,
                laser_id BIGINT NOT NULL,
                effect_id INT NOT NULL,
                cause_id INT NOT NULL,
                solution TEXT NOT NULL,
                start_time TIME,
                end_time TIME,
                entry_date DATE,
                part_no VARCHAR(100),
                comment TEXT,
                photos LONGBLOB,
                PRIMARY KEY (id),
                INDEX problem_idx (`problem_uuid`),

                FOREIGN KEY (effect_id)
                REFERENCES effect(id)
                ON UPDATE NO ACTION
                ON DELETE NO ACTION,

                FOREIGN KEY (cause_id)
                REFERENCES cause(id)
                ON UPDATE NO ACTION
                ON DELETE NO ACTION,

                FOREIGN KEY (laser_id)
                REFERENCES laser (id)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION
);

ALTER TABLE problem COMMENT 'This table stores information about an encountered problem during manufacturing';


CREATE TABLE IF NOT EXISTS laser_engineer (
                id BIGINT AUTO_INCREMENT NOT NULL,
                laser_id BIGINT NOT NULL,
                employee_id BIGINT NOT NULL,
                PRIMARY KEY (id),
                INDEX laser_engineer_idx1 (`laser_id`),
                INDEX laser_engineer_idx2 (`employee_id`),

                FOREIGN KEY (employee_id)
                REFERENCES employee (id)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION,

                FOREIGN KEY (laser_id)
                REFERENCES laser (id)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION
);


CREATE TABLE IF NOT EXISTS authority (
                id          BIGINT AUTO_INCREMENT NOT NULL,
                name        VARCHAR(100) NOT NULL,
                description VARCHAR(2000),
                PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS employee_authorities (
                employee_id  BIGINT,
                authorities_id BIGINT,

                FOREIGN KEY (employee_id)
                REFERENCES employee (id)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION,

                FOREIGN KEY (authorities_id)
                REFERENCES authority (id)
                ON DELETE NO ACTION
                ON UPDATE NO ACTION
);
