CREATE SCHEMA bookshelf authorization sa;

CREATE TABLE bookshelf.bookmark (
ID INT auto_increment PRIMARY KEY,
TITLE VARCHAR(255) DEFAULT '',
ADDRESS VARCHAR(255) DEFAULT '');

INSERT INTO bookshelf.bookmark VALUES (1, '[Khan Academy] Intro to SQL: Querying and managing data', 'https://www.khanacademy.org/computing/computer-programming/sql');

INSERT INTO bookshelf.bookmark VALUES (2, 'https://www.youtube.com/watch?v=40KM8IdneLg&list=PLEAQNNR8IlB588DQvb2wbKFQh2DviPApl', 'https://www.youtube.com/watch?v=40KM8IdneLg&list=PLEAQNNR8IlB588DQvb2wbKFQh2DviPApl');

select * from bookshelf.bookmark;
