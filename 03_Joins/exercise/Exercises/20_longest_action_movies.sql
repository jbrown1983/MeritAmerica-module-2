-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)

SELECT M.title, M.length_minutes, M.release_date 
FROM movie M 
JOIN movie_genre MG ON M.movie_id = MG.movie_id 
JOIN genre G ON MG.genre_id = G.genre_id
WHERE G.genre_name = 'Action' 
ORDER BY M.length_minutes DESC, M.release_date DESC LIMIT 5