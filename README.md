[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7712201&assignment_repo_type=AssignmentRepo)
# l3m-PI-serveur : Partie serveur du Projet Intégrateur L3 MIAGE 2020-2021


## Mise en place du projet

Pour mettre en place ce serveur, nous utilisons maven,Java ainsi qu'heroku.
Il est donc important de les avoir installé.

Pour compiler ce code et le lancer utilisez les lignes suivantes : 
```sh
$ mvn clean install
$ heroku local:start
```
Nous utilisons aussi un database tournant avec postgresql.
Il faut donc aussi créer une base de donnée à l'aide de pgadmin par exemple.
Puis il faut modifier la ligne :
```
JDBC_DATABASE_URL=dbc:postgresql://HOST:PORT/DATABASE?sslmode=require&user=USER&password=PASSWORD
```
Dans application properties en changeant le HOST, le PORT ainsi que le DATABASE par le nom de la base de donnée utilisé, le USER par le nom
d'user utilisé et PASSWORD par le mot de passe utilisé dans la base de donnée.

Ce faisant l'application pourra se connecter à la base de donnée pour créer les tables utilisées ainsi que remplir ces tables avec le script de peuplement:Data.sql

## Arborescence de l'application

Cette Application est rangé dans plusieurs dossier :
Nous avons le dossier src contenant les fichiers principaux de notre serveur.

Dans ce dossier, nous avons le dossier main contenant les dossiers et fichiers principaux et le dossier tests contenant les tests que nous avons utilisé.

Dans le dossier main , nous avons le dossier ressource contenant le script de peuplement data.sql , le fichier application.properties contenant les settings de l'application puis nous avons le dossiers META-INF contenant le fichier persistence.xml qui permet de configurer les outils utilisés dans l'application.

Nous allons ensuite dans JAVA/com/exemple contenant les dossiers les plus important de l'application.
Dans un premier temps, nous avons RestServer.java qui est le main de notre application et qui nous permet de nous connecter a firebase.
Nous avons ensuite le dossier model contenant toutes les classes que nous utilisons.
Il y a aussi le dossier API contenant l'api que nous avons utilisé, la seule etant l'api Repository qui servira d'interface lors de la création des repository que nous utiliserons pour communiquer avec la base de donnée.
Ces repository sont contenus dans le dossiers repository.
Le dossier enum contient lui  les enumerations que nous utilisons dans nos classes.
Nous avons ensuite le dossiers ControllerEtService contenant les fichiers aux noms de chaques classes.
Ces dossiers contienent le controller ainsi que le service utilisé pour la classe.
Les controllers permettent aux clients d'intéragir avec la base à travers les requetes qui sont implementés, ils transforment les requetes HTTP en requete pour les services.
Les services, eux permettent d'interagir avec les repository qui interagissent eux mêmes avec la base de donnée.

## Model

### Les classes 
Nous utilisons un total de 15 classes avec chacun des getters et des setters pour tout les attributs sauf les identifiants.

Nous avons dans un premier temps la classe Arret, representant les arrets des lignes de tram, ayant pour attribut : l'identifiant(Integer), le code de l'arret(String), le nom de l'arret (String), la ligne du tram(String),la latitude(String), la longitude(String) et pour finir la liste des defis qui commencent à cet arret.

La classe Chamis, representant les utilisateurs de l'application surnommés chamis dans notre cadre, qui a pour attribut : l'email servant d'identifiant(String), le login(String), l'age(Integer), le boolean active representant si le chamis est actif et donc visible(Boolean), la ville du chamis(Ville), la liste de défis créée parce chamis, la liste de visite representant les defis auxquelles le chamis s'est essayé.

La classe défis represente les défis present dans notre base de donnée et a comme attributs : l'identifiant(Integer), le titre du défi(String), la description(String), le type de défi(Type), le mode du défi en presentiel ou en distanciel(Mode), les points totaux du défi(Integer), la duree(Integer), le commmentaire(String), la date de creation(String), la date de la derniere modification du defi(String), un boolean actif representant si le défi est visible et operationnel(Boolean), la liste de visite du defi, le prologue qui est une liste de materiel, l'epilogue qui est une liste de materiel, la liste des etapes du défi, la liste de motcles du defi, l'arret auquel le defi est rattaché.

