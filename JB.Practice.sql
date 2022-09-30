create database JB;
use JB;

create table Songs( 
songID int auto_increment primary key,
songName varchar(50) unique not null,
artistName varchar(50) not null,
genre varchar(50) not null,
album varchar(50) not null,
duration float not null
);
//insert into Songs values(2000, 'Akdi Pakdi','Anurag Kulkarni','Pop','Liger', 3.50);
//insert into Songs values(2001, 'Inthandhaam','SPB Charan','Love','Seetha Ramam', 3.38);
insert into Songs(songName,artistName,genre,album,duration) values('Akdi Pakdi','Anurag Kulkarni','Pop','Liger', 3.50);
insert into Songs(songName,artistName,genre,album,duration) values('Inthandhaam','SPB Charan','Love','Seetha Ramam', 3.38);
alter table Songs auto_increment=2000;

create table PlayList( 
PlayListID int auto_increment primary key,
playListName varchar(50) not null);
//insert into PlayList values(1, 'Folk');
alter table PlayList auto_increment=1;
insert into PlayList(playListName) values('Folk Songs');

Create table PlayListContent(
PlayListId int,
SongId int,
foreign key(playListID) references PlayList(PlayListID),
foreign key(SongId) references Songs(songID),
primary key(PlayListId, SongId));

insert into PlayListContent values(2,2001);

select*from Songs;
select*from PlayList;
select*from PlayListContent where PlayListId=1;
select*from PlayListContent;

drop table Songs;
drop table PlayList;
drop table PlayListContent;