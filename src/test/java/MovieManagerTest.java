import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {


    @Test
    public void NoAdd() {

        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void AddOne() {

        MovieManager manager = new MovieManager();
        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void InTheOrderAdd() {

        MovieManager manager = new MovieManager();


        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Человек-невидимка");
        String[] expected = {"Бладшот", "Вперед", "Отель Белград", "Человек-невидимка"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void LimitMoreThan5() {

        MovieManager manager = new MovieManager(7);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");
        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель Белград", "Вперед", "Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void Limit5() {

        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперед");
        manager.addMovie("Отель Белград");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");
        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель Белград",};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void LimitLessThan5() {

        MovieManager manager = new MovieManager();

        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");
        manager.addMovie("Номер один");
        String[] expected = {"Номер один", "Тролли. Мировой тур", "Человек-невидимка"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);

    }

}
