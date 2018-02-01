DROP TABLE IF EXISTS `rss`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `blog`;


CREATE TABLE `rss` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `init_update_date` varchar(255),
  `last_update_date` varchar(255),
  `url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `guid` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `pub_date` varchar(255) DEFAULT NULL,
  `tag` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `rss_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (rss_id) REFERENCES rss(id)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) NOT NULL,
  `category` varchar(255) NOT NULL,
  `description` varchar(1024) NOT NULL,
  `guid` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `pub_date` varchar(255) DEFAULT NULL,
  `tag` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `blog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (blog_id) REFERENCES blog(id)
) ENGINE=InnoDB AUTO_INCREMENT=452 DEFAULT CHARSET=utf8;
