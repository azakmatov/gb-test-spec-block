package animals;
import java.time.LocalDate;
import base.Pets; // 2️⃣ Импортируем родительский класс из пакета "base"
// 📌 Конкретные виды животных 🐶🐱🐴🐪
public class Dog extends Pets {
    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
