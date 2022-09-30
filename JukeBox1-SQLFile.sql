create database JukeBox1;
use JukeBox1;

create table Songs( 
songID int auto_increment primary key,
songName varchar(50) unique not null,
artistName varchar(50) not null,
genre varchar(50) not null,
album varchar(50) not null,
duration float not null
);

insert into Songs(songName,artistName,genre,album,duration) values('Akdi Pakdi','Anurag Kulkarni','Pop','Liger', 3.50);
insert into Songs(songName,artistName,genre,album,duration) values('Inthandhaam','SPB Charan','Love','Seetha Ramam', 3.38);
alter table Songs auto_increment=2000;

create table PlayList( 
PlayListID int auto_increment primary key,
playListName varchar(50) not null);
alter table PlayList auto_increment=1;
insert into PlayList(playListName) values('Folk Songs');

Create table PlayListContent(
PlayListId int,
SongId int,
foreign key(playListID) references PlayList(PlayListID),
foreign key(SongId) references Songs(songID),
primary key(PlayListId, SongId));

insert into PlayListContent values(1,2000);

select*from PlayList;
select*from PlayListContent where PlayListId=1;
select*from PlayListContent;
select*from Songs;

delete from Songs;
delete from PlayList;
delete from PlayListContent;

drop table songs;
drop table playlist;
drop table playlistcontent;
