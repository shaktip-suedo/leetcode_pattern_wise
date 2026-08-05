# Write your MySQL query statement below
select customer_number
FROM Orders
Group by customer_number
order by count(*) DESC
LIMIT 1
