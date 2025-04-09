package Enums;

public enum Commands {
    Add(1),
    Remove(2),
    Edit(4);

    Integer value;

    Commands(Integer value) {
        this.value = value;
    }
}
