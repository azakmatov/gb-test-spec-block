package animals;
import java.time.LocalDate;
import base.Pets; // 2️⃣ Импортируем родительский класс из пакета "base"
public class Cat extends Pets {
    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
