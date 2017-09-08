-- query to add a book which is issued 4 months back and not yet returned --


-- entry for a book which is not yet purchased --
INSERT INTO books (accession_no, status, price, title_id) VALUES (8021, 'A', 1000, 502);

Select member_name,LENGTH(member_name) FROM Members where LENGTH(member_name) = (SELECT MAX(LENGTH(member_name)) FROM Members);

SELECT COUNT(*) FROM book_issue;

SELECT Subjects.subject_name, Subjects.subject_id, COUNT(Books.accession_no) AS Books_Count FROM Books 
LEFT JOIN Titles ON
Books.title_id = Titles.title_id
LEFT JOIN Subjects ON
Titles.subject_id = Subjects.subject_id
GROUP BY Subjects.subject_id;

SELECT * FROM Book_issue WHERE DATEDIFF(due_date, issue_date) > 60;

SELECT * FROM Books WHERE price > (SELECT MIN(price) FROM Books);

SELECT COUNT(bi.accession_no), t.title_name FROM book_issue as bi
LEFT JOIN Books as b ON
bi.accession_no = b.accession_no
LEFT JOIN titles as t ON
b.title_id = t.title_id
GROUP BY t.title_id Having COUNT(bi.accession_no) > 2;

SELECT * FROM book_issue
inner JOIN members ON
book_issue.member_id = Members.member_id
WHERE Members.category NOT IN ("F");

SELECT DISTINCT(authors.author_id), authors.author_name FROM Books
INNER JOIN title_author ON
Books.title_id = title_author.title_id
INNER JOIN authors ON
authors.author_id = title_author.author_id
WHERE Books.purchase_date IS NOT NULL;


-- Question1 assignment 1 --
SELECT Members.member_id,Members.member_name, Titles.title_name, Book_issue.accession_no,Book_issue.issue_date,Book_issue.due_date,
DATEDIFF(NOW(), book_issue.issue_date)/30 AS IssuedTime
FROM book_issue 
LEFT JOIN book_return ON
book_issue.accession_no = book_return.accession_no AND
book_issue.member_id = book_return.member_id AND
book_issue.issue_date = book_return.issue_date
INNER JOIN Members ON 
book_issue.member_id = Members.member_id
INNER JOIN Books ON
book_issue.accession_no = books.accession_no
INNER JOIN Titles On
Books.title_id = Titles.title_id
WHERE book_return.return_date IS NULL AND DATEDIFF(NOW(), book_issue.issue_date) > 60
ORDER BY MEmbers.member_name, Titles.title_name;

-- Question 1 assignment 2 --

SELECT COUNT(Books.accession_no), Subjects.subject_name, Books.purchase_date FROM Subjects 
LEFT JOIN Titles ON
    Subjects.subject_id = Titles.subject_id
LEFT JOIN Books ON
    Books.title_id = Titles.title_id where Books.purchase_date IS NOT NULL
 GROUP BY Subjects.subject_id ;
 
 
SELECT COUNT(category) as total_number,category 
from members 
Group by category NOT in ('F','S')  , category in ('F'), category in ('S');


SELECT COUNT(IF(category="F",1,null)) AS Faculty_count , COUNT(IF(category="S",1,null)) AS Student_count , 
COUNT(IF(category!="F" and category!="S",1,null)) AS OTHERS
FROM members; 