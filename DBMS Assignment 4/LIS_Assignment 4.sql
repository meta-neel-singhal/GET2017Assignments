-- Select database 'library_information_system'
USE `library_information_system`;

/*------------------------------------------------------ ASSIGNMENT 1 -------------------------------------------------------------------- */

-- Display name of those members who belong to the category as to which "Neel Singhal" belongs.
SELECT `name`
FROM `members`
WHERE `category` = (SELECT `category` FROM `members` WHERE `name` = "Neel Singhal");

-- Display information on the books that have not been returned till date.
SELECT bi.`issue_date`, t.`title`, m.`name`, bi.`due_date`
FROM `book_issue` bi
LEFT JOIN `members` m
ON m.`id` = bi.`member_id`
JOIN `books` b
ON bi.`accession_no` = b.`accession_no`
JOIN `title` t 
ON b.`title_id` = t.`id`  
WHERE (bi.`member_id`, bi.`accession_no`) NOT IN (SELECT `member_id`, `accession_no` FROM `book_return`);

-- Display information on the books that have been returned after their due dates.
SELECT bi.`issue_date`, t.`title`, m.`name`, bi.`due_date`
FROM `book_issue` bi
LEFT JOIN `members` m
ON m.`id` = bi.`member_id`
JOIN `books` b
ON b.`accession_no` = bi.`accession_no`
JOIN `title` t
ON b.`title_id` = t.`id`
WHERE (bi.`accession_no`, bi.`member_id`) IN (SELECT `accession_no`, `member_id` FROM `book_return` br WHERE DATEDIFF(br.`return_date`, bi.`due_date`) > 0);

-- Display information of books whose price is equal to the most expensive book purchased so far.
SELECT b.`accession_no`, b.`title_id`, t.`title`, b.`price`
FROM `books` b
JOIN `title` t
ON t.`id` = b.`title_id`
WHERE b.`price` = (SELECT MAX(`price`) FROM `books`);

-- Display the second maximum price from books.
SELECT MAX(`price`) AS `Second_Max_Price`
FROM `books`
WHERE `price` NOT IN (SELECT MAX(`price`) FROM `books`);

/*------------------------------------------------------ ASSIGNMENT 2 -------------------------------------------------------------------- */

-- View containing member name and all book_issue details of the member.
CREATE VIEW `member_and_issue_details`
AS
SELECT m.`name`, bi.*
FROM `members` m
JOIN `book_issue` bi
ON m.`id` = bi.`member_id`; 

-- View containing member name, id and category in short, i.e., S, T, O instead of Student, Teacher and Others.
CREATE VIEW `member_details`
AS
SELECT `name`, `id`, CASE `category`
                         WHEN "Student" THEN "S" 
                         WHEN "Teacher" THEN "T" 
                         ELSE "O" end 
                     AS category
FROM `members`; 

--  View containing the information of book_issue and book_return and display NULL if the books have not been returned.
CREATE VIEW `book_issue_and_return_details`
AS
SELECT s.`name` AS subject_name, t.`title`, m.`name` AS member_name, m.`category`, bi.`issue_date`, bi.`due_date`, IFNULL(br.`return_date`, 'NULL') AS return_date
FROM `book_issue` bi
LEFT JOIN `book_return` br 
ON bi.`accession_no` = br.`accession_no` AND bi.`member_id` = br.`member_id`
RIGHT JOIN `members` m 
ON m.`id` = bi.`member_id`
JOIN `books` b 
ON bi.`accession_no` = b.`accession_no`
JOIN `title` t
ON b.`title_id` = t.`id` 
JOIN `subjects` s 
ON t.`subject_id` = s.`id`;