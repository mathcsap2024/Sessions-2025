package Enums;

public class Main {
    enum MainEnum {
        Add {
            @Override
            public void perform() {

            }
        },
        Remove {
            @Override
            public void perform() {

            }
        };

        public abstract void perform();
    }

    public static void main(String[] args) {
        MainEnum mainEnum = MainEnum.Add;
        mainEnum.perform();

        Commands command = Commands.Edit;
//        command = Commands.valueOf("Add");
        switch (command) {
            case Edit:
                break;
            case Remove:
                break;
        }
    }
}
