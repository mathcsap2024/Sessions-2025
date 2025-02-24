public class Human {
    String name;
    private Integer ID;
    Double height;
    Foot rightFoot, leftFoot;
    Integer gitTest;
    Double gitDoubleTest;

    public Human(String name, Integer identity) {
        this.ID=ID;
        this.name=name;
        height=100.0;
        rightFoot = new Foot();
        leftFoot = new Foot();
    }

    class Foot {
        Double height;

        public Foot() {
            this.height=Human.this.height/2;
            ID=5;
        }
    }

    static class Medicine {

    }
}
