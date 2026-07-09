# Write your MySQL query statement below
SELECT *
from Patients
where conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%';