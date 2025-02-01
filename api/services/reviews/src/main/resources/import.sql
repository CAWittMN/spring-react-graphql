-- the first review is for the book "The Hobbit" by J.R.R. Tolkien. book id is 1 and user id can be 1
INSERT INTO review (title, body, rating, book_id, user_id, is_liked, is_disliked) VALUES ('Great book!', 'I loved this book. It was a great read.', 5, 1, 1, true, false);
-- the second review is for the book "The Fellowship of the Ring" by J.R.R. Tolkien. book id is 2 and user id can be 2
INSERT INTO review (title, body, rating, book_id, user_id, is_liked, is_disliked) VALUES ('Great book!', 'I loved this book. It was a great read.', 5, 2, 2, true, false);
-- the third review is for the book "The Two Towers" by J.R.R. Tolkien. book id is 3 and user id can be 3 and the reviewer did not like the book
INSERT INTO review (title, body, rating, book_id, user_id, is_liked, is_disliked) VALUES ('Not a fan', 'I did not like this book. It was not a great read.', 2, 3, 3, false, true);
-- the third review is for the same book as the third but a different user and is positive
INSERT INTO review (title, body, rating, book_id, user_id, is_liked, is_disliked) VALUES ('Great book!', 'I loved this book. It was a great read.', 5, 3, 4, true, false);

-- this is a review like. the userId can be 1 and the reviewId can be 3. this is a dislike of the review

INSERT INTO like_or_dislike (review_id, user_id, is_liked, is_disliked) VALUES (3, 1, false, true);

-- this is a review like. the userId can be 1 and the reviewId can be 4. this is a like of the review

INSERT INTO like_or_dislike (review_id, user_id, is_liked, is_disliked) VALUES (4, 1, true, false);