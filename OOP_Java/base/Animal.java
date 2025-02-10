package base;
import java.time.LocalDate;  // Импортируем LocalDate
import java.util.*;

// 📌 Базовый класс "Animal" (Животное)
public abstract class Animal {
    private String name;         // Имя животного
    private LocalDate birthDate; // Дата рождения животного теперь LocalDate
    private static int count = 0;  // Общий счётчик всех созданных животных
    private Map<String, Runnable> commandsMap = new HashMap<>(); // Словарь команд с их действиями

    // 📅 Конструктор с LocalDate для даты рождения
    public Animal(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        count++;
    }

    private String getType() {
        return "The " + this.getClass().getSimpleName().toLowerCase();
    }

    @Override
    public String toString() {
        return this.getType() + " " + this.name + " (borned: " + birthDate + ")";
    }

    // 📚 Метод для обучения команды
    public void learnCommand(String command, Runnable action) {
        if (!commandsMap.containsKey(command)) {
            commandsMap.put(command, action);
            System.out.println(this + " learned a new command: " + command);
        } else {
            System.out.println(this + " already knows the command: " + command);
        }
    }

    // 📜 Метод для отображения всех команд
    public void showCommands() {
        if (commandsMap.isEmpty()) {
            System.out.println(this + " doesn't know any commands yet.");
        } else {
            System.out.println(this + " knows the following commands: " + commandsMap.keySet());
        }
    }

    // 🔄 Метод для выполнения команды
    public void executeCommand(String command) {
        System.out.println("Trying to execute command: " + command);
        if (commandsMap.containsKey(command)) {
            // Выполнение команды
            System.out.println("Executing command: " + command);
            commandsMap.get(command).run();
        } else {
            // Если команда не найдена
            System.out.println(this + " doesn't know the command: " + command);
        }
    }

    // 📅 Метод для получения даты рождения
    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    // 🔢 Метод для получения общего количества животных
    public static int getTotalCount() {
        return count;
    }
}
