create table users(user_id varchar(15) primary key, user_fname varchar(20), 
	user_lname varchar(20) not null , user_email varchar(20) not null unique, 
	password varchar(10) not null, user_wallet integer, user_phone varchar(20) ,
	user_status varchar(10) default 'User', user_age integer)  
	
	
create table driver(driver_id varchar(20) primary key ,driver_name varchar(20) not null,
	driver_license varchar(20) not null , driver_email varchar(20) not null,
	driver_phonenumber varchar(20) not null,
	driver_validation varchar(20) default 'Active')



create table car(car_id varchar(20) primary key,driver_id varchar(20) not null,
	car_number varchar(20) not null, car_model varchar(20) not null, car_type varchar(20),
	foreign key(driver_id) references driver(driver_id))
	
	
create table booking(booking_id varchar(20) primary key,
	car_id varchar(20) not null ,user_id varchar(20) ,
	booking_date date not null, booking_time time not null,
	booking_distance integer not null , booking_startpoint varchar(30)  not null,
	booking_endpoint varchar(40), booking_status varchar(20) , booking_amount integer,
	foreign key(car_id) references car(car_id),
	foreign key(user_id) references users(user_id))

	
create table transaction(transaction_id varchar(20) not null, 
	user_id varchar(20) not null , booking_id varchar(20) not null,
	tranaction_time timestamp default current_timestamp,
	transaction_status varchar(10) default 'Successful',
	tranaction_amount int, 
	foreign key(user_id) references users(user_id),
	foreign key(booking_id) references booking(booking_id))
	
	
create table locations( location_id serial,starting_point varchar(20),ending_point varchar(20), location_cost int)
