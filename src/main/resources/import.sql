insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (1,'Keith','Keith','Melbourne','password','keith@melbourne.com', '2016-01-01 20:08:08', true);
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (2,'Jean','Jean','Darko','password','Jean@Darko.com', '2016-01-01 20:08:08', true)
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (3,'Jack','Jack','Petit','password','Jack@Petit.com', '2016-01-01 20:08:08' , true)
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (4,'Paul','Paul','Dupont','password','Paul@Dupont.com', '2016-01-01 20:08:08', true)
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (5,'Henry','Henry','Deril','password','Henry@Deril.com', '2016-01-01 20:08:08' , true)
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (6,'Pierre','Pierre','Perme','password','Pierre@Perme.com', '2016-01-01 20:08:08', true)
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (7,'Julie','Julie','Mous','password','Julie@Mous.com', '2016-01-01 20:08:08' , false)
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (8,'Sandra','Sandra','Treboi','password','Sandra@Treboi.com', '2016-01-01 20:08:08', false)
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (9,'Marie','Marie','Suilard','password','Marie@Suilard.com', '2016-01-01 20:08:08' , false)
insert into account (id,username,firstname,lastname,password,email,desactivation_date,enabled) values (10,'Chris','Chris','Bourdet','password','Chris@Bourdet.com', '2016-01-01 20:08:08', false)
insert into address (id,line1,line2,zipcode,city,state,account) values (1,'14 rue thionville', null, '75001', 'Paris', 'France',1)
insert into address (id,line1,line2,zipcode,city,state,account) values (2,'12 rue truc', null, '75001', 'Paris', 'France',1)
insert into address (id,line1,line2,zipcode,city,state,account) values (3,'4 rue tarl', null, '65001', 'Nevers', 'France', 1)
insert into address (id,line1,line2,zipcode,city,state,account) values (4,'19 rue regard', null, '75002', 'Paris', 'France',2)
insert into address (id,line1,line2,zipcode,city,state,account) values (5,'114 rue malin', null, '75003', 'Paris', 'France',3)
insert into address (id,line1,line2,zipcode,city,state,account) values (6,'40 rue chose', null, '65002', 'Nevers', 'France', 4)
insert into address (id,line1,line2,zipcode,city,state,account) values (7,'1 rue parit', null, '22580', 'Plouha', 'France',5)
insert into address (id,line1,line2,zipcode,city,state,account) values (8,'14 du trou', null, '22580', 'Plouha', 'France',6)
insert into address (id,line1,line2,zipcode,city,state,account) values (9,'5 rue poul', null, '12000', 'Poitier', 'France', 7)
insert into address (id,line1,line2,zipcode,city,state,account) values (10,'6 avenue moil', null, '10000', 'Toulouse', 'France', 8)
insert into address (id,line1,line2,zipcode,city,state,account) values (11,'4 rue thorg', null, '32500', 'Nantes', 'France', 9)
insert into address (id,line1,line2,zipcode,city,state,account) values (12,'4 rue poile', null, '26000', 'Lilles', 'France', 10)
insert into customer (id,username, name) values (1,'keith', 'Keith')
insert into customer (id,username, name) values (2,'erwin', 'Erwin')
insert into customer (id,username, name) values (3,'jeremy', 'Jeremy')
insert into customer (id, username, name) values (4,'scott', 'Scott')
insert into hotel (id, price, name, address, city, state, zip, country) values (1, 199, 'Westin Diplomat', '3555 S. Ocean Drive', 'Hollywood', 'FL', '33019', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (2, 60, 'Jameson Inn', '890 Palm Bay Rd NE', 'Palm Bay', 'FL', '32905', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (3, 199, 'Chilworth Manor', 'The Cottage, Southampton Business Park', 'Southampton', 'Hants', 'SO16 7JF', 'UK')
insert into hotel (id, price, name, address, city, state, zip, country) values (4, 120, 'Marriott Courtyard', 'Tower Place, Buckhead', 'Atlanta', 'GA', '30305', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (5, 180, 'Doubletree', 'Tower Place, Buckhead', 'Atlanta', 'GA', '30305', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (6, 450, 'W hotel', 'Union Square, Manhattan', 'NY', 'NY', '10011', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (7, 450, 'W hotel', 'Lexington Ave, Manhattan', 'NY', 'NY', '10011', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (8, 250, 'hotel Rouge', '1315 16th Street NW', 'Washington', 'DC', '20036', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (9, 300, '70 Park Avenue hotel', '70 Park Avenue', 'NY', 'NY', '10011', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (10, 300, 'Conrad Miami', '1395 Brickell Ave', 'Miami', 'FL', '33131', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (11, 80, 'Sea Horse Inn', '2106 N Clairemont Ave', 'Eau Claire', 'WI', '54703', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (12, 90, 'Super 8 Eau Claire Campus Area', '1151 W Macarthur Ave', 'Eau Claire', 'WI', '54701', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (13, 160, 'Marriot Downtown', '55 Fourth Street', 'San Francisco', 'CA', '94103', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (14, 200, 'Hilton Diagonal Mar', 'Passeig del Taulat 262-264', 'Barcelona', 'Catalunya', '08019', 'Spain')
insert into hotel (id, price, name, address, city, state, zip, country) values (15, 210, 'Hilton Tel Aviv', 'Independence Park', 'Tel Aviv', '', '63405', 'Israel')
insert into hotel (id, price, name, address, city, state, zip, country) values (16, 240, 'InterContinental Tokyo Bay', 'Takeshiba Pier', 'Tokyo', '', '105', 'Japan')
insert into hotel (id, price, name, address, city, state, zip, country) values (17, 130, 'hotel Beaulac', ' Esplanade Leopold-Robert 2', 'Neuchatel', '', '2000', 'Switzerland')
insert into hotel (id, price, name, address, city, state, zip, country) values (18, 140, 'Conrad Treasury Place', 'William & George Streets', 'Brisbane', 'QLD', '4001', 'Australia')
insert into hotel (id, price, name, address, city, state, zip, country) values (19, 230, 'Ritz Carlton', '1228 Sherbrooke St', 'West Montreal', 'Quebec', 'H3G1H6', 'Canada')
insert into hotel (id, price, name, address, city, state, zip, country) values (20, 460, 'Ritz Carlton', 'Peachtree Rd, Buckhead', 'Atlanta', 'GA', '30326', 'USA')
insert into hotel (id, price, name, address, city, state, zip, country) values (21, 220, 'Swissotel', '68 Market Street', 'Sydney', 'NSW', '2000', 'Australia')
insert into hotel (id, price, name, address, city, state, zip, country) values (22, 250, 'Melia White House', 'Albany Street', 'Regents Park London', '', 'NW13UP', 'Great Britain')
insert into hotel (id, price, name, address, city, state, zip, country) values (23, 210, 'hotel Allegro', '171 West Randolph Street', 'Chicago', 'IL', '60601', 'USA')