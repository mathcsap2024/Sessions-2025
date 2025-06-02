package FunctionalProgramming;

public class NonStaticContainer {
    Integer value=20;

    public NonStaticContainer(Integer value) {
        this.value=value;
    }

//    static Integer max(Integer a, Integer b) {
//        return a;
//    }

//    static NonStaticContainer max(NonStaticContainer a, NonStaticContainer b) {
//        return new NonStaticContainer(Math.max(a.value, b.value));
//    }

    NonStaticContainer max(NonStaticContainer a) {
        return new NonStaticContainer(Math.max(this.value, a.value));
    }
}
