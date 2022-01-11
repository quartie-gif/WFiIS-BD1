CREATE OR REPLACE FUNCTION Project.count_employees()
(int, int) RETURNS int AS $body$
SELECT *
FROM lab04.uczestnik
WHERE id_uczestnik BETWEEN $1 AND $2
;
$body$ LANGUAGE SQL;
