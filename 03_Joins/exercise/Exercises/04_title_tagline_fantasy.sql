-- 4. The titles and taglines of all the movies that are in the Fantasy genre. Order the results by title (A-Z) (81 rows)


select title, tagline
from movie_genre
join movie ON movie.movie_id=movie_genre.movie_id
join genre ON genre.genre_id=movie_genre.genre_id
where genre_name ='Fantasy'
order by title

