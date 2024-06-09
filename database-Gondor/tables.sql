create table T_produit(
    id serial primary key,
    reference varchar,
    libelle varchar,
    estDuJour boolean, 
    prix float,
    quantiteEnStock int
);