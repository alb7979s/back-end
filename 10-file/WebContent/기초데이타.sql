CREATE TABLE `member` (
  `id` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `profileName` varchar(100) DEFAULT NULL,
  `profilePath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `member_lang` (
  `id` varchar(20) NOT NULL,
  `lang` varchar(20) NOT NULL,
  PRIMARY KEY (`id`, `lang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `member_file` (
  `fileSeqNo` int NOT NULL auto_increment,
  `id` varchar(20) NOT NULL,
  `path` varchar(50) NOT NULL,
  `orgName` varchar(50) NOT NULL,
  `systemName` varchar(100) NOT NULL,
  `contentType` varchar(50),
  `size` LONG NOT NULL,
  PRIMARY KEY (`fileSeqNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;