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

