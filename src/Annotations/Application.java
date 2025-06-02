package Annotations;

import java.lang.reflect.Field;

public class Application implements Runnable{

    @Override
    public void run() {
        @Author(
                value = "123",
                name = "Hossein Boomari",
                age = 35,
                nickNames = {"Boomari", "Hima"}
        )
        @Author(
                value = "321",
                name = "Ali Rahmati",
                age = 32,
                nickNames = {"Ali"}
        )
        Book book=null;
    }
}
