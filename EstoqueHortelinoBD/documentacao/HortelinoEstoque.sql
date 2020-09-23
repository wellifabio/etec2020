-- SGBD(MySQL-MariaDB) Início do script de criação do banco de dados Relacional
drop database if exists HortelinoEstoque;
create database HortelinoEstoque;
use HortelinoEstoque;

--Criamos as tabelas iniciando pelas tabelas FORTES
create table Products(
    id integer primary key auto_increment not null,
    name varchar(40) not null,
    descript varchar(200) not null,
    price decimal(8,2) not null,
    quantity integer not null
);
-- Criamos a tabela Fraca (1 para N) a tabela N é a fraca
create table Sales(
	n integer primary key auto_increment not null,
	dat date not null,
	hour time not null,
	id_prod integer not null,
	quantity integer not null,
	sales_price decimal(8,2)
);

-- Criamos o Relacionamento
alter table Sales add constraint fk_Sales_Prod foreign key (id_prod) references Products(id);

-- Criamos um gatilho que da baixa no estoque a cada vez que uma venda é realizada
create trigger tr_da_baixa_no_estoque after insert on sales
for each row
update Products
set quantity = quantity - new.quantity
where id = new.id_prod;

-- Criamos uma função que calcula o preço de venda
delimiter //
create function calc_sales_price(cod integer,qtd integer) returns decimal(8,2)
begin
return qtd * (select price from products where id = cod);
end//
delimiter ;


-- Para popular (Preencer o Banco de dados com Registros) para testar
insert into Products values
(default,"Porca","Porca",0.99,887),
(default,"Parafuso","Parafuso",2.9,690),
(default,"Prego","Prego",1.99,1000),
(default,"Prego","Prego Grande",0.1,780),
(default,"Luva pequena","Luva PVC",2.99,100),
(default,"Lâmpada Florecente","Lâmpada Florecente",6.45,98),
(default,"Lâpada Led","Lâmpadas de LED",18.3,300),
(default,"Chave de Fenda","Chave de Fenda Grande",13.45,98),
(default,"Parafuzo","Parafuzo Sextavado",10.0,100);

insert into Sales (dat,hour,id_prod,quantity,sales_price)
values
(curdate()-7,"13:20",2,100,calc_sales_price(2,100)),
(curdate()-7,"13:22",1,10,calc_sales_price(1,10)),
(curdate()-7,"13:23",4,20,calc_sales_price(4,20)),
(curdate()-6,"12:20",2,100,calc_sales_price(2,100)),
(curdate()-6,"14:22",3,10,calc_sales_price(3,10)),
(curdate()-6,"14:23",4,20,calc_sales_price(4,20)),
(curdate()-6,"06:20",5,10,calc_sales_price(5,10)),
(curdate()-5,"14:22",2,10,calc_sales_price(2,10)),
(curdate()-5,"06:23",6,20,calc_sales_price(6,20)),
(curdate()-5,"14:39",8,2,calc_sales_price(8,2)),
(curdate()-5,"14:46",4,30,calc_sales_price(4,30)),
(curdate()-4,"08:38",1,12,calc_sales_price(1,12)),
(curdate()-4,"09:22",2,10,calc_sales_price(2,10)),
(curdate()-4,"15:23",4,20,calc_sales_price(4,20)),
(curdate()-4,"07:20",2,100,calc_sales_price(2,100)),
(curdate()-3,"09:22",1,10,calc_sales_price(1,10)),
(curdate()-3,"09:23",4,20,calc_sales_price(4,20)),
(curdate()-3,"09:39",8,1,calc_sales_price(8,1)),
(curdate()-2,"10:46",7,100,calc_sales_price(7,100)),
(curdate()-1,"08:38",1,12,calc_sales_price(1,12)),
(curdate(),"08:38",1,12,calc_sales_price(1,12)),
(curdate(),"10:38",2,20,calc_sales_price(2,20));