La classe abstraite etape pour les classes information et question ayant pour attribut : l'identifiant(Integer), numero de l'étape(Integer).
La classe information qui étend etape et qui  a pour attribut un texte(String) ainsi qu'une liste d'indice utile pour cette information.
La classe question qui étend etape et qui a pour attribut : le label de la question(String), une description(String), une liste de réponse pour cette question, une liste d'indices.

Nous avons ensuite une classe materiel pour les classes Images, Textes et Video ayant pour attribut : l'identifiant(Integer), le numéro(Integer).
La classe Texte qui étend la classe matériel qui contient un label(String) representant un Texte.
La classe Video qui étend la classe matériel qui contient un label(String) ainsi qu'un lien(String) nous amenant vers le site hébergeant la vidéo utilisée.
La classe Image qui étend la classe matériel qui contient un label(String) ainsi qu'un chemin(String) nous amenant vers le site hébergeant la photo utilisée.

Il y a la classe Ville qui contient les villes ou l'application peut être utlisé avec comme attributs : identifiant(Integer) , ville(String) etant le nom de la ville.

On a aussi la classe visites representant l'utilisation d'un défi par un chamis avec comme attributs : l'identifiant(Integer), la date de la visite(String), l'heure de la visite(String), le mode(Mode), son status si elle est finis ou non(Statut),le score(Integer), le temps que le chamis à passé sur ce défis(Integer), un commentaire(String).

Pour finir, nous avons la classe Motclé representant les mots clés que nous pouvons rattaché aux défis avec comme attribut: un identifiant(Integer), le mot(String).


### Les enumerations 

Nous avons utilisé un total de 4 enumeration pour ce projet.

Nous avons l'enumération de mode avec comme valeur Distanciel et Presentiel. Pour symboliser comme ce défi peut être réalisé.

L'enumeration Statut represente le statut d'une visite avec comme valeur ABANDON, ENCOURS et REPONDU montrant si le chamis a abandonné ce défis , et entrant de le réaliser ou si il l'a finis.

On a le type de défi avec les valeurs CHALLENGE, ENIGME et ESCAPEGAME.

On a aussi le type de materiel avec comme valeur TEXTE, PHOTO et VIDEO.

## Controller et service 

Pour ce projet, nous avons implémentais les controllers et les services de chaque classes même si nous n'utilisons pas tout, nous avons jugé utile de tous les creer au cas ou nous avions besoin de certaines fonctions plus tard.
Chaque controller implemente au moins le get ainsi que le post.
Pour certain controller, nous avons aussi implémenter les méthodes pour update les valeurs de la base de donnée ainsi que les méthodes pour supprimer l'objet.
Les services implementent les fonctions nécessaires au bon fonctionnement des controllers.

## API HTTP

### api/arret

GET  api/arret/ : renvoie tout les arrets présents dans la base de donnée

GET api/arret/{identifiant} : nous renvoie l'arret ayant l'identifiant en entrée

POST api/arret/ : prend en entrée un arret dans le body pour l'ajouter à la base

PUT api/arret/ : prend en entrée un arret dans le body pour update le défi ayant le même identifiant dans la base pour qu'il prenne les attributs de l'arret en entrée

### api/chamis/

GET api/chamis/ : renvoie la liste de tous les chamis

GET api/chamis/{email} : renvoie le chamis ayant l'email en entrée

GET api/chamis/login/{chamisID} : renvoie un boolean, true si le login existe deja, false si le login n'existe pas 

POST api/chamis/ : prend un chamis en entrée dans le body pour l'ajouter à la base 

PUT api/chamis/ : prend un chamis en entrée dans le body pour update le chamis dans la base qui à le même identifiant pour qu'il ai les mêmes attributs que celui en entrée

DELETE api/chamis/ : prend un email en entrée dans le body pour, si le chamis ayant cet email existe, le rendre non visible en changeant le boolean en false.

### api/defis

GET api/defis/ : affiche tous le chamis present dans la base de donnée

POST api/defis/{email} : prend en entrée un défis dans le body pour l'ajouter à la base et l'ajouter à la liste de défi crée par le chamis ayant l'email en entrée

PUT api/defis : prend en entrée un défis dans le body pour update le defis dans la base ayant le même idenfiant pour qu'il ai les mêmes attributs

DELETE api/defis/motcle/{defi}/{mot} : retire le motclé {mot} de la liste de motclé contenue dans {défi}

PUT api/defis/motcle/{defi}/{mot} : ajoute le motclé {mot} de la liste de motclé contenue dans {défi}

