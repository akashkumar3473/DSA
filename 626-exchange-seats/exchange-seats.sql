# Write your MySQL query statement below
SELECT 
s1.id,
(CASE WHEN (s2.student IS NULL) THEN s1.student ELSE s2.student END) AS student 
FROM Seat s1
LEFT JOIN Seat s2
ON (s1.id%2=0 AND s2.id=s1.id-1) OR (s1.id%2!=0 AND s2.id=s1.id+1)