-- human_friends.view_animals_1_3_aged исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_animals_1_3_aged` AS
SELECT
    `table_home_animals`.`id` AS `id`,
    `table_home_animals`.`name` AS `name`,
    `table_home_animals`.`id_type_animals` AS `id_type_animals`,
    `table_home_animals`.`birthdate` AS `birthdate`,
    `table_home_animals`.`commands` AS `commands`,
    round(((to_days(curdate()) - to_days(`table_home_animals`.`birthdate`)) / 30), 1) AS `age_in_months`
FROM
    `table_home_animals`
WHERE
    (round(((to_days(curdate()) - to_days(`table_home_animals`.`birthdate`)) / 30), 1) BETWEEN 12 AND 36);
-- human_friends.view_animals_age исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_animals_age` AS
SELECT
    `table_home_animals`.`id` AS `id`,
    `table_home_animals`.`name` AS `name`,
    `table_home_animals`.`id_type_animals` AS `id_type_animals`,
    `table_home_animals`.`birthdate` AS `birthdate`,
    `table_home_animals`.`commands` AS `commands`,
    round(((to_days(curdate()) - to_days(`table_home_animals`.`birthdate`)) / 30), 1) AS `age_in_months`,
    concat(timestampdiff(YEAR, `table_home_animals`.`birthdate`, curdate()), ' лет ',(timestampdiff(MONTH, `table_home_animals`.`birthdate`, curdate()) % 12), ' месяцев ',(to_days(curdate()) - to_days(((`table_home_animals`.`birthdate` + INTERVAL timestampdiff(YEAR, `table_home_animals`.`birthdate`, curdate()) YEAR) + INTERVAL (timestampdiff(MONTH, `table_home_animals`.`birthdate`, curdate()) % 12) MONTH))), ' дней') AS `age_years_months_days`
FROM
    `table_home_animals`;
-- human_friends.view_camels исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_camels` AS
SELECT
    `table_home_animals`.`name` AS `name`,
    `table_home_animals`.`id_type_animals` AS `id_type_animals`,
    `table_home_animals`.`birthdate` AS `birthdate`,
    `table_home_animals`.`commands` AS `commands`
FROM
    `table_home_animals`
WHERE
    (`table_home_animals`.`id_type_animals` = 'Camel');
-- human_friends.view_cats исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_cats` AS
SELECT
    `table_home_animals`.`name` AS `name`,
    `table_home_animals`.`id_type_animals` AS `id_type_animals`,
    `table_home_animals`.`birthdate` AS `birthdate`,
    `table_home_animals`.`commands` AS `commands`
FROM
    `table_home_animals`
WHERE
    (`table_home_animals`.`id_type_animals` = 'Cat');
-- human_friends.view_dogs исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_dogs` AS
SELECT
    `table_home_animals`.`name` AS `name`,
    `table_home_animals`.`id_type_animals` AS `id_type_animals`,
    `table_home_animals`.`birthdate` AS `birthdate`,
    `table_home_animals`.`commands` AS `commands`
FROM
    `table_home_animals`
WHERE
    (`table_home_animals`.`id_type_animals` = 'Dog');
-- human_friends.view_donkeys исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_donkeys` AS
SELECT
    `table_home_animals`.`name` AS `name`,
    `table_home_animals`.`id_type_animals` AS `id_type_animals`,
    `table_home_animals`.`birthdate` AS `birthdate`,
    `table_home_animals`.`commands` AS `commands`
FROM
    `table_home_animals`
WHERE
    (`table_home_animals`.`id_type_animals` = 'Donkey');
-- human_friends.view_hamsters исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_hamsters` AS
SELECT
    `table_home_animals`.`name` AS `name`,
    `table_home_animals`.`id_type_animals` AS `id_type_animals`,
    `table_home_animals`.`birthdate` AS `birthdate`,
    `table_home_animals`.`commands` AS `commands`
FROM
    `table_home_animals`
WHERE
    (`table_home_animals`.`id_type_animals` = 'Hamster');
-- human_friends.view_horses исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_horses` AS
SELECT
    `table_home_animals`.`name` AS `name`,
    `table_home_animals`.`id_type_animals` AS `id_type_animals`,
    `table_home_animals`.`birthdate` AS `birthdate`,
    `table_home_animals`.`commands` AS `commands`
FROM
    `table_home_animals`
WHERE
    (`table_home_animals`.`id_type_animals` = 'Horse');
-- human_friends.view_pack_animals_without_camel исходный текст

CREATE OR REPLACE
ALGORITHM = UNDEFINED VIEW `view_pack_animals_without_camel` AS
SELECT
    `temp_table_pack_animals`.`name` AS `name`,
    `temp_table_pack_animals`.`id_type_animals` AS `id_type_animals`,
    `temp_table_pack_animals`.`birthdate` AS `birthdate`,
    `temp_table_pack_animals`.`commands` AS `commands`
FROM
    `temp_table_pack_animals`
WHERE
    (`temp_table_pack_animals`.`id_type_animals` <> 'Camel');
