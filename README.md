# AuthConfigration
Auth configration from scratch in Java

Run This Sql query in work bench

create database hospital;
use hospital;
CREATE TABLE `users_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO users_seq (`next_val`) VALUES(0);

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUsersSeqNextVal`()
BEGIN
    UPDATE users_seq
    SET next_val = next_val + 1;
    SELECT next_val FROM users_seq;
END$$
DELIMITER ;

# And fix file path in application.properties file 
