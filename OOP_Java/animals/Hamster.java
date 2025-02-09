package animals;
import base.Pets; // 2️⃣ Импортируем родительский класс из пакета "base"
public class Hamster extends Pets {
    public Hamster(String name, String birthDate) {
        super(name, birthDate);
    }
}
