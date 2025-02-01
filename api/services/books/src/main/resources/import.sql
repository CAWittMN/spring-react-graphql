-- Genre seeder
INSERT INTO genre (name) VALUES ('Action');
INSERT INTO genre (name) VALUES ('Adventure');
INSERT INTO genre (name) VALUES ('Comedy');
INSERT INTO genre (name) VALUES ('Drama');
INSERT INTO genre (name) VALUES ('Fantasy');
INSERT INTO genre (name) VALUES ('Horror');
INSERT INTO genre (name) VALUES ('Mystery');
INSERT INTO genre (name) VALUES ('Romance');
INSERT INTO genre (name) VALUES ('Sci-Fi');
INSERT INTO genre (name) VALUES ('Thriller');

-- publishers are part of a different micro-service. Here are the ids of the publisers
-- 1: HarperCollins
-- 2: Penguin Random House
-- 3: Simon & Schuster
-- 4: Hachette Livre
-- 5: Macmillan Publishers
-- 6: Scholastic
-- 7: Cengage Learning
-- 8: Wiley
-- 9: Pearson
-- 10: Houghton Mifflin Harcourt
-- 11: McGraw-Hill Education
-- 12: Springer Nature
-- 13: Oxford University Press
-- 14: Cambridge University Press
-- 15: Elsevier
-- 16: Wolters Kluwer
-- 17: Taylor & Francis
-- 18: John Wiley & Sons

-- The authors are also part of a different micro-service. Here are the ids of the authors
-- 1: J.R.R. Tolkien
-- 2: J.K. Rowling
-- 3: George R.R. Martin
-- 4: Stephen King
-- 5: Agatha Christie
-- 6: Dan Brown
-- 7: Suzanne Collins
-- 8: J.D. Salinger
-- 9: Harper Lee
-- 10: F. Scott Fitzgerald
-- 11: William Shakespeare
-- 12: Jane Austen
-- 13: Charles Dickens
-- 14: Mark Twain
-- 15: Ernest Hemingway
-- 16: John Steinbeck
-- 17: George Orwell
-- 18: Aldous Huxley
-- 19: Ray Bradbury
-- 20: Isaac Asimov
-- 21: Arthur C. Clarke
-- 22: Philip

INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (19.99, 'The Hobbit', '978-0-395-07122-1', 322, 1, 'English', 'The Hobbit is a tale of high adventure, undertaken by a company of dwarves in search of dragon-guarded gold. A reluctant partner in this perilous quest is Bilbo Baggins, a comfort-loving unambitious hobbit, who surprises even himself by his resourcefulness and skill as a burglar.', '1937-09-21', 1, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'The Fellowship of the Ring', '978-0-395-19395-6', 398, 1, 'English', 'The Fellowship of the Ring is the first of three volumes of the epic novel The Lord of the Rings by the English author J.R.R. Tolkien. It takes place in the fictional universe of Middle-earth. It was originally published on July 29, 1954 in the United Kingdom.', '1954-07-29', 1, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'The Two Towers', '978-0-395-19395-6', 327, 1, 'English', 'The Two Towers is the second volume of J.R.R. Tolkien''s epic saga, The Lord of the Rings. The Fellowship has been forced to split up. Frodo and Sam must continue alone towards Mount Doom, where the One Ring must be destroyed. Meanwhile, at Helm''s Deep and Isengard, the first great battles of the War of the Ring take shape.', '1954-11-11', 1, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'The Return of the King', '978-0-395-19395-6', 347, 1, 'English', 'The Return of the King is the towering climax to J.R.R. Tolkien''s trilogy that tells the saga of the hobbits of Middle-earth and the great War of the Rings. In this concluding volume, Frodo and Sam make a terrible journey to the heart of the Land of the Shadow in a final reckoning with the power of Sauron.', '1955-10-20', 1, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Harry Potter and the Sorcerer''s Stone', '978-0-590-35340-1', 309, 2, 'English', 'Harry Potter has never even heard of Hogwarts when the letters start dropping on the doormat at number four, Privet Drive. Addressed in green ink on yellowish parchment with a purple seal, they are swiftly confiscated by his grisly aunt and uncle. Then, on Harry''s eleventh birthday, a great beetle-eyed giant of a chap called Rubeus Hagrid bursts in with some astonishing news: Harry Potter is a wizard, and he has a place at Hogwarts School of Witchcraft and Wizardry.', '1997-06-26', 2, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Harry Potter and the Chamber of Secrets', '978-0-590-35340-1', 341, 2, 'English', 'The Dursleys were so mean and hideous that summer that all Harry Potter wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he''s packing his bags, Harry receives a warning from a strange, impish creature named Dobby who says that if Harry Potter returns to Hogwarts, disaster will strike.', '1998-06-02', 2, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Harry Potter and the Prisoner of Azkaban', '978-0-590-35340-1', 435, 2, 'English', 'Harry Potter is lucky to reach the age of thirteen, since he has survived the murderous attacks of the feared Dark Wizard Voldemort three times. But his hopes for a quiet term concentrating on Quidditch are dashed when a maniacal mass escapee, Sirius Black, with ties to Harry''s past, pays Harry a visit one night.', '1999-07-08', 2, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Harry Potter and the Goblet of Fire', '978-0-590-35340-1', 734, 2, 'English', 'Harry Potter is midway through his training as a wizard and his coming of age. Harry wants to get away from the pernicious Dursleys and go to the International Quidditch Cup with Hermione, Ron, and the Weasleys. He wants to dream about Cho Chang, his crush (and maybe do more than dream). He wants to find out about the mysterious event that''s supposed to take place at Hogwarts this year, an event involving two other rival schools of magic, and a competition that hasn''t happened for a hundred years. He wants to be a normal, fourteen-year-old wizard. But unfortunately for Harry Potter, he''s not normal - even by wizarding standards.', '2000-07-08', 2, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Harry Potter and the Order of the Phoenix', '978-0-590-35340-1', 870, 2, 'English', 'In his fifth year at Hogwart''s, Harry faces challenges at every turn, from the dark threat of He-Who-Must-Not-Be-Named and the unreliability of the government of the magical world to the rise of Ron Weasley as the keeper of the Gryffindor Quidditch Team. Along the way he learns about the strength of his friends, the fierceness of his enemies, and the meaning of sacrifice.', '2003-06-21', 2, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Harry Potter and the Half-Blood Prince', '978-0-590-35340-1', 652, 2, 'English', 'The war against Voldemort is not going well; even Muggle governments are noticing. Ron scans the obituary pages of the Daily Prophet, looking for familiar names. Dumbledore is absent from Hogwarts for long stretches of time, and the Order of the Phoenix has already suffered losses. And yet... As in all wars, life goes on.', '2005-07-16', 2, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Harry Potter and the Deathly Hallows', '978-0-590-35340-1', 759, 2, 'English', 'Harry Potter is leaving Privet Drive for the last time. But as he climbs into the sidecar of Hagrid''s motorbike and they take to the skies, he knows Lord Voldemort and the Death Eaters will not be far behind. The protective charm that has kept Harry safe until now is now broken, but he cannot keep hiding. The Dark Lord is breathing fear into everything Harry loves and to stop him Harry will have to find and destroy the remaining Horcruxes.', '2007-07-21', 2, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'A Game of Thrones', '978-0-553-57340-4', 694, 3, 'English', 'Long ago, in a time forgotten, a preternatural event threw the seasons out of balance. In a land where summers can last decades and winters a lifetime, trouble is brewing. The cold is returning, and in the frozen wastes to the north of Winterfell, sinister and supernatural forces are massing beyond the kingdom''s protective Wall. At the center of the conflict lie the Starks of Winterfell, a family as harsh and unyielding as the land they were born to. Sweeping from a land of brutal cold to a distant summertime kingdom of epicurean plenty, here is a tale of lords and ladies, soldiers and sorcerers, assassins and bastards, who come together in a time of grim omens.', '1996-08-06', 3, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'A Clash of Kings', '978-0-553-57340-4', 768, 3, 'English', 'A comet the color of blood and flame cuts across the sky. Two great leaders—Lord Eddard Stark and Robert Baratheon—who hold sway over an age of enforced peace are dead, victims of royal treachery. Now, from the ancient citadel of Dragonstone to the forbidding shores of Winterfell, chaos reigns, as pretenders to the Iron Throne of the Seven Kingdoms prepare to stake their claims through tempest, turmoil, and war.', '1998-11-16', 3, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'A Storm of Swords', '978-0-553-57340-4', 973, 3, 'English', 'Of the five contenders for power, one is dead, another in disfavor, and still the wars rage as violently as ever, as alliances are made and broken. Joffrey, of House Lannister, sits on the Iron Throne, the uneasy ruler of the land of the Seven Kingdoms. His most bitter rival, Lord Stannis, stands defeated and disgraced, the victim of the jealous sorceress who holds him in her evil thrall. But young Robb, of House Stark, still rules the North from the fortress of Riverrun. Robb plots against his despised Lannister enemies, even as they hold his sister hostage at King''s Landing, the seat of the Iron Throne. Meanwhile, making her way across a blood-drenched continent is the exiled queen, Daenerys, mistress of the only three dragons still left in the world. Filled with the stench of death and decay from the destructive dynastic war, Daenerys is gathering allies and strength for an assault on King''s Landing, hoping to win back the crown that was hers by birthright.', '2000-10-31', 3, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'A Feast for Crows', '978-0-553-57340-4', 784, 3, 'English', 'With A Feast for Crows, Martin delivers the long-awaited fourth volume of the landmark series that has redefined imaginative fiction and stands as a modern masterpiece in the making. After centuries of bitter strife, the seven powers dividing the land have beaten one another into an uneasy truce. But it''s not long before the survivors, outlaws, renegades and carrion eaters of the Seven Kingdoms gather. Now, as the human crows assemble over a banquet of ashes, daring new plots and dangerous new alliances are formed while surprising faces—some familiar, others only just appearing—emerge from an ominous twilight of past struggles and chaos to take up the challenges of the terrible times ahead. Nobles and commoners, soldiers and sorcerers, assassins and sages, are coming together to stake their fortunes...and their lives. For at a feast for crows, many are the guests—but only a few are the survivors.', '2005-11-08', 3, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'A Dance with Dragons', '978-0-553-57340-4', 1040, 3, 'English', 'In the aftermath of a colossal battle, the future of the Seven Kingdoms hangs in the balance—beset by newly emerging threats from every direction. In the east, Daenerys Targaryen, the last scion of House Targaryen, rules with her three dragons as queen of a city built on dust and death. But Daenerys has thousands of enemies, and many have set out to find her. As they gather, one of them, with a dark and terrifying secret, is approaching with great haste, determined to secure Daenerys’s dragons and claim the Iron Throne.', '2011-07-12', 3, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Carrie', '978-0-385-08695-0', 199, 4, 'English', 'Carrie knew she should not use the terrifying power she possessed... But one night at her senior prom, Carrie was scorned and humiliated just one time too many, and in a fit of uncontrollable fury she turned her clandestine game into a weapon of horror and destruction...', '1974-04-05', 4, 6);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'The Shining', '978-0-385-12167-5', 447, 4, 'English', 'Jack Torrance''s new job at the Overlook Hotel is the perfect chance for a fresh start. As the off-season caretaker at the atmospheric old hotel, he''ll have plenty of time to spend reconnecting with his family and working on his writing. But as the harsh winter weather sets in, the idyllic location feels ever more remote...and more sinister. And the only one to notice the strange and terrible forces gathering around the Overlook is Danny Torrance, a uniquely gifted five-year-old.', '1977-01-28', 4, 6);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'It', '978-0-670-81302-8', 1138, 4, 'English', 'To the children, the town was their whole world. To the adults, knowing better, Derry, Maine was just their home town: familiar, well-ordered for the most part. A good place to live. It was the children who saw - and felt - what made Derry so horribly different. In the storm drains, in the sewers, IT lurked, taking on the shape of every nightmare, each one''s deepest dread. Sometimes IT reached up, seizing, tearing, killing . . .', '1986-09-15', 4, 6);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'The Stand', '978-0-385-12168-2', 1153, 4, 'English', 'This is the way the world ends: with a nanosecond of computer error in a Defense Department laboratory and a million casual contacts that form the links in a chain letter of death. And here is the bleak new world of the day after: a world stripped of its institutions and emptied of 99 percent of its people. A world in which a handful of panicky survivors choose sides -- or are chosen.', '1978-10-03', 4, 6);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'Misery', '978-0-670-81302-8', 310, 4, 'English', 'Paul Sheldon. He''s a bestselling novelist who has finally met his biggest fan. Her name is Annie Wilkes and she is more than a rabid reader - she is Paul''s nurse, tending his shattered body after an automobile accident. But she is also his captor, keeping him prisoner in her isolated house.', '1987-06-08', 4, 6);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (24.99, 'The Green Mile', '978-0-670-81302-8', 536, 4, 'English', 'At Cold Mountain Penitentiary, along the lonely stretch of cells known as the Green Mile, killers such as "Billy the Kid" Wharton and the possessed Eduard Delacroix await death strapped in "Old Sparky."', '1996-03-28', 4, 6);
-- Agatha Christie
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (14.99, 'Murder on the Orient Express', '978-0-00-711931-8', 256, 5, 'English', 'A famous detective novel by Agatha Christie featuring Hercule Poirot.', '1934-01-01', 5, 7);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (14.99, 'And Then There Were None', '978-0-00-713683-4', 272, 5, 'English', 'A mystery novel by Agatha Christie, widely considered her masterpiece.', '1939-11-06', 5, 7);

