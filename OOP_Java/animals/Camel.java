package animals;
import base.PackAnimals; // 2️⃣ Импортируем родительский класс из пакета "base"
public class Camel extends PackAnimals {
    public Camel(String name, String birthDate) {
        super(name, birthDate);
    }
}
