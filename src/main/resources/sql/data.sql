--table: books
insert into books (id, title, publishDate, author, page, coverImage) values (1,'The Road Less Traveled','1989-10-07', 'Ernestina Kozey', 42,'http://lorempixel.com/35/50/nature/');
insert into books (id, title, publishDate, author, page, coverImage) values (2,'Vile Bodies','1989-04-12', 'Miss Geo Nienow', 10,'http://lorempixel.com/35/50/cats/');
insert into books (id, title, publishDate, author, page, coverImage) values (3,'Time To Murder And Create','1980-02-18', 'Marcos Cronin', 34,'http://lorempixel.com/35/50/business/');
insert into books (id, title, publishDate, author, page, coverImage) values (4,'Cover Her Face','1966-06-29', 'Susana Crist', 02,'http://lorempixel.com/35/50/transport/');
insert into books (id, title, publishDate, author, page, coverImage) values (5,'The Stars Tennis Balls','1966-12-21', 'Shanna Reichel DDS', 15,'http://lorempixel.com/35/50/cats/');
insert into books (id, title, publishDate, author, page, coverImage) values (6,'Stranger in a Strange Land','1989-06-06', 'Nichole Mann V', 62,'http://lorempixel.com/35/50/animals/');
insert into books (id, title, publishDate, author, page, coverImage) values (7,'Its a Battlefield','1964-02-24', 'Dr. Brendan Huels', 87,'http://lorempixel.com/35/50/fashion/');
insert into books (id, title, publishDate, author, page, coverImage) values (8,'The Parliament of Man','1965-04-28', 'Marcos Kutch', 57,'http://lorempixel.com/35/50/business/');
insert into books (id, title, publishDate, author, page, coverImage) values (9,'Those Barren Leaves, Thrones, Dominations','1989-09-02', 'Corene Koepp', 20,'http://lorempixel.com/35/50/cats/');
insert into books (id, title, publishDate, author, page, coverImage) values (10,'Tiger! Tiger!','1956-01-03', 'Lacey Hessel', 75,'http://lorempixel.com/35/50/business/');

--table: publishers
insert into publishers (id, publisher) values (1, 'Khmer SK');
insert into publishers (id, publisher) values (2, 'Key PUB');
insert into publishers (id, publisher) values (3, 'TKM');
insert into publishers (id, publisher) values (4, 'Kontea');

--table: book_publisher
insert into book_publisher (book_id, publisher_id) values (1, 2);
insert into book_publisher (book_id, publisher_id) values (1, 1);
insert into book_publisher (book_id, publisher_id) values (1, 4);
insert into book_publisher (book_id, publisher_id) values (2, 3);
insert into book_publisher (book_id, publisher_id) values (3, 1);
insert into book_publisher (book_id, publisher_id) values (4, 4);
insert into book_publisher (book_id, publisher_id) values (5, 1);
insert into book_publisher (book_id, publisher_id) values (5, 3);
insert into book_publisher (book_id, publisher_id) values (6, 4);
insert into book_publisher (book_id, publisher_id) values (7, 2);
insert into book_publisher (book_id, publisher_id) values (8, 1);
insert into book_publisher (book_id, publisher_id) values (8, 4);
insert into book_publisher (book_id, publisher_id) values (9, 3);
insert into book_publisher (book_id, publisher_id) values (10, 3);

--table: users
insert into users (id, username, password) values (1, 'Admin', 'Admin');
insert into users (id, username, password) values (2, 'DBA', 'DBA');
insert into users (id, username, password) values (3, 'User', 'User');

--table: roles
insert into roles (id, role) values (1, 'ADMIN');
insert into roles (id, role) values (2, 'DBA');
insert into roles (id, role) values (3, 'USER');

--table: user_role
insert into user_role (user_id, role_id) values (1, 1);
insert into user_role (user_id, role_id) values (2, 2);
insert into user_role (user_id, role_id) values (3, 3);
