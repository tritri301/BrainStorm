drop table if exists item;
drop table if exists container;
drop table if exists itemInfo;

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
    emplacement varchar(14),
	description varchar(255),
	quantite int not null default 1,
	foreign key (idItemInfo) references itemInfo(idItemInfo) on delete cascade,
	foreign key (emplacement) references container(emplacement) on delete cascade
);
insert into container values("Entrepot", 0, 150, 0, 150, null);

insert into container values("R0-E0-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E0-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E0-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E0-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E0-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E0-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E1-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E1-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E1-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E1-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E1-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E1-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E2-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E2-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E2-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E2-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E2-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E2-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E3-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E3-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E3-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E3-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E3-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E3-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E4-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E4-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E4-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E4-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E4-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E4-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E5-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E5-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E5-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E5-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E5-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E5-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E6-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E6-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E6-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E6-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E6-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E6-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E7-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E7-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E7-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E7-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E7-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R0-E7-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E0-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E0-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E0-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E0-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E0-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E0-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E1-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E1-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E1-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E1-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E1-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E1-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E2-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E2-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E2-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E2-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E2-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E2-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E3-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E3-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E3-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E3-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E3-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E3-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E4-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E4-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E4-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E4-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E4-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E4-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E5-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E5-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E5-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E5-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E5-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E5-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E6-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E6-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E6-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E6-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E6-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E6-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E7-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E7-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E7-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E7-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E7-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R1-E7-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E0-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E0-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E0-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E0-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E0-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E0-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E1-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E1-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E1-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E1-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E1-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E1-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E2-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E2-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E2-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E2-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E2-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E2-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E3-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E3-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E3-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E3-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E3-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E3-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E4-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E4-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E4-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E4-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E4-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E4-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E5-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E5-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E5-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E5-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E5-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E5-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E6-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E6-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E6-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E6-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E6-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E6-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E7-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E7-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E7-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E7-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E7-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R2-E7-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E0-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E0-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E0-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E0-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E0-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E0-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E1-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E1-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E1-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E1-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E1-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E1-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E2-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E2-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E2-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E2-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E2-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E2-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E3-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E3-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E3-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E3-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E3-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E3-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E4-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E4-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E4-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E4-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E4-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E4-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E5-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E5-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E5-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E5-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E5-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E5-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E6-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E6-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E6-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E6-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E6-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E6-T5", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E7-T0", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E7-T1", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E7-T2", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E7-T3", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E7-T4", 0, 150, 0, 150, "Entrepot");
insert into container values("R3-E7-T5", 0, 150, 0, 150, "Entrepot");




insert into itemInfo values('1', 'bleu', 'clou', '1', '1');
insert into itemInfo values('2', 'bleu', 'chaussure', '1', '1');
insert into itemInfo values('3', 'bleu', 'ordinateur', '1', '1');
insert into itemInfo values('4', 'bleu', 'vis', '1', '1');

