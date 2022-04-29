-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result around 110-120)

select AVG(length_minutes) as average_length
from movie_genre
join movie ON movie.movie_id=movie_genre.movie_id
join genre ON genre.genre_id=movie_genre.genre_id
where genre_name = 'Science Fiction'