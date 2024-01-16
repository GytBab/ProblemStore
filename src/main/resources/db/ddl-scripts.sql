
CREATE TABLE problem_effect (
    id IDENTITY NOT NULL,
    name VARCHAR(50) NOT NULL,
    parent_id INTEGER,
    CONSTRAINT problem_effect_pk PRIMARY KEY (id)
);
COMMENT ON TABLE problem_effect IS 'Table for storing possible problem effects on the laser occurring during laser manufacturing process
(Adjacency list model)';


CREATE TABLE problem_cause (
    id IDENTITY NOT NULL,
    name VARCHAR(50) NOT NULL,
    parent_id INTEGER,
    CONSTRAINT problem_cause_pk PRIMARY KEY (id)
);
COMMENT ON TABLE problem_cause IS 'Table for storing possible problem effect causes occurring during laser manufacturing process
(Adjacency list model)';


CREATE TABLE position (
    id IDENTITY NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT position_pk PRIMARY KEY (id)
);
COMMENT ON TABLE position IS 'Table for possible work positions';


CREATE TABLE employee (
    id IDENTITY NOT NULL,
    employee_uuid UUID NOT NULL,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    position_id INTEGER NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (id)
);
COMMENT ON TABLE employee IS 'Table for storing information about users/employees';


CREATE UNIQUE INDEX employee_idx
    ON employee
        ( employee_uuid );

CREATE TABLE laser_data (
    id IDENTITY NOT NULL,
    team_lead BIGINT NOT NULL,
    pulse_length VARCHAR(30) NOT NULL,
    type VARCHAR(10) NOT NULL,
    model VARCHAR(30) NOT NULL,
    CONSTRAINT laser_data_pk PRIMARY KEY (id)
);
COMMENT ON TABLE laser_data IS 'This table stores general information about products(lasers) offered by the user company';


CREATE TABLE laser_record (
    id IDENTITY NOT NULL,
    model INTEGER NOT NULL,
    serial_number VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    start_date DATE,
    end_date DATE,
    CONSTRAINT laser_record_pk PRIMARY KEY (id)
);
COMMENT ON TABLE laser_record IS 'Table for storing information throughout the manufacturing process of a specific laser';


CREATE UNIQUE INDEX laser_record_idx
    ON laser_record
        ( serial_number );

CREATE TABLE problem_record (
    id IDENTITY NOT NULL,
    laser_record_id BIGINT NOT NULL,
    problem_effect_id INTEGER,
    problem_cause_id INTEGER,
    solution VARCHAR NOT NULL,
    start_time TIME,
    end_time TIME,
    entry_date DATE NOT NULL,
    part_no VARCHAR(100),
    comment VARCHAR,
    photos LONGVARBINARY,
    CONSTRAINT problem_record_pk PRIMARY KEY (id)
);
COMMENT ON TABLE problem_record IS 'This table stores information about an encountered problem during manufacturing';


CREATE TABLE laser_engineer (
    id IDENTITY NOT NULL,
    laser_record_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    CONSTRAINT laser_engineer_pk PRIMARY KEY (id)
);


CREATE UNIQUE INDEX laser_engineer_idx
    ON laser_engineer
        ( laser_record_id, employee_id );

ALTER TABLE problem_effect ADD CONSTRAINT problem_effect_problem_effect_fk
    FOREIGN KEY (parent_id)
        REFERENCES problem_effect (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE problem_cause ADD CONSTRAINT problem_cause_problem_cause_fk
    FOREIGN KEY (parent_id)
        REFERENCES problem_cause (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE problem_record ADD CONSTRAINT problem_effect_problem_record_fk
    FOREIGN KEY (problem_effect_id)
        REFERENCES problem_effect (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE problem_record ADD CONSTRAINT problem_cause_problem_record_fk
    FOREIGN KEY (problem_cause_id)
        REFERENCES problem_cause (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE employee ADD CONSTRAINT position_employee_fk
    FOREIGN KEY (position_id)
        REFERENCES position (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE laser_data ADD CONSTRAINT employee_laser_data_fk
    FOREIGN KEY (team_lead)
        REFERENCES employee (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE laser_engineer ADD CONSTRAINT employee_laser_engineer_fk
    FOREIGN KEY (employee_id)
        REFERENCES employee (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE laser_record ADD CONSTRAINT laser_data_laser_record_fk
    FOREIGN KEY (model)
        REFERENCES laser_data (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE laser_engineer ADD CONSTRAINT laser_record_laser_engineer_fk
    FOREIGN KEY (laser_record_id)
        REFERENCES laser_record (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE problem_record ADD CONSTRAINT laser_record_problem_record_fk
    FOREIGN KEY (laser_record_id)
        REFERENCES laser_record (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;