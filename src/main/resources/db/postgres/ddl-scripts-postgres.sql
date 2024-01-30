
CREATE TABLE IF NOT EXISTS effect (
                id SERIAL PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                parent_id INTEGER
);
COMMENT ON TABLE effect IS 'Table for storing possible problem effects on the laser occurring during laser manufacturing process
(Adjacency list model)';


CREATE SEQUENCE cause_id_seq;
CREATE TABLE cause (
                id INTEGER NOT NULL DEFAULT nextval('cause_id_seq'),
                name VARCHAR(50) NOT NULL,
                parent_id INTEGER,
                CONSTRAINT cause_pk PRIMARY KEY (id)
);
COMMENT ON TABLE cause IS 'Table for storing possible problem effect causes occurring during laser manufacturing process
(Adjacency list model)';

ALTER SEQUENCE cause_id_seq OWNED BY cause.id;


CREATE SEQUENCE position_id_seq;
CREATE TABLE position (
                id INTEGER NOT NULL DEFAULT nextval('position_id_seq'),
                name VARCHAR(50) NOT NULL,
                CONSTRAINT position_pk PRIMARY KEY (id)
);
COMMENT ON TABLE position IS 'Table for possible work positions';

ALTER SEQUENCE position_id_seq OWNED BY position.id;


CREATE SEQUENCE employee_id_seq;
CREATE TABLE employee (
                id BIGINT NOT NULL DEFAULT nextval('employee_id_seq'),
                employee_uuid VARCHAR NOT NULL,
                name VARCHAR(50) NOT NULL,
                surname VARCHAR(50) NOT NULL,
                email VARCHAR(50) NOT NULL,
                position_id INTEGER NOT NULL,
                CONSTRAINT employee_pk PRIMARY KEY (id)
);
COMMENT ON TABLE employee IS 'Table for storing information about users/employees';

ALTER SEQUENCE employee_id_seq OWNED BY employee.id;

CREATE UNIQUE INDEX employee_idx
 ON employee
 ( employee_uuid );


CREATE SEQUENCE laser_data_id_seq;
CREATE TABLE laser_data (
                id INTEGER NOT NULL DEFAULT nextval('laser_data_id_seq'),
                team_lead BIGINT NOT NULL,
                pulse_length VARCHAR(30) NOT NULL,
                type VARCHAR(10) NOT NULL,
                model VARCHAR(30) NOT NULL,
                CONSTRAINT laser_data_pk PRIMARY KEY (id)
);
COMMENT ON TABLE laser_data IS 'This table stores general information about products(lasers) offered by the user company';

ALTER SEQUENCE laser_data_id_seq OWNED BY laser_data.id;


CREATE SEQUENCE laser_id_seq;
CREATE TABLE laser (
                id BIGINT NOT NULL DEFAULT nextval('laser_id_seq'),
                laser_uuid UUID NOT NULL,
                model INTEGER NOT NULL,
                serial_number VARCHAR(50) NOT NULL,
                status VARCHAR(20) NOT NULL,
                start_date DATE,
                end_date DATE,
                CONSTRAINT laser_pk PRIMARY KEY (id)
);
COMMENT ON TABLE laser IS 'Table for storing information throughout the manufacturing process of a specific laser';

ALTER SEQUENCE laser_id_seq OWNED BY laser.id;

CREATE UNIQUE INDEX laser_idx
 ON laser
 ( serial_number );


CREATE TABLE problem (
                id BIGINT NOT NULL,
                problem_uuid UUID NOT NULL,
                laser_id BIGINT NOT NULL,
                effect_id INTEGER NOT NULL,
                cause_id INTEGER NOT NULL,
                solution TEXT NOT NULL,
                start_time TIME,
                end_time TIME NOT NULL,
                entry_date DATE NOT NULL,
                part_no VARCHAR(100),
                comment TEXT,
                photos BYTEA,
                CONSTRAINT problem_pk PRIMARY KEY (id)
);
COMMENT ON TABLE problem IS 'This table stores information about an encountered problem during manufacturing';


CREATE TABLE laser_engineer (
                id BIGINT NOT NULL,
                laser_id BIGINT NOT NULL,
                employee_id BIGINT NOT NULL,
                CONSTRAINT laser_engineer_pk PRIMARY KEY (id)
);


CREATE UNIQUE INDEX laser_engineer_idx
 ON laser_engineer
 ( laser_id, employee_id );

ALTER TABLE problem ADD CONSTRAINT effect_problem_fk
FOREIGN KEY (effect_id)
REFERENCES effect (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE problem ADD CONSTRAINT cause_problem_fk
FOREIGN KEY (cause_id)
REFERENCES cause (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE employee ADD CONSTRAINT position_employee_fk
FOREIGN KEY (position_id)
REFERENCES position (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE laser_data ADD CONSTRAINT employee_laser_data_fk
FOREIGN KEY (team_lead)
REFERENCES employee (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE laser_engineer ADD CONSTRAINT employee_laser_engineer_fk
FOREIGN KEY (employee_id)
REFERENCES employee (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE laser ADD CONSTRAINT laser_data_laser_fk
FOREIGN KEY (model)
REFERENCES laser_data (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE laser_engineer ADD CONSTRAINT laser_laser_engineer_fk
FOREIGN KEY (laser_id)
REFERENCES laser (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE problem ADD CONSTRAINT laser_problem_fk
FOREIGN KEY (laser_id)
REFERENCES laser (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
