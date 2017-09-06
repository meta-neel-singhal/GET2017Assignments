-- Select database library_information_system.
USE `library_information_system`;

/* -------------------------------------- Assignment 1 -------------------------------------- */

-- Display information on books issued for more than 2 months sorted on member_name and title_name.
SELECT m.`name`, m.`id`, t.`title`, bi.`accession_no`, bi.`issue_date`, bi.`due_date`, br.`return_date` ,DATEDIFF(br.`return_date`, bi.`issue_date`) / 30 AS duration_in_month 
FROM `book_return` br
JOIN `book_issue` bi 
USING(`accession_no`)
JOIN `books` b
USING(`accession_no`)
JOIN `title` t 
ON (b.`title_id` = t.`id`)
JOIN `members` m 
ON (m.`id` = br.`member_id`)
WHERE DATEDIFF(br.`return_date`, bi.`issue_date`) / 30 > 2
ORDER BY m.`name`, t.`title`;

-- Display those rows from members table having maximum length for member name.
SELECT `name` AS 'Member Name', LENGTH(`name`) AS 'Name Length'
FROM `members`
WHERE LENGTH(`name`) = (SELECT MAX(LENGTH(`name`)) FROM `members`);

-- Display count of number of books issued so far.
SELECT COUNT(`issue_date`) 'Books Issued So Far'
FROM `book_issue`;

/* -------------------------------------- Assignment 2 -------------------------------------- */

-- Display subjectwise information on number of books purchased.
SELECT COUNT(b.`accession_no`) AS accession_no, s.`name`, b.`purchase_date`
FROM `subjects` s 
LEFT JOIN `title` t 
ON s.`id` = t.`subject_id`
LEFT JOIN `books` b
ON b.`title_id` = t.`id` 
WHERE b.`purchase_date` IS NOT NULL
GROUP BY s.`id` ;

-- Display those rows from the book_issue table where a book can be returned after 2 months.
SELECT  `member_id`, `accession_no`, DATE(`issue_date`) AS issue_date, `due_date`, 
DATEDIFF(`due_date`, `issue_date`) / 30 AS duration_in_months
FROM `book_issue`
WHERE DATEDIFF(`due_date`, `issue_date`) / 30 > 2;

-- Display the list of books having price greater than the minimum price of books purchased so far.
SELECT `accession_no`, `title_id`, `price`
FROM `books`
WHERE `price` > (SELECT MIN(`price`) FROM `books`);

/* -------------------------------------- Assignment 3 -------------------------------------- */

-- Display total no. of students, total no. of teachers and total no. of others in a single row.
SELECT COUNT(IF(category = "Student", category, NULL)) AS 'Students',
       COUNT(IF(category = "Teacher", category, NULL)) AS 'Teachers',
       COUNT(IF(category != "Teacher" AND category != "Student", category, NULL)) AS 'Others'
FROM members;

-- Display the information of those titles that have been issued more than 2 times.
SELECT bi.`accession_no`, t.`title`, COUNT(bi.`accession_no`) 'No. of times book is issued'
FROM `book_issue` bi
JOIN `books` b
ON b.`accession_no` = bi.`accession_no`
JOIN `title` t
ON t.`id` = b.`title_id`
GROUP BY bi.`accession_no`
HAVING COUNT(bi.`accession_no`) > 2;

-- Display the information of books issued to members of category other than Teacher.
SELECT DISTINCT b.`accession_no`, b.`title_id`, t.title, b.`purchase_date`, b.`price`, m.`category` AS 'member_category'
FROM `books` b
JOIN `title` t
ON t.`id` = b.`title_id`
JOIN `book_issue` bi
ON b.`accession_no` = bi.`accession_no`
JOIN `members` m
ON m.`id` = bi.`member_id`
WHERE m.`category` NOT IN ('Teacher');

-- Display information on those authors for which at least 1 book has been purchased.
SELECT DISTINCT a.`id`, a.`name`
FROM `author` a
JOIN `title_author` ta
ON a.`id` = ta.`author_id`
JOIN `books` b
ON b.`title_id` = ta.`title_id`;