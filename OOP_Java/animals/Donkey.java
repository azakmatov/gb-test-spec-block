package animals;
import base.PackAnimals; // 2️⃣ Импортируем родительский класс из пакета "base"
public class Donkey extends PackAnimals {
    public Donkey(String name, String birthDate) {
        super(name, birthDate);
    }
}