-- Dan Brown
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (19.99, 'The Da Vinci Code', '978-0-385-50420-1', 454, 6, 'English', 'A mystery thriller novel by Dan Brown.', '2003-03-18', 6, 7);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (19.99, 'Angels & Demons', '978-0-671-02735-4', 616, 6, 'English', 'A mystery thriller novel by Dan Brown.', '2000-05-01', 6, 7);

-- Suzanne Collins
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (17.99, 'The Hunger Games', '978-0-439-02348-1', 374, 7, 'English', 'A dystopian novel by Suzanne Collins.', '2008-09-14', 7, 5);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (17.99, 'Catching Fire', '978-0-439-02349-8', 391, 7, 'English', 'The second book in The Hunger Games series by Suzanne Collins.', '2009-09-01', 7, 5);

-- J.D. Salinger
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (12.99, 'The Catcher in the Rye', '978-0-316-76948-0', 277, 8, 'English', 'A novel by J.D. Salinger.', '1951-07-16', 8, 4);

-- Harper Lee
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (14.99, 'To Kill a Mockingbird', '978-0-06-112008-4', 336, 9, 'English', 'A novel by Harper Lee.', '1960-07-11', 9, 4);

-- F. Scott Fitzgerald
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (13.99, 'The Great Gatsby', '978-0-7432-7356-5', 180, 10, 'English', 'A novel by F. Scott Fitzgerald.', '1925-04-10', 10, 4);

