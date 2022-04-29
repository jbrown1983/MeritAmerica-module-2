-- 9. The titles of movies directed by James Cameron (6 rows)

select title
from person
join movie on movie.director_id = person.person_id
Where person_name ='James Cameron';