CREATE OR REPLACE FUNCTION Project.count_employees()
(int, int) RETURNS int AS $body$
SELECT *
FROM lab04.uczestnik
WHERE id_uczestnik BETWEEN $1 AND $2
;
$body$ LANGUAGE SQL;



CREATE OR REPLACE FUNCTION Project.login(logind character varying, haslod character varying) returns boolean
    language plpgsql
as
$$
DECLARE
        existsCheckData BOOLEAN;
    BEGIN
        select exists(select dd.login, dd.haslo from dane_dyrektor dd where dd.login = loginD and dd.haslo = hasloD) into existsCheckData;
        if (select existsCheckData = TRUE) THEN
            return true;
        else
           RAISE EXCEPTION 'Podałeś zły login lub  hasło, sprawdź swoje dane i sprobuj ponownie!';
        end if;
    END;
$$;
