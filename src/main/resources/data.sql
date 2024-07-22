INSERT INTO employee_data (given_name, family_name, email, role)
VALUES ('John', 'Doe', 'john.doe@example.com', 'Software Engineer'),
       ('Jane', 'Smith', 'jane.smith@example.com', 'Project Manager'),
       ('Michael', 'Johnson', 'michael.johnson@example.com', 'Data Analyst'),
       ('Emily', 'Brown', 'emily.brown@example.com', 'UX Designer'),
       ('David', 'Wilson', 'david.wilson@example.com', 'System Administrator');

INSERT INTO absence_request_data (employee_id, fromDate, toDate, approved)
VALUES (1, '2024-06-15', '2024-06-20', 'Approved'),
       (2, '2024-07-01', '2024-07-05', 'Pending'),
       (3, '2024-08-10', '2024-08-15', 'Rejected'),
       (4, '2024-09-22', '2024-09-24', 'Approved'),
       (5, '2024-10-05', '2024-10-10', 'Pending');