-- William Shakespeare
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (9.99, 'Hamlet', '978-0-7434-7712-3', 342, 11, 'English', 'A tragedy by William Shakespeare.', '1603-01-01', 11, 4);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (9.99, 'Macbeth', '978-0-7434-7713-0', 249, 11, 'English', 'A tragedy by William Shakespeare.', '1606-01-01', 11, 4);

-- Jane Austen
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (11.99, 'Pride and Prejudice', '978-0-19-953556-9', 279, 12, 'English', 'A novel by Jane Austen.', '1813-01-28', 12, 8);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (11.99, 'Sense and Sensibility', '978-0-19-953557-6', 374, 12, 'English', 'A novel by Jane Austen.', '1811-01-01', 12, 8);

-- Charles Dickens
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (15.99, 'A Tale of Two Cities', '978-0-14-143960-0', 489, 13, 'English', 'A novel by Charles Dickens.', '1859-04-30', 13, 4);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (15.99, 'Great Expectations', '978-0-14-143956-3', 505, 13, 'English', 'A novel by Charles Dickens.', '1861-08-01', 13, 4);

-- Mark Twain
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (12.99, 'The Adventures of Huckleberry Finn', '978-0-14-243717-9', 366, 14, 'English', 'A novel by Mark Twain.', '1884-12-10', 14, 4);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (12.99, 'The Adventures of Tom Sawyer', '978-0-14-243717-9', 274, 14, 'English', 'A novel by Mark Twain.', '1876-06-01', 14, 4);

-- Ernest Hemingway
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (13.99, 'The Old Man and the Sea', '978-0-684-80122-3', 127, 15, 'English', 'A novel by Ernest Hemingway.', '1952-09-01', 15, 4);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (13.99, 'A Farewell to Arms', '978-0-684-80123-0', 355, 15, 'English', 'A novel by Ernest Hemingway.', '1929-09-27', 15, 4);

-- John Steinbeck
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (14.99, 'The Grapes of Wrath', '978-0-14-303943-3', 464, 16, 'English', 'A novel by John Steinbeck.', '1939-04-14', 16, 4);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (14.99, 'Of Mice and Men', '978-0-14-017739-8', 187, 16, 'English', 'A novel by John Steinbeck.', '1937-02-06', 16, 4);

-- George Orwell
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (12.99, '1984', '978-0-452-28423-4', 328, 17, 'English', 'A dystopian novel by George Orwell.', '1949-06-08', 17, 4);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (12.99, 'Animal Farm', '978-0-452-28424-1', 112, 17, 'English', 'A satirical novella by George Orwell.', '1945-08-17', 17, 4);

-- Aldous Huxley
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (13.99, 'Brave New World', '978-0-06-085052-4', 268, 18, 'English', 'A dystopian novel by Aldous Huxley.', '1932-01-01', 18, 4);

-- Ray Bradbury
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (11.99, 'Fahrenheit 451', '978-0-7432-4722-2', 194, 19, 'English', 'A dystopian novel by Ray Bradbury.', '1953-10-19', 19, 4);

-- Isaac Asimov
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (14.99, 'Foundation', '978-0-553-80371-0', 255, 20, 'English', 'A science fiction novel by Isaac Asimov.', '1951-06-01', 20, 9);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (14.99, 'I, Robot', '978-0-553-80372-7', 224, 20, 'English', 'A collection of science fiction short stories by Isaac Asimov.', '1950-12-02', 20, 9);

-- Arthur C. Clarke
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (15.99, '2001: A Space Odyssey', '978-0-451-19154-7', 297, 21, 'English', 'A science fiction novel by Arthur C. Clarke.', '1968-07-01', 21, 9);
INSERT INTO book (price, title, isbn, page_count, publisher_id, language, blurb, published_date, author_id, genre_id) VALUES (15.99, 'Rendezvous with Rama', '978-0-575-01587-1', 256, 21, 'English', 'A science fiction novel by Arthur C. Clarke.', '1973-06-28', 21, 9);
