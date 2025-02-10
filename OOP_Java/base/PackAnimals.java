package base;
import java.time.LocalDate;
// 📌 Класс "PackAnimals" (Вьючные животные)
public abstract class PackAnimals extends Animal {
    public PackAnimals(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
