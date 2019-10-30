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
	emplacement varchar(14) primary key,
	volume int,
	VolumeMax int,
	poids int,
	poidsMax int,
	EmplacementParent varchar(14),
	foreign key (EmplacementParent) references container(emplacement) on delete cascade
);
create table item(
	idItem int primary key auto_increment,
	idItemInfo int not null,

	description varchar(255),
	quantite int not null default 1,
	foreign key (idItemInfo) references itemInfo(idItemInfo) on delete cascade,
	foreign key (idContainer) references container(idContainer) on delete cascade
);
insert into container values("Entrepot", 0, 0, 0, 0, null);
    insert into container values("R0", 0, 0, 0, 0, "Entrepot");
    insert into container values("R1", 0, 0, 0, 0, "Entrepot");
    insert into container values("R2", 0, 0, 0, 0, "Entrepot");
    insert into container values("R3", 0, 0, 0, 0, "Entrepot");
    insert into container values("R4", 0, 0, 0, 0, "Entrepot");
    insert into container values("R5", 0, 0, 0, 0, "Entrepot");
    insert into container values("R6", 0, 0, 0, 0, "Entrepot");
    insert into container values("R7", 0, 0, 0, 0, "Entrepot");

    insert into container values(default , "E0", 0, 0, 0, 0, "R0");
    insert into container values(default , "E1", 0, 0, 0, 0, "R0");
    insert into container values(default , "E2", 0, 0, 0, 0, "R0");
    insert into container values(default , "E3", 0, 0, 0, 0, "R0");
    insert into container values(default , "E4", 0, 0, 0, 0, "R0");
    insert into container values(default , "E5", 0, 0, 0, 0, "R0");
    insert into container values(default , "E6", 0, 0, 0, 0, "R0");
    insert into container values(default , "E7", 0, 0, 0, 0, "R0");



insert into itemInfo values('1', 'bleu', 'clou', '1', '1');
insert into itemInfo values('2', 'bleu', 'chaussure', '1', '1');
insert into itemInfo values('3', 'bleu', 'ordinateur', '1', '1');
insert into itemInfo values('4', 'bleu', 'vis', '1', '1');
insert into item values('1', '1', '1', 'Clou avec un bout piquant');
insert into item values('2', '1', '1', 'Clou pas piquant');
insert into item values('3', '3', '1', null);
insert into item values('4', '2', '1', null);
