import base.*;
import animals.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// 📌 Главный класс программы
public class Main {
    private static final List<Animal> animalsRegistry = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Class<? extends Animal>> animalTypes = new HashMap<>();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // 📅 Формат даты

    // 🔹 Статический блок инициализации типов животных
    static {
        animalTypes.put("Dog", Dog.class);
        animalTypes.put("Cat", Cat.class);
        animalTypes.put("Hamster", Hamster.class);
        animalTypes.put("Horse", Horse.class);
        animalTypes.put("Camel", Camel.class);
        animalTypes.put("Donkey", Donkey.class);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n📋 Меню:");
            System.out.println("1. ➕ Добавить новое животное");
            System.out.println("2. 📜 Показать всех животных");
            System.out.println("3. 🐶 Добавить команду животному");
            System.out.println("4. 📋 Список команд животного");
            System.out.println("5. 🦸‍♀️ Выполнить команду животного");
            System.out.println("6. 🆕 Зарегистрировать новый тип животного");
            System.out.println("7. 📅 Показать список животных по дате рождения");
            System.out.println("8. 🔢 Вывести общее количество животных");
            System.out.println("9. ❌ Выход");
            System.out.print("Введите номер команды: ");

            int choice = getIntInput(); // Безопасный ввод числа

            switch (choice) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    showAllAnimals();
                    break;
                case 3:
                    addCommandToAnimal();
                    break;
                case 4:
                    showAnimalCommands();
                    break;
                case 5:
                    performAnimalCommand();
                    break;
                case 6:
                    registerNewAnimalType();
                    break;
                case 7:
                    showAnimalsByBirthDate();
                    break;
                case 8:
                    showTotalAnimalsCount();
                    break;
                case 9:
                    System.out.println("👋 Выход из программы...");
                    return;
                default:
                    System.out.println("❌ Ошибка: введите число от 1 до 9.");
            }
        }
    }

    // 🔹 Добавление нового животного
    private static void addNewAnimal() {
        System.out.println("🔹 Доступные типы животных: " + animalTypes.keySet());
        System.out.print("Введите тип животного: ");
        String type = scanner.nextLine();
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        
        LocalDate birthDate = getValidDateInput(); // 📅 Получаем корректную дату

        if (!animalTypes.containsKey(type)) {
            System.out.println("❌ Ошибка: этот тип животного не зарегистрирован.");
            return;
        }

        try {
            Animal newAnimal = animalTypes.get(type)
                    .getDeclaredConstructor(String.class, LocalDate.class) // 🟢 Конструктор теперь принимает LocalDate
                    .newInstance(name, birthDate);
            animalsRegistry.add(newAnimal);
            System.out.println("✅ " + newAnimal + " добавлен в реестр.");
        } catch (Exception e) {
            System.out.println("❌ Ошибка при создании животного: " + e.getMessage());
        }
    }

    // 🔹 Показать всех животных
    private static void showAllAnimals() {
        if (animalsRegistry.isEmpty()) {
            System.out.println("📭 Реестр пуст.");
        } else {
            System.out.println("📜 Список всех животных:");
            for (Animal animal : animalsRegistry) {
                System.out.println(animal);
            }
        }
    }

    // 🔹 Добавить команду животному
    private static void addCommandToAnimal() {
        Animal animal = selectAnimal();
        if (animal == null) return;

        System.out.print("Введите команду для обучения: ");
        String command = scanner.nextLine();
        animal.learnCommand(command, () -> 
            System.out.println(animal + " выполняет команду: " + command)
        );
    }

    // 🔹 Показать список команд животного
    private static void showAnimalCommands() {
        Animal animal = selectAnimal();
        if (animal == null) return;

        animal.showCommands();
    }

    // 🔹 Выполнить команду животного
    private static void performAnimalCommand() {
        Animal animal = selectAnimal();
        if (animal == null) return;

        System.out.print("Введите команду для выполнения: ");
        String command = scanner.nextLine();
        animal.executeCommand(command);
    }

    // 🔹 Выбор животного из списка
    private static Animal selectAnimal() {
        if (animalsRegistry.isEmpty()) {
            System.out.println("📭 В реестре нет животных.");
            return null;
        }

        System.out.println("🔹 Доступные животные:");
        for (int i = 0; i < animalsRegistry.size(); i++) {
            System.out.println((i + 1) + ". " + animalsRegistry.get(i));
        }

        System.out.print("Выберите животное (номер): ");
        int animalIndex = getIntInput() - 1;
        if (animalIndex < 0 || animalIndex >= animalsRegistry.size()) {
            System.out.println("❌ Ошибка: неверный выбор.");
            return null;
        }
        return animalsRegistry.get(animalIndex);
    }
    
    // 🔹 Зарегистрировать новый тип животного
    private static void registerNewAnimalType() {
        System.out.print("🆕 Введите название нового животного (пример: Chicken): ");
        String typeName = scanner.nextLine();
        System.out.print("📌 Это домашнее (Pets) или вьючное (PackAnimals) животное? (Pets/PackAnimals): ");
        String category = scanner.nextLine();

        if (animalTypes.containsKey(typeName)) {
            System.out.println("⚠️ Этот вид уже зарегистрирован.");
            return;
        }

        Class<? extends Animal> parentClass;
        if (category.equalsIgnoreCase("Pets")) {
            parentClass = Pets.class;
        } else if (category.equalsIgnoreCase("PackAnimals")) {
            parentClass = PackAnimals.class;
        } else {
            System.out.println("❌ Ошибка: неверная категория.");
            return;
        }

        animalTypes.put(typeName, parentClass);
        System.out.println("✅ Новый вид животного " + typeName + " успешно зарегистрирован!");
    }

    // 🔹 Показать список животных по дате рождения
    private static void showAnimalsByBirthDate() {
        LocalDate inputDate = getValidDateInput(); // 📅 Получаем корректную дату

        System.out.println("📅 Список животных с датой рождения " + inputDate + ":");
        boolean found = false;
        for (Animal animal : animalsRegistry) {
            if (animal.getBirthDate().equals(inputDate)) { // 🟢 Сравниваем LocalDate
                System.out.println(animal);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Нет совпадений.");
        }
    }

    // 🔹 Вывести общее количество животных
    private static void showTotalAnimalsCount() {
        System.out.println("🔢 Общее количество животных: " + Animal.getTotalCount());
    }

    // 🔹 Метод для безопасного ввода числа
    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("❌ Ошибка: введите корректное число: ");
            }
        }
    }
    
    // 🔹 Метод для безопасного ввода даты
    private static LocalDate getValidDateInput() {
        while (true) {
            System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
            String inputDate = scanner.nextLine().trim();

            try {
                return LocalDate.parse(inputDate, DATE_FORMATTER); // 🟢 Парсим LocalDate
            } catch (DateTimeParseException e) {
                System.out.println("❌ Ошибка: введите дату в формате ГГГГ-ММ-ДД.");
            }
        }
    }
}
