drop table item;
drop table container;
drop table itemInfo;

create table itemInfo(
	idItemInfo int primary key,
	description varchar(255) not null,
	nom varchar(255) not null,
	poids int not null,
	volume int not null
);
create table container(
	idContainer int primary key,
	quantite int,
	position int,
	volume int,
	poidsMax int,
	idContainerParent int,
	foreign key (idContainerParent) references container(idContainer) on delete cascade
);
create table item(
	idItem int primary key,
	idItemInfo int not null,
	idContainer int not null,
	description varchar(255),
	foreign key (idItemInfo) references itemInfo(idItemInfo) on delete cascade,
	foreign key (idContainer) references container(idContainer) on delete cascade
);
insert into container values('1', null, null, null, null, null);
insert into itemInfo values('1', 'bleu', 'clou', '1', '1');
insert into item values('1', '1', '1', null);
