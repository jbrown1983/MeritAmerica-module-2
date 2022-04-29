-- 5. The titles and release dates of all the movies that are in the Comedy genre. Order the results by release date, earliest to latest. (220 rows)


select title, release_date
from movie_genre
join movie ON movie.movie_id=movie_genre.movie_id
join genre ON genre.genre_id=movie_genre.genre_id
where genre_name ='Comedy'
order by release_date ASC;