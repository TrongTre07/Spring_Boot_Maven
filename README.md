docker compose ps

docker exec -it postgres bash

psql -U user

\l

\c customer

** Create table with command
INSERT INTO customer(id, name, email, age)
VALUES (nextval('customer_id_sequence'), 'Jalex', 'Rosa', 12);

** Structure Architect Rest API

** Annotation
@Scope("prototype"): tạo object mới khác địa chỉ
@Scope("singleton"): lấy cùng địa chỉ object đã tồn tại

@Autowired: tiêm object phụ thuộc thẳng vào luôn mà không cần khai báo new ở object phụ thuộc

@Primary: đặt là ưu tiên khi có 2 bean cần inject
@Qualifier: chọn bean nào là ưu tiên cho @Autowired

** 3 player architect

* Presentation : @Controller
* Business Logic : @Service
* Data Access : @Repository

@PathVariable
