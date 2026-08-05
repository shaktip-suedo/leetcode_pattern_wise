# Write your MySQL query statement below
select user_id ,MAX(time_stamp) AS last_stamp
from Logins
Where time_stamp LIKE '2020%'
GROUP by user_id