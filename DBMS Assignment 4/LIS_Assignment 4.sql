-- Select database 'library_information_system'
USE `library_information_system`;

/*------------------------------------------------------ ASSIGNMENT 1 -------------------------------------------------------------------- */

-- Display name of those members who belong to the category as to which "Neel Singhal" belongs.
SELECT `name`
FROM `members`
WHERE `category` IN (SELECT `category` FROM `members` WHERE `name` = "Neel Singhal");

-- Display information on the books that have not been returned till date.
SELECT titl.`title`, buk_issue.`issue_date`, mem.`name`, buk_issue.`due_date`
FROM `book_issue` buk_issue
JOIN `members` mem
ON mem.`id` = buk_issue.`member_id`
JOIN `books` buk
ON buk_issue.`accession_no` = buk.`accession_no`
JOIN `title` titl
ON buk.`title_id` = titl.`id`  
WHERE (buk_issue.`accession_no`, buk_issue.`member_id`) NOT IN (SELECT `accession_no`, `member_id` FROM `book_return`);

-- Display information on the books that have been returned after their due dates.
SELECT DISTINCT titl.`title`, buk_issue.`issue_date`, mem.`name`, buk_issue.`due_date`
FROM `book_issue` buk_issue
LEFT JOIN `members` mem
ON mem.`id` = buk_issue.`member_id`
JOIN `books` buk
ON buk.`accession_no` = buk_issue.`accession_no`
JOIN `title` titl
ON buk.`title_id` = titl.`id`
WHERE (buk_issue.`accession_no`, buk_issue.`member_id`) IN (SELECT `accession_no`, `member_id` FROM `book_return` buk_ret WHERE DATEDIFF(buk_ret.`return_date`, buk_issue.`due_date`) > 0);

-- Display information of books whose price is equal to the most expensive book purchased so far.
SELECT buk.`accession_no`, buk.`title_id`, titl.`title`, buk.`price`
FROM `books` buk
JOIN `title` titl
ON titl.`id` = buk.`title_id`
WHERE buk.`price` = (SELECT MAX(`price`) FROM `books`);

-- Display the second maximum price from books.
SELECT MAX(`price`) AS `Second_Max_Price`
FROM `books`
WHERE `price` NOT IN (SELECT MAX(`price`) FROM `books`);

-- Another method for above problem.
SELECT `price` FROM `books` ORDER BY `price` DESC LIMIT 2,1;

/*------------------------------------------------------ ASSIGNMENT 2 -------------------------------------------------------------------- */

-- View containing member name and all book_issue details of the member.
CREATE OR REPLACE VIEW `member_and_issue_details`
AS
SELECT mem.`name`, buk_issue.*
FROM `members` mem
JOIN `book_issue` buk_issue
ON mem.`id` = buk_issue.`member_id`; 

SELECT * FROM `member_and_issue_details`;

-- View containing member name, id and category in short, i.e., S, T, O instead of Student, Teacher and Others.
CREATE OR REPLACE VIEW `member_details`
AS
SELECT `name`, `id`, CASE `category`
                         WHEN "Student" THEN "S" 
                         WHEN "Teacher" THEN "T" 
                         ELSE "O" end 
                     AS category
FROM `members`; 

SELECT * FROM `member_details`;

--  View containing the information of book_issue and book_return and display NULL if the books have not been returned.
CREATE OR REPLACE VIEW `book_issue_and_return_details`
AS
SELECT sub.`name` AS subject_name, titl.`title`, mem.`name` AS member_name, mem.`category`, buk_issue.`issue_date`, buk_issue.`due_date`, buk_issue.`accession_no`, IFNULL(buk_ret.`return_date`, 'NULL') AS return_date
FROM `book_issue` buk_issue
LEFT JOIN `book_return` buk_ret 
ON buk_issue.`accession_no` = buk_ret.`accession_no` AND buk_issue.`member_id` = buk_ret.`member_id`
RIGHT JOIN `members` mem 
ON mem.`id` = buk_issue.`member_id`
JOIN `books` buk
ON buk_issue.`accession_no` = buk.`accession_no`
JOIN `title` titl
ON buk.`title_id` = titl.`id` 
JOIN `subjects` sub 
ON titl.`subject_id` = sub.`id`;

SELECT * FROM `book_issue_and_return_details`;