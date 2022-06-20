INSERT INTO HARDWARE (id, code, name, price, type, availability) VALUES
    (1, '1434' ,'Geforce GTX 1060', 121.75 , 'GPU', 122),
    (2, '2525' ,'Intel® Core™ i5-9400F', 170.99, 'CPU', 131),
    (3, '1111' ,'ASUS ROG Crosshair VIII Dark Hero', 449.99, 'MBO', 13);

INSERT INTO REVIEW (id, title, content, rating, id_hardware, code) VALUES
    (1, 'Utter rubbish :(' ,':(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(:(', 1, 3, '1111'),
    (2, 'Works, but meh' ,'meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh,meh', 3, 2, '2525'),
    (3, 'Amazing piece of hardware' ,'Amazing piece of hardware?Amazing piece of hardware?Amazing piece of hardware?Amazing piece of hardware?Amazing piece of hardware?', 5, 1, '1434'),
    (4, 'Very solid...' ,'solid...solid...solid...solid...solid...solid...solid...solid...solid...solid...solid...solid...solid...solid...', 4, 1, '1434');

INSERT INTO USER(id_user, username, user_password) VALUES
    (1, 'user', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
    (3, 'deleter', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
    (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin

INSERT INTO AUTHORITY(id_authority, authority_name) VALUES
    (1, 'ROLE_ADMIN'),
    (3, 'DELETER'),
    (2, 'ROLE_USER');

INSERT INTO USER_AUTHORITY(authority_id,user_id) VALUES
    (1, 2),
    (3, 3),
    (2, 1);