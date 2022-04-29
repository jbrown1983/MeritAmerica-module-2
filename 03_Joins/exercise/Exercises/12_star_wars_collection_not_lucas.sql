-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)



select title
from movie
join collection on movie.collection_id = collection.collection_id 
join person on movie.director_id = person.person_id
Where collection.collection_name ='Star Wars Collection' and person.person_name !='George Lucas'

