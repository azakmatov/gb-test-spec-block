package animals;
import base.Pets; // 2️⃣ Импортируем родительский класс из пакета "base"
public class Cat extends Pets {
    public Cat(String name, String birthDate) {
        super(name, birthDate);
    }
}
