create table subscription
(
	subscription_id serial not null
		constraint subscription_pkey
			primary key,
	type varchar(10) not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(100) not null,
	image_source varchar
)
;

create unique index subscription_subscription_id_uindex
	on subscription (subscription_id)
;

create unique index subscription_email_uindex
	on subscription (email)
;

