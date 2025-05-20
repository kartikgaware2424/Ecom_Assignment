use fsb_hexa;
CREATE TABLE Book (
    id INT PRIMARY KEY,
    title VARCHAR(100),
    price DECIMAL(10,2),
    author VARCHAR(100),
    publication_house VARCHAR(100),
    category VARCHAR(50),
    book_count INT,
    status ENUM('IN STOCK', 'OUT_OF_STOCK')
);

INSERT INTO Book (id, title, price, author, publication_house, category, book_count, status) VALUES
(1, 'The War Path', 299.99, 'Author A', 'Mcgraw Hill', 'WAR', 10, 'IN STOCK'),
(2, 'Laugh Out Loud', 199.00, 'Author B', 'DreamFolks', 'COMEDY', 5, 'IN STOCK'),
(3, 'Battlefield', 399.50, 'Author C', 'Warner Bros', 'WAR', 3, 'OUT_OF_STOCK'),
(4, 'Sporty Life', 150.75, 'Author D', 'Mcgraw Hill', 'SPORTS', 7, 'IN STOCK'),
(5, 'Dream World', 500.00, 'Author E', 'DreamFolks', 'FICTION', 8, 'OUT_OF_STOCK'),
(6, 'Champions', 249.99, 'Author F', 'Warner Bros', 'SPORTS', 2, 'IN STOCK'),
(7, 'Peace & War', 180.00, 'Author G', 'Mcgraw Hill', 'WAR', 6, 'IN STOCK');
truncate table book;
 -- 
delimiter $$;
CREATE procedure get_book(IN max_price INT)
BEGIN
select * from book where status ='IN STOCK ' and price <max_price;
END;
call get_book(200);

delimiter $$
create procedure delete_book(IN publication varchar(255))
begin
declare total_rows INT default 0;
declare i int default 0;
declare p_id int default 0;

select count(id) into total_rows from book where publication_house=publication;
while i<=total_rows do 
select id into p_id from book where publication_house=publication limit 1;
delete from book where id=p_id;
set i=i+1;
END while;
end;

drop procedure delete_book;
call delete_book('Mcgraw Hill');

select * from book;


delimiter $$ 
create procedure update_book(IN per double, IN p_category varchar(255))
BEGIN
declare total_rows INT default 0;
declare i int default 0;
declare p_id int default 0;

select count(id) into total_rows from book where category=p_category;
while i<=total_rows do 
select id into p_id from book where category=p_category limit i,1;
update book set price=price + (price *(per/100)) where id=p_id;
set i=i+1;
END while;
END;
drop procedure update_book;
call update_book(10,'war');

SELECT * FROM BOOK;