DELETE api/defis/{id} : retire le defis en utilisant son identifiant.


### api/etape/

GET  api/etape/ : renvoie toutes les étapes présentes dans la base de donnée

GET api/etape/{identifiant} : nous renvoie l'etape ayant l'identifiant en entrée

POST api/etape/ : prend en entrée une étape dans le body pour l'ajouter à la base

PUT api/arret/ : prend en entrée une etape dans le body pour update l'étape ayant le même identifiant dans la base pour qu'elle prenne les attributs de l'etape en entrée

### api/image/

GET  api/image/ : renvoie toutes les images présentes dans la base de donnée

GET api/image/{identifiant} : nous renvoie l'image ayant l'identifiant en entrée

POST api/image/ : prend en entrée une image dans le body pour l'ajouter à la base

### api/indice/

GET  api/indice/ : renvoie tout les indices présents dans la base de donnée

GET api/indice/{identifiant} : nous renvoie l'indice ayant l'identifiant en entrée

POST api/indice/ : prend en entrée un indice dans le body pour l'ajouter à la base

### api/information/

GET  api/information/ : renvoie toutes les informations présentes dans la base de donnée

GET api/information/{identifiant} : nous renvoie l'information ayant l'identifiant en entrée

POST api/information/ : prend en entrée une information dans le body pour l'ajouter à la base

### api/materiel/

GET  api/materiel/ : renvoie tout les materiaux présents dans la base de donnée

GET api/materiel/{identifiant} : nous renvoie le materiel ayant l'identifiant en entrée

POST api/materiel/ : prend en entrée un materiel dans le body pour l'ajouter à la base

### api/motcle/

GET  api/motcle/ : renvoie tout les mots clés présents dans la base de donnée

GET api/motcle/word/{prefix} : renvoie une liste de mot ayant comme prefix le prefixe en entrée ( exemple si le prefix = 'bal', on aura la liste des mots commencant par bal comme balade ou ballerine.

POST api/motcle/{mot} : prend en entrée un mot pour l'ajouter à la base

### api/question/

GET  api/question/ : renvoie toutes les questions présentes dans la base de donnée

GET api/question/{identifiant} : nous renvoie la question ayant l'identifiant en entrée

POST api/question/ : prend en entrée une question dans le body pour l'ajouter à la base

PUT api/question/ : prend en entrée une question dans le body pour update l'étape ayant le même identifiant dans la base pour qu'elle prenne les attributs de la question en entrée

DELETE api/question/ : prend un identifiant en entrée dans le body pour supprimer la question correspondante à cet identifiant

### api/reponse/

GET api/reponse/ : renvoie la liste de toutes les réponses de la base de donnée

GET api/reponse/{id} : renvoie la reponse ayant l'identifiant en entrée 

POST api/reponse/ : rajoute une reponse dans la base de donnée 

DELETE api/reponse/ : prend en entrée un id dans le body pour supprimer la reponse correspondante

### api/texte/

GET api/texte/ : renvoie la liste de tout les textes

GET api/texte/{identifiant} : renvoie le texte ayant l'identifiant 

POST api/texte/ : rajoute un texte dans la base de donnée 

### api/video/

GET api/video/ :renvoie la liste de toutes les vidéos

GET api/video/{id} : renvoie la video ayant l'identifiant en entrée

POST api/video/ : prend une video en entrée dans le body pour l'ajouté dans la base 

DELETE api/video/{id} : supprime la video ayant l'identifiant id de la base de donnée 

### api/ville/

GET api/ville/ :renvoie la liste de toutes les villes

GET api/ville/{id} : renvoie la ville ayant l'identifiant en entrée

POST api/ville/ : prend une ville dans 

DELETE api/ville/{id} : supprime la ville ayant l'identifiant id de la base de donnée

### api/visite/

GET api/visite/ : renvoie la liste de toutes les visite dans la base de donnée 

GET api/visite/{id} : renvoie la visite avec l'identifiant en entrée

POST api/visite/ : ajoute la visite mise dans le body dans la base de donnée






This application supports the [Getting Started with Java on Heroku](https://devcenter.heroku.com/articles/getting-started-with-java) article - check it out.

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)



## Deploying to Heroku

Configure Heroku Deploying mode to GitHub so that you can automatically deploy on Heroku when pushing on GitHub.

## Documentation

For more information about using Java on Heroku, see these Dev Center articles:

- [Java on Heroku](https://devcenter.heroku.com/categories/java)



