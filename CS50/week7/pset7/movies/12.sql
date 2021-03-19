SELECT title
FROM movies
WHERE id IN (
  SELECT johnny.movie_id
  FROM
    (SELECT stars.movie_id
    FROM stars
    INNER JOIN people
    ON people.id = stars.person_id
    WHERE people.name = 'Johnny Depp') as johnny
  INNER JOIN (
    SELECT stars.movie_id
    FROM stars
    INNER JOIN people
    ON people.id = stars.person_id
    WHERE people.name = 'Helena Bonham Carter') as helena
  ON helena.movie_id = johnny.movie_id);
