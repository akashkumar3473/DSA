SELECT 
    d.visited_on,
    (
        SELECT SUM(amount)
        FROM Customer
        WHERE visited_on BETWEEN DATE_SUB(d.visited_on, INTERVAL 6 DAY)
                            AND d.visited_on
    ) AS amount,
    ROUND(
        (
            SELECT SUM(amount)
            FROM Customer
            WHERE visited_on BETWEEN DATE_SUB(d.visited_on, INTERVAL 6 DAY)
                                AND d.visited_on
        ) / 7, 2
    ) AS average_amount
FROM 
    (SELECT DISTINCT visited_on FROM Customer) d
WHERE d.visited_on >= (
        SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY)
        FROM Customer
)
ORDER BY d.visited_on;