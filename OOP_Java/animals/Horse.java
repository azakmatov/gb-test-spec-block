package animals;
import base.PackAnimals; // 2️⃣ Импортируем родительский класс из пакета "base"
public class Horse extends PackAnimals {
    public Horse(String name, String birthDate) {
        super(name, birthDate);
    }
}
