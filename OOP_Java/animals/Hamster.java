package animals;
import java.time.LocalDate;
import base.Pets; // 2️⃣ Импортируем родительский класс из пакета "base"
public class Hamster extends Pets {
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
