-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)


Select P.person_name, P.birthday
from movie M, person P, movie_actor A
Where M.title='The Fifth Element' AND A.actor_id=P.person_id AND M.movie_id=A.movie_id;