# gb-test-spec-block
Final test on the specialization block

Это моя работа по сдаче **Итоговой контрольной работы по блоку специализация**

1. Сначала создал репозиторий гитхаб: https://github.com/azakmatov/gb-test-spec-block.git
2. Потом клонировал этот репозиторий в локальную папку на ноутбуке с операционной системой ubuntu 22.04
3. В терминале на этой директории командой cat создал два файла: PackAnimals.txt, Pets.txt и объединил эти файлы в файл DirHumanFriends/HumanFriends.txt
4. Установил mysql со стороннего репозитория согласно инструкции: https://pq.hosting/help/ustanavlivaem-mysql-v-ubuntu-2204-iz-repozitorija-razrabotchika, установил программу с использованием dpkg: sudo dpkg -i /home/iceberg/Загрузки/DbSchema_linux_9_6_5.deb и обратно его удалил sudo dpkg -r /home/iceberg/Загрузки/DbSchema_linux_9_6_5.deb
5. Сохранил вывод всей истории выполненных команд в терминале командой: history > AkmatovAzizbeOsmonalievich08feb2025JavaBackend.txt
6. Нарисовал диаграмму согласно заданию в draw.io и загрузил эту диаграмму здесь же в файл PackPets.drawio.html
7. Полностью выполнил задание 7 и выложил всю базу данных mysql здесь же в папке *mysql_database/docker_db*. Также в директории *mysql_database/database_backup* выложил бэкапы таблиц и представлений в виде скриптов sql и выложил заполненные данные таблиц в виде csv-файлов. Дополнительно в docker-compose.yaml файлах и в самой системе перепробовал разные варианты использования mysql & adminer, mysql & mysql workbench, mysql & mysql & phpmyadmin, mysql & dbeaver ce
  7.1. Создал базу данных *human_friends*, а в ней таблицы: table_animals, table_type_animals, table_home_animals в соответствии с диаграммой в 6-задании.
  7.2. Заполнил таблицы согласно заданию, создал представление, в котором показаны вьючные животные без верблюдов, то есть там есть данные лошадей и ослов, как по заданию. Создал представление, показывающее возраст животных количеством месяцев, а также в одной колонке отдельно сколько лет, сколько месяцев и сколько точно дней с учётом високосных лет и месяцев с днями 30 и 31. Также создал представление, где показываются животные в возрасте от 1 до 3 лет с точностью до месяца и, как оказалось, все животные старше трёх лет ). Все пункты этого задания выполнил.
8. Создал иерархию классов в Java, повторяющий диаграмму классов, созданную в задаче 6(Диаграмма классов).
9. Написал программу на Java, которая имитирует реестр домашних животных. Весь функционал реализовал согласно заданию:
	* добавление нового животного в правильный класс
	* вывов списка команд, которые может выполнять добавленное животное (например, "сидеть", "лежать")
	* добавил возможность обучать животных новым командам 
	* есть возможность вывода списка животных по дате рождения
	* реализовал консольный пользовательский интерфейс с меню для навигации между вышеуказанными функциями
	* создал механизм, позволяющий вывод на экран общее количество созданных животных любого типа (как домашних, так и вьючных), то есть при создании каждого нового животного счетчик увеличивается на “1”.

Все файлы программы реестра домашних животных находится в директории OOP_Java

На всякий случай покажу структуру проекта этой программы в трёх способах, выводимой в терминале командой: tree OOP_Java/
<pre>
📦OOP_Java
 ┣ 📂animals
 ┃ ┣ 📜Camel.java
 ┃ ┣ 📜Cat.java
 ┃ ┣ 📜Dog.java
 ┃ ┣ 📜Donkey.java
 ┃ ┣ 📜Hamster.java
 ┃ ┗ 📜Horse.java
 ┣ 📂base
 ┃ ┣ 📜Animal.java
 ┃ ┣ 📜PackAnimals.java
 ┃ ┗ 📜Pets.java
 ┣ 📂out
 ┃ ┣ 📂animals
 ┃ ┃ ┣ 📜Camel.class
 ┃ ┃ ┣ 📜Cat.class
 ┃ ┃ ┣ 📜Dog.class
 ┃ ┃ ┣ 📜Donkey.class
 ┃ ┃ ┣ 📜Hamster.class
 ┃ ┃ ┗ 📜Horse.class
 ┃ ┣ 📂base
 ┃ ┃ ┣ 📜Animal.class
 ┃ ┃ ┣ 📜PackAnimals.class
 ┃ ┃ ┗ 📜Pets.class
 ┃ ┗ 📜Main.class
 ┗ 📜Main.java



OOP_Java/
|
+-- _animals
|   +-- Camel.java
|   +-- Cat.java
|   +-- Dog.java
|   +-- Donkey.java
|   +-- Hamster.java
|   +-- Horse.java
+-- _base
|   +-- Animal.java
|   +-- PackAnimals.java
|   +-- Pets.java
+-- Main.java
|-- _out
    +-- _animals
    |   +-- Camel.class
    |   +-- Cat.class
    |   +-- Dog.class
    |   +-- Donkey.class
    |   +-- Hamster.class
    |   +-- Horse.class
    +-- _base
    |   +-- Animal.class
    |   +-- PackAnimals.class
    |   +-- Pets.class
    +-- Main.class
    
OOP_Java/
├── animals
│   ├── Camel.java
│   ├── Cat.java
│   ├── Dog.java
│   ├── Donkey.java
│   ├── Hamster.java
│   └── Horse.java
├── base
│   ├── Animal.java
│   ├── PackAnimals.java
│   └── Pets.java
├── Main.java
└── out
    ├── animals
    │   ├── Camel.class
    │   ├── Cat.class
    │   ├── Dog.class
    │   ├── Donkey.class
    │   ├── Hamster.class
    │   └── Horse.class
    ├── base
    │   ├── Animal.class
    │   ├── PackAnimals.class
    │   └── Pets.class
    └── Main.class

5 directories, 20 files

</pre>

Здесь, для наглядности структуры проекта в терминале я собирал это добро командой: javac -d out base/*.java animals/*.java Main.java 
Поэтому для запуска этой программы в директории OOP_Java выполняем команду: java -cp out Main
Таким образом собирал я этот проект, чтобы скомпилированные файлы *.class находились в другой директории от файлов *.java а также отделать базовые классы от классов animal и отделить главный класс Main.

В общем, думаю, что выполнил задание, но, в любом случае, я открыт к обратной связи. Благодарю за внимание! Спасибо!
	
