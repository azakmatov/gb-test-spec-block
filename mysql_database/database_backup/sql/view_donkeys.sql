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
