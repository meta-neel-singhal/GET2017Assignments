-- Select database.
USE `library_information_system`;

-- Display all columns of members table.
SELECT `id`, `name`, `address_line1`, `address_line2`, `category`
FROM `members`;

-- Display member_name, member_id, category columns of members table.
SELECT `name`, `id`, `category`
FROM `members`;

-- Display records of members table where category is Teacher.
SELECT `name`, `id`, `category`
FROM `members`
WHERE `category` = 'Teacher';

-- Display various categories of members.
SELECT DISTINCT `category` FROM `members`;

-- Display member_name and category in descending order of member name.
SELECT `name`, `category`
FROM `members`
ORDER BY `name` DESC;

-- Display titles, their subjects and publishers.
SELECT `title`.`title`, `subjects`.`name`, `publisher`.`name`
FROM `title`
INNER JOIN `subjects`
ON `title`.`subject_id` = `subjects`.`id`
INNER JOIN `publisher`
ON `title`.`publisher_id` = `publisher`.`id`;

-- Display number of members in each category.
SELECT `category`, COUNT(`name`)
FROM `members`
GROUP BY `category`;

-- Display name of those members having category same as that of 'Neel Singhal'.
SELECT m1.`name`
FROM `members` m1
INNER JOIN `members` m2
ON m1.`category` = m2.`category`
WHERE m2.`name` = 'Neel Singhal';

-- Display information on all the books issued.
SELECT DATE(bi.`issue_date`) "Book Issued On", bi.`accession_no` "Accession Number Of Issued Book", bi.`member_id` "Book Issued To", IFNULL(DATE(br.`return_date`), "") "Book Returned On"
FROM `book_issue` bi
LEFT JOIN `book_return` br 
ON bi.`accession_no` = br.`accession_no`;

-- Display information of books issued in ascending order of issue date and within issue date in ascending order of member's name.
SELECT DATE(bi.`issue_date`) "Book Issued On", bi.`accession_no` "Accession Number Of Issued Book", bi.`member_id` "Book Issued To", IFNULL(DATE(br.`return_date`), "") "Book Returned On"
FROM `book_issue` bi
LEFT JOIN `book_return` br
ON bi.`accession_no` = br.`accession_no`
LEFT JOIN `members` m
ON m.`id` = bi.`member_id`
ORDER BY bi.`issue_date` ASC, m.`name` ASC;