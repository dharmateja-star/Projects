-- 1. Insert a new employee
INSERT INTO employees (emp_name, email, salary, dept_id, manager_id)
VALUES ('George', 'george@example.com', 52000, 3, 3);

-- 2. Update salary
UPDATE employees
SET salary = 75000
WHERE emp_id = 6;

-- 3. Delete an employee
DELETE FROM employees
WHERE emp_id = 7;

-- 4. View all employees
SELECT * FROM employees;

-- 5. Employee with department name
SELECT e.emp_id, e.emp_name, d.dept_name
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id;

-- 6. List employees with their manager name
SELECT e.emp_name, m.emp_name AS manager_name
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.emp_id;

-- 7. Highest salary in each department
SELECT d.dept_name, MAX(e.salary) AS highest_salary
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id
GROUP BY d.dept_name;

-- 8. Total salary by department
SELECT d.dept_name, SUM(e.salary) AS total_salary
FROM employees e
JOIN departments d ON e.dept_id = d.dept_id
GROUP BY d.dept_name;

-- 9. Employees hired in the last 30 days
SELECT * FROM employees
WHERE hire_date >= DATE_SUB(CURRENT_DATE, INTERVAL 30 DAY);

-- 10. Manager & reportee count
SELECT m.emp_name AS manager_name, COUNT(e.emp_id) AS reportees
FROM employees e
JOIN employees m ON e.manager_id = m.emp_id
GROUP BY m.emp_name;
