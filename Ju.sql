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
