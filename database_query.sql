create database NovoGold;
use novogold;
create table user(user_name varchar(15) primary key,password varchar(15));

create table user_session(session_id int primary key,user_name varchar(15),timestamp date,latitude float,longitude float,foreign key(user_name) references user(user_name));

create table region(region_id int primary key, region_name varchar(20));

create table dealers(dealer_id int primary key, dealer_name varchar(20), region_id int, foreign key(region_id) references region(region_id));

alter table dealers add column address varchar(50);

create table crops(crops_id int,crops_type varchar(20));

create table products(product_id int primary key, crops_id int,product_name varchar(20));

create table order_package(order_id int,product_id int, 50kg int,20kg int, 10kg int,5kg int, 1kg int);

create table orders(order_id int primary key, user_id int,product_id int,dealer_id int, order_date date);
alter table orders add foreign key(dealer_id) references dealers(dealer_id);

alter table user_session add constraint foreign key(user_id) references user(user_id);

create table user_sale(user_id int, day_total int ,sale_date date,foreign key(user_id) references user(user_id));



use novogold;

select region_name from region;
select dealer_name from dealers where region_id=201;
select r.region_id,d.dealer_name from region r,dealers d where r.region_id=d.region_id order by region_id;


select product_id,product_name from products where crops_id=11;


select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg)as Total_order  from order_package where 
order_id=(select o.order_id from orders o,dealers d where d.dealer_id=o.dealer_id and d.dealer_name='AgroStar'); 

select count(dealer_id) from orders where order_date='2019-01-15' and user_id=1234;

select count(*) from dealers where region_id=202;

/*to get monthly order_count
select sum(50kg*50+20kg*20+10kg*10+5kg*8+1kg)as Total_order  from order_package where order_date between (date1 and date2) and 
order_id=(select o.order_id from orders o,dealers d where d.dealer_id=o.dealer_id and d.dealer_name='AgroStar');  */


/*query for last 10 orders of dealer  */
select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as Total_order from order_package where 
order_id in (select o.order_id from orders o,dealers d where d.dealer_id=o.dealer_id and d.dealer_name='AgroStar' ); 

/* last order of dealer*/
select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as Total_order from order_package where 
order_id = (select o.order_id from orders o,dealers d where d.dealer_id=o.dealer_id and d.dealer_name='AgroStar' group by order_date order by order_date desc limit 1 ); 


insert into orders values(10010,321,101,'2019-2-1');

select count(*) from orders where user_id=1234 and order_date=curdate();

/* find total item in order*/
select count(*) as Total_order from order_package where 
order_id = (select o.order_id from orders o,dealers d where d.dealer_id=o.dealer_id and d.dealer_name='AgroStar' group by order_date order by order_date desc limit 1 ); 




/* curdate sale*/
select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as day_sale  from order_package op,orders o where op.order_id=o.order_id and o.user_id=123 and o.order_date=curdate();

/* weekly sale*/
select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as week_Sale from order_package op,orders o where op.order_id=o.order_id and o.user_id=123 and o.order_date between DATE_SUB(now(),interval 7 day) and now();


/* month sale*/
select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as month_Sale from order_package op,orders o where op.order_id=o.order_id and o.user_id=123 and o.order_date between DATE_SUB(now(),interval 1 month) and now();


/* 4 month sale*/
select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as 4month_Sale from order_package op,orders o where op.order_id=o.order_id and o.user_id=123 and o.order_date between DATE_SUB(now(),interval 4 month) and now();


/* year sale*/
select sum(50kg*50+20kg*20+10kg*10+5kg*5+1kg) as month_Sale from order_package op,orders o where op.order_id=o.order_id and o.user_id=123 and o.order_date between DATE_SUB(now(),interval 1 year) and now();


