-- 6. The genres of "The Wizard of Oz" (3 rows)


select genre_name 
from movie_genre
join movie ON movie.movie_id=movie_genre.movie_id
join genre ON genre.genre_id=movie_genre.genre_id
where movie.title ='The Wizard of Oz'
