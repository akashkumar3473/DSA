# Write your MySQL query statement below
SELECT e.name AS Employee
from Employee e,Employee m
WHERE e.salary>(
    select m.salary
    where m.id=e.managerId
);