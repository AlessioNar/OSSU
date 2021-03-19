SELECT people.name
FROM people
INNER JOIN stars
ON people.id = stars.person_id
WHERE stars.movie_id IN (SELECT DISTINCT movie_id
                        FROM stars
                        INNER JOIN people
                        ON stars.person_id = people.id
                        WHERE people.name = 'Kevin Bacon'
                        AND people.birth = 1958)
AND people.id NOT IN (SELECT people.id
                      FROM people
                      WHERE people.name = 'Kevin Bacon'
                      AND people.birth = 1958);
