package base;
import java.time.LocalDate;
// 📌 Класс "Pets" (Домашние животные)
public abstract class Pets extends Animal {
    public Pets(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
