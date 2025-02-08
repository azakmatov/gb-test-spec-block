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
