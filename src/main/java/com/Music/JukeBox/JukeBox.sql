create database JukeBox;
use JukeBox;

create table Songs( 
songID int primary key,
songName varchar(50) unique not null,
artistName varchar(50) not null,
genre varchar(50) not null,
album varchar(50) not null,
duration float not null
);

insert into Songs values(2000, 'Akdi Pakdi','Anurag Kulkarni','Pop','Liger', 3.50);
insert into Songs values(2001, 'Inthandhaam','SPB Charan','Love','Seetha Ramam', 3.38);

create table PlayList( 
PlayListID int primary key,
playListName varchar(50) not null);

insert into PlayList values(2, 'New Songs');

Create table PlayListContent(
PlayListId int,
SongId int,
foreign key(playListID) references PlayList(PlayListID),
foreign key(SongId) references Songs(songID),
primary key(PlayListId, SongId));

insert into PlayListContent values(1,2000);

select*from PlayList;
select*from PlayListContent where PlayListId=1;
select*from PlayListContent