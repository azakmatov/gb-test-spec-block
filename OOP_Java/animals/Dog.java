package animals;
import base.Pets; // 2️⃣ Импортируем родительский класс из пакета "base"
// 📌 Конкретные виды животных 🐶🐱🐴🐪
public class Dog extends Pets {
    public Dog(String name, String birthDate) {
        super(name, birthDate);
    }
}
