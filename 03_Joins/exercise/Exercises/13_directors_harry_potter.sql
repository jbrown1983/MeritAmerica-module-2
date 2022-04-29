-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)

select person_name
from person
join movie on movie.director_id = person.person_id
join collection on movie.collection_id = collection.collection_id 
Where collection.collection_name ='Harry Potter Collection'
group by person_name