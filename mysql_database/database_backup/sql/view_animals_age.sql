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
