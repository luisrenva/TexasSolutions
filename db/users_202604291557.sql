-- home.users definition

CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `created_date` date DEFAULT NULL,
  `application_id` int DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `users_unique` (`username`),
  KEY `users_application_FK` (`application_id`),
  CONSTRAINT `users_application_FK` FOREIGN KEY (`application_id`) REFERENCES `application` (`application_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


insert into home.users (username, password, created_date, application_id)
values('luisrenva', '', '2026-04-30', 1);
