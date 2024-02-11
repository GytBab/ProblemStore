
CREATE TABLE effect (
    id IDENTITY NOT NULL,
    name VARCHAR(50) NOT NULL,
    parent_id INTEGER,
    CONSTRAINT effect_pk PRIMARY KEY (id)
);
COMMENT ON TABLE effect IS 'Table for storing possible problem effects on the laser occurring during laser manufacturing process
(Adjacency list model)';


CREATE TABLE cause (
    id IDENTITY NOT NULL,
    name VARCHAR(50) NOT NULL,
    parent_id INTEGER,
    CONSTRAINT cause_pk PRIMARY KEY (id)
);
COMMENT ON TABLE cause IS 'Table for storing possible problem effect causes occurring during laser manufacturing process
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
    password VARCHAR(100) NOT NULL,
    position_id INTEGER NOT NULL,
    CONSTRAINT employee_pk PRIMARY KEY (id)
);
COMMENT ON TABLE employee IS 'Table for storing information about users/employees';

CREATE UNIQUE INDEX employee_idx
    ON employee
        ( employee_uuid );
CREATE UNIQUE INDEX employee_email_idx
    ON employee
        ( email );


CREATE TABLE laser_data (
    id IDENTITY NOT NULL,
    team_lead BIGINT NOT NULL,
    pulse_length VARCHAR(30) NOT NULL,
    type VARCHAR(10) NOT NULL,
    model VARCHAR(30) NOT NULL,
    CONSTRAINT laser_data_pk PRIMARY KEY (id)
);
COMMENT ON TABLE laser_data IS 'This table stores general information about products(lasers) offered by the user company';


CREATE TABLE laser (
    id IDENTITY NOT NULL,
    laser_uuid UUID NOT NULL,
    model INTEGER NOT NULL,
    serial_number VARCHAR(50) NOT NULL,
    status VARCHAR(20) NOT NULL,
    start_date DATE,
    end_date DATE,
    CONSTRAINT laser_pk PRIMARY KEY (id)
);
COMMENT ON TABLE laser IS 'Table for storing information throughout the manufacturing process of a specific laser';

CREATE UNIQUE INDEX laser_idx
    ON laser
        ( serial_number, laser_uuid );


CREATE TABLE problem (
    id IDENTITY NOT NULL,
    problem_uuid UUID NOT NULL,
    laser_id BIGINT NOT NULL,
    effect_id INTEGER,
    cause_id INTEGER,
    solution VARCHAR NOT NULL,
    start_time TIME,
    end_time TIME,
    entry_date DATE NOT NULL,
    part_no VARCHAR(100),
    comment VARCHAR,
    photos LONGVARBINARY,
    CONSTRAINT problem_pk PRIMARY KEY (id)
);
COMMENT ON TABLE problem IS 'This table stores information about an encountered problem during manufacturing';

CREATE UNIQUE INDEX problem_idx
    ON problem
        ( problem_uuid );


CREATE TABLE laser_engineer (
    id IDENTITY NOT NULL,
    laser_id BIGINT NOT NULL,
    employee_id BIGINT NOT NULL,
    CONSTRAINT laser_engineer_pk PRIMARY KEY (id)
);

CREATE UNIQUE INDEX laser_engineer_idx
    ON laser_engineer
        ( laser_id, employee_id );


CREATE TABLE authority (
    id          BIGINT primary key auto_increment,
    name        VARCHAR(100) NOT NULL,
    description VARCHAR(2000)
);

CREATE UNIQUE INDEX authority_idx
    ON authority
        ( name );


CREATE TABLE employee_authorities (
    employee_id BIGINT,
    authorities_id BIGINT
);

CREATE UNIQUE INDEX employee_authorities_idx
    ON employee_authorities
    (employee_id, authorities_id);


ALTER TABLE effect ADD CONSTRAINT effect_effect_fk
    FOREIGN KEY (parent_id)
        REFERENCES effect (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE cause ADD CONSTRAINT cause_cause_fk
    FOREIGN KEY (parent_id)
        REFERENCES cause (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE problem ADD CONSTRAINT effect_problem_fk
    FOREIGN KEY (effect_id)
        REFERENCES effect (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE problem ADD CONSTRAINT cause_problem_fk
    FOREIGN KEY (cause_id)
        REFERENCES cause (id)
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

ALTER TABLE laser ADD CONSTRAINT laser_data_laser_fk
    FOREIGN KEY (model)
        REFERENCES laser_data (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE laser_engineer ADD CONSTRAINT laser_laser_engineer_fk
    FOREIGN KEY (laser_id)
        REFERENCES laser(id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE problem ADD CONSTRAINT laser_problem_fk
    FOREIGN KEY (laser_id)
        REFERENCES laser (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE employee_authorities ADD CONSTRAINT employee_employee_authorities_fk
    FOREIGN KEY (employee_id)
        REFERENCES employee (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;

ALTER TABLE employee_authorities ADD CONSTRAINT authority_employee_authorities_fk
    FOREIGN KEY (authorities_id)
        REFERENCES authority (id)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;