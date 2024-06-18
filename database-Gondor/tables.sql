create table T_produit(
    id serial primary key,
    reference varchar,
    libelle varchar,
    estDuJour boolean, 
    prix float,
    quantiteEnStock int
);

create table T_client(
    id serial primary key,
    numero varchar,
    pseudo varchar,
    motDePasse varchar, 
    nom varchar,
    prenom varchar
);