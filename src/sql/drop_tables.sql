select table_name from information_schema.tables
where table_schema = 'public';

drop table model CASCADE;

drop table brand cascade;

drop table configuration cascade;

drop table request cascade;

drop table manager cascade;

drop table passwords cascade;