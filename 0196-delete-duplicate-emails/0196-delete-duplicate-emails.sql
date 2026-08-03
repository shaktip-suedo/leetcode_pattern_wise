# Write your MySQL query statement below
delete from Person
where id NOT IN(
    SELECT id
    from (
        Select MIN(id) as id
        from Person
        group by email
    )as t
);