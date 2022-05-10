
INSERT INTO les_informations (identifiant,numero,texte) VALUES (1,1,'Allô est-ce que quelqu’un reçoit ces messages ?');
INSERT INTO les_informations (identifiant,numero,texte) VALUES (2,2,'Raaaaah saleté de téléphone j’y comprend rien ');
INSERT INTO les_informations (identifiant,numero,texte) VALUES (4,4,'Il faut que vous m’aidiez,');
INSERT INTO les_informations (identifiant,numero,texte) VALUES (5,5,'je suis tombé dans un trou bizarre et là je suis dans une ville bizarre avec des gens bizarres habillés avec des draps la.');
INSERT INTO les_informations (identifiant,numero,texte) VALUES (6,6,'Je suis ou vous pensez sur un tournage de film bizarre ?');

INSERT INTO les_questions (identifiant,numero,description,label) VALUES (1,7,'Quel est le peuple ayant vécu à Grenoble au IIIème siècle ?','Question 1: Romains');

INSERT INTO les_materiels (identifiant,numero) VALUES (1,0);
INSERT INTO les_materiels (identifiant,numero) VALUES (2,0);
INSERT INTO les_materiels (identifiant,numero) VALUES (3,0);
INSERT INTO les_materiels (identifiant,numero) VALUES (4,0);


insert into les_textes (identifiant,numero,label) VALUES (1,0,'Les vikings');
insert into les_textes (identifiant,numero,label) VALUES (2,0,'Les kardashians');
insert into les_textes (identifiant,numero,label) VALUES (4,0,'Les incas');
insert into les_textes (identifiant,numero,label) VALUES (3,0,'Les romains');

INSERT INTO les_reponses(identifiant,bonne_reponse,materiel_identifiant) VALUES (1,false,1);
INSERT INTO les_reponses(identifiant,bonne_reponse,materiel_identifiant) VALUES (2,false,2);
INSERT INTO les_reponses(identifiant,bonne_reponse,materiel_identifiant) VALUES (3,false,3);
INSERT INTO les_reponses(identifiant,bonne_reponse,materiel_identifiant) VALUES (4,true,4);

INSERT INTO les_questions_reponses (les_questions_identifiant,reponses_identifiant)  VALUES (1,1);
INSERT INTO les_questions_reponses (les_questions_identifiant,reponses_identifiant)  VALUES (1,2);
INSERT INTO les_questions_reponses (les_questions_identifiant,reponses_identifiant)  VALUES (1,3);
INSERT INTO les_questions_reponses (les_questions_identifiant,reponses_identifiant)  VALUES (1,4);
