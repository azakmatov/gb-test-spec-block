package base;
import java.util.*;

// 📌 Базовый класс "Animal" (Животное)
public abstract class Animal {
    String name;         // Имя животного
    String birthDate;    // Дата рождения животного
    private static int count = 0;  // Общий счётчик всех созданных животных
    Map<String, Runnable> commandsMap = new HashMap<>(); // Словарь команд с их действиями

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        count++;
    }

    String getType() {
        return "The " + this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return getType() + " " + name + " (Born: " + birthDate + ")";
    }

    public void learnCommand(String command, Runnable action) {
        if (!commandsMap.containsKey(command)) {
            commandsMap.put(command, action);
            System.out.println(this + " learned a new command: " + command);
        } else {
            System.out.println(this + " already knows the command: " + command);
        }
    }

    public void showCommands() {
        if (commandsMap.isEmpty()) {
            System.out.println(this + " doesn't know any commands yet.");
        } else {
            System.out.println(this + " knows the following commands: " + commandsMap.keySet());
        }
    }

    // Исправленный метод для выполнения команды
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

    public String getBirthDate() {
        return this.birthDate;
    }

    public static int getTotalCount() {
        return count;
    }
}
