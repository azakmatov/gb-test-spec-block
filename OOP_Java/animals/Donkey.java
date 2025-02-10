package animals;
import java.time.LocalDate;
import base.PackAnimals; // 2️⃣ Импортируем родительский класс из пакета "base"
public class Donkey extends PackAnimals {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
