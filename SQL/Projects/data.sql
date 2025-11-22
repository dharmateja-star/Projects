INSERT INTO departments (dept_name) VALUES
('HR'), ('Engineering'), ('Finance'), ('Marketing');

-- Insert employees
INSERT INTO employees (emp_name, email, salary, dept_id, manager_id)
VALUES
('Alice', 'alice@example.com', 60000, 2, NULL),
('Bob', 'bob@example.com', 45000, 2, 1),
('Charlie', 'charlie@example.com', 55000, 3, NULL),
('David', 'david@example.com', 40000, 1, NULL),
('Eva', 'eva@example.com', 48000, 1, 4),
('Frank', 'frank@example.com', 70000, 2, 1);
