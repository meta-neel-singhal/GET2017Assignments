SELECT * FROM Members;

SELECT member_name, member_id, category FROM Members;

SELECT member_name, member_id, category FROM Members WHERE category = "F";

SELECT DISTINCT category FROM Members;

SELECT member_name, category FROM Members ORDER BY member_name DESC;

SELECT t.title_name, s.subject_name, p.publisher_name FROM Titles as t 
    LEFT JOIN Subjects as s ON t.subject_id = s.subject_id
    LEFT JOIN Publishers as p ON t.publisher_id = p.publisher_id;
    
SELECT category, count(member_id) as CATEGORYCOUNT FROM Members
    GROUP BY category;
    
-- SELECT member_name FROM Members WHERE category = (SELECT category FROM Members WHERE member_name = "Gaurav Tak");    

SELECT m.member_name FROM Members as m
    INNER JOIN Members as e ON
    (m.category = e.category) WHERE e.member_name = "Gaurav Tak";


INSERT INTO Book_issue(issue_date, accession_no, member_id)
SELECT issue_date, accession_no, member_id FROM book_return;


UPDATE book_issue SET due_date = NOW() + INTERVAL 15 DAY where due_date is null; 


SELECT bi.issue_date, bi.accession_no, bi.member_id, IFNULL(br.return_date, "" ) as return_date FROM book_issue as bi
    LEFT JOIN book_return as br ON
    bi.issue_date = br.issue_date AND bi.accession_no = br.accession_no AND bi.member_id = br.member_id;


/*--Question2--*/
SELECT bi.issue_date, bi.accession_no, bi.member_id, IFNULL(br.return_date, "" ) as return_date, Members.member_name 
    FROM book_issue as bi
    LEFT JOIN book_return as br ON
    bi.issue_date = br.issue_date AND bi.accession_no = br.accession_no AND bi.member_id = br.member_id
    JOIN Members on bi.member_id = Members.member_id
    ORDER BY bi.issue_date,Members.member_name;
    

    