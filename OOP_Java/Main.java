import base.*;
import animals.*;
import java.util.*;
import java.text.*;
// 📌 Главный класс программы
public class Main {
    private static final List<Animal> animalsRegistry = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Class<? extends Animal>> animalTypes = new HashMap<>();

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
            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка после ввода числа

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
                    System.out.println("❌ Ошибка: неверный ввод, попробуйте снова.");
            }
        }
    }

    private static void addNewAnimal() {
        System.out.println("🔹 Доступные типы животных: " + animalTypes.keySet());
        System.out.print("Введите тип животного: ");
        String type = scanner.nextLine();
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        String birthDate = scanner.nextLine();

        if (!animalTypes.containsKey(type)) {
            System.out.println("❌ Ошибка: этот тип животного не зарегистрирован.");
            return;
        }

        try {
            Animal newAnimal = animalTypes.get(type)
                    .getDeclaredConstructor(String.class, String.class)
                    .newInstance(name, birthDate);
            animalsRegistry.add(newAnimal);
            System.out.println("✅ " + newAnimal + " добавлен в реестр.");
        } catch (Exception e) {
            System.out.println("❌ Ошибка при создании животного: " + e.getMessage());
        }
    }

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

    private static void addCommandToAnimal() {
        System.out.println("🔹 Доступные животные:");
        for (int i = 0; i < animalsRegistry.size(); i++) {
            System.out.println(i + 1 + ". " + animalsRegistry.get(i));
        }

        System.out.print("Выберите животное (номер): ");
        int animalIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (animalIndex < 0 || animalIndex >= animalsRegistry.size()) {
            System.out.println("❌ Ошибка: неверный выбор.");
            return;
        }

        System.out.print("Введите команду для обучения: ");
        String command = scanner.nextLine();
        animalsRegistry.get(animalIndex).learnCommand(command, () -> 
            System.out.println(animalsRegistry.get(animalIndex) + " performs the command: " + command)
        );
    }

    private static void showAnimalCommands() {
        System.out.println("🔹 Доступные животные:");
        for (int i = 0; i < animalsRegistry.size(); i++) {
            System.out.println(i + 1 + ". " + animalsRegistry.get(i));
        }

        System.out.print("Выберите животное (номер): ");
        int animalIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (animalIndex < 0 || animalIndex >= animalsRegistry.size()) {
            System.out.println("❌ Ошибка: неверный выбор.");
            return;
        }

        animalsRegistry.get(animalIndex).showCommands();
    }

    private static void performAnimalCommand() {
        System.out.println("🔹 Доступные животные:");
        for (int i = 0; i < animalsRegistry.size(); i++) {
            System.out.println(i + 1 + ". " + animalsRegistry.get(i));
        }

        System.out.print("Выберите животное (номер): ");
        int animalIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (animalIndex < 0 || animalIndex >= animalsRegistry.size()) {
            System.out.println("❌ Ошибка: неверный выбор.");
            return;
        }
        
        System.out.print("Введите команду для выполнения: ");
        String command = scanner.nextLine();

        animalsRegistry.get(animalIndex).executeCommand(command);
    }

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

    private static void showAnimalsByBirthDate() {
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД) для поиска: ");
        String inputDate = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date inputParsedDate;
        try {
            inputParsedDate = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("❌ Неверный формат даты.");
            return;
        }

        System.out.println("📅 Список животных с датой рождения " + inputDate + ":");
        boolean found = false;
        for (Animal animal : animalsRegistry) {
            if (animal.getBirthDate().equals(inputDate)) {
                System.out.println(animal);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Нет совпадений с данным днем рождения животных, попробуйте поискать по другой дате.");
        }
    }

    private static void showTotalAnimalsCount() {
        System.out.println("🔢 Общее количество животных: " + Animal.getTotalCount());
    }
}
