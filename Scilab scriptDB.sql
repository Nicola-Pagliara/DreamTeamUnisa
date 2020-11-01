drop database if exists  SciLab_DB ;
create database SciLab_DB;
use SciLab_DB;

create table Utente(
				Id_user int not null,
				Nome varchar (20) not null,
				Cognome varchar(20) not null,
				username varchar(20) not null,
                passwordhash varchar(50) not null,
                email varchar(25) not null,
                Immagine varchar(40) default null,
                primary key(username,passwordhash),
                unique key(Id_user)
                );


create table Admin(
				id_admn int not null,
				admin_user varchar(20) not null,
                adminpasshash varchar(50) not null,
                privilage boolean default true,
                primary key(admin_user,adminpasshash)
				);

create table Category(
                         Id_category int not null,
                         category_name varchar(25) not null,
                         cat_description varchar(200) not null,
                         img_category varchar(25) not null,
                         primary key(Id_category)
                        );

create table Product(
				Id_product int not null,
                name_product varchar(40) not null,
                short_descripton varchar(60),
                long_description varchar(250),
                width_prod double,
                height_prod double,
                price double not null,
                bookmarked boolean not null default false,
                qty_product int not null,
                primary key(Id_product)
                );

create table Shipping_cart(
                              Id_sc int not null,
                              Id_usr int not null,
                              Id_prd int not null ,
                              Id_cat int not null ,
                              Total_price double not null,
                              qty_product int not null,
                              primary key(Id_sc,Id_prd,Id_usr,Id_cat),
                              foreign key(Id_usr) references Utente(Id_user),
                              foreign key (Id_prd) references Product(Id_product),
                              foreign key (Id_cat) references Category(Id_category)
                              );

create table Preference(
                    Id_client int not null,
                    Id_prod int not null,
                    primary key (Id_client,Id_prod),
                    foreign key (Id_client) references Utente(Id_user),
                    foreign key (Id_prod) references Product(Id_product)
                    );

create table Orders(
				Id_orders int not null,
                Id_us int not null,
                orders_date date not null,
                orders_name varchar(20) not null,
                status_order varchar(10) not null,
                tot_price double not null,
                primary key(Id_orders)
                );

create table Shipment(
				Id_ship int not null,
                Id_orderi int not null,
                Id_usr int not null,
                name_ship varchar(15) not null,
                Type_ship varchar(10) not null,
                time_ship varchar(10) not null,
                primary key(Id_ship,Id_orderi,Id_usr),
                foreign key(Id_orderi) references Orders(Id_orders),
                foreign key (Id_usr) references Utente(Id_user)
                );

create table Payment(
				Id_payment int not null,
                Id_ord int not null,
                name_pay varchar(20) not null,
                type_pay varchar(20) not null,
                date_pay date not null,
                total_pay double not null,
                primary key(Id_payment),
                foreign key(Id_ord) references Orders(Id_orders)
                );

create table CategoryProd(
					Id_prod int not null,
                    Id_Cat int not null,
                    primary key(Id_prod,Id_Cat),
                    foreign key(Id_prod) references Product(Id_product),
                    foreign key(Id_Cat) references Category(Id_category)
                    );
create table OrderProd (
                           Id_order int not null,
                           Id_prod int not null,
                           primary key(Id_order,Id_prod),
                           foreign key(Id_order) references Orders(Id_orders),
                           foreign key(Id_prod) references Product(Id_product)
);

INSERT INTO Product value (15,'Alambicco chimico','alambicco chimico proviente dalla russia',null,0,0,50.75,default,4);
INSERT INTO Category value (01,'Strumenti fisici','Sono elencati tutti gli strumenti fisici','PhyscicsIcon');
INSERT INTO Category value (02,'Strumenti chimici','Sono elencati tutti gli strumenti chimici','ChimestryIcon');
Insert INTO Category value(03,'Strumenti informatici','Sono elencati tutti gli strumenti informatici','ComputerScienceIcon');
Insert into Category value (04,'Strumenti matematici','Sono elencati tutti gli strumenti matematici','MathIcon');
INSERT INTO CategoryProd value (15,01);
                
                
                
                
                
                
					

                
                
                
				

	
            
            
            
                
				
