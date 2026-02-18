# Write your MySQL query statement below
select  query_name ,
ROUND(avg(rating/position),2) as quality,
ROUND(100* sum(rating<3)/count(*),2) as poor_query_percentage 

from Queries
group by query_name;