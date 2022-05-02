-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet. 
--Add yourself to the person table, and assign yourself as the director of "The Blob"
-- (the movie is already in the movie table). (1 record each)

INSERT INTO person(person_name, birthday)
VALUES('Jennifer Brown', '1983-11-11');

UPDATE movie
SET director_id =
    (SELECT person_id
    from person
    WHERE person_name = 'Jennifer Brown')
WHERE title = 'The Blob';