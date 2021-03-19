SELECT title, rating
FROM movies
INNER JOIN ratings
ON id = movie_id
ORDER BY rating DESC, title;
