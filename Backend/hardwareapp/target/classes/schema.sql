DROP TABLE IF EXISTS REVIEW;
DROP TABLE IF EXISTS HARDWARE;
DROP TABLE IF EXISTS USER_AUTHORITY;
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS AUTHORITY;

CREATE TABLE HARDWARE (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          code VARCHAR(250) NOT NULL,
                          name VARCHAR(250) NOT NULL,
                          price FLOAT NOT NULL,
                          type VARCHAR(250) NOT NULL,
                          availability INT
);

CREATE TABLE REVIEW (
                          id INT AUTO_INCREMENT  PRIMARY KEY,
                          title VARCHAR(250) NOT NULL,
                          content VARCHAR(250) NOT NULL,
                          rating INT NOT NULL,
                          id_hardware INT NOT NULL,
                          code VARCHAR(250) NOT NULL,
                          FOREIGN KEY (id_hardware) REFERENCES HARDWARE(id) ON DELETE CASCADE
);

CREATE TABLE USER (
                        id_user INT AUTO_INCREMENT  PRIMARY KEY,
                        username VARCHAR(250) NOT NULL,
                        user_password VARCHAR(250) NOT NULL
);

CREATE TABLE AUTHORITY (
                      id_authority INT AUTO_INCREMENT  PRIMARY KEY,
                      authority_name VARCHAR(250) NOT NULL
);

CREATE TABLE USER_AUTHORITY (
                           authority_id INT NOT NULL,
                           user_id INT NOT NULL,
                           FOREIGN KEY (user_id) REFERENCES USER(id_user),
                           FOREIGN KEY (authority_id) REFERENCES AUTHORITY(id_authority)
);


