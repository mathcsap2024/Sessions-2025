package Annotations;

import java.lang.annotation.Documented;

@Author(name = "ali", age=10, nickNames = {""})
@Author(name = "ali2", age=10, nickNames = {""})
@Deprecated
public class Main {
    @Author(name = "ali", age=12, nickNames = {""})
    public static void main(String[] args) {
        String str;
    }
}
