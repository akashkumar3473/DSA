# Write your MySQL query statement below
SELECT
    e.Name,
    b.Bonus
FROM Employee e
LEFT JOIN Bonus b
    ON e.EmpId = b.EmpId
WHERE b.Bonus < 1000 OR b.Bonus IS NULL;
