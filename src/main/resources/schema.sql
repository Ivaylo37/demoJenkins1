DROP TABLE IF EXISTS customer_data;

CREATE TABLE employee_data
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    given_name  VARCHAR(128) NOT NULL,
    family_name VARCHAR(128) NOT NULL,
    email       VARCHAR(128) NOT NULL,
    role        VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS absence_request_data;

CREATE TABLE absence_request_data
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    employee_id     BIGINT,
    fromDate    DATE,
    toDate      DATE,
    approved    VARCHAR(128) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employee_data(id)

);


