import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of("red", "orange", "yellow", "green", "blue", "indigo", "violet")
                .filter(s -> s.length() >= 5)
                .skip(2)
                .sorted()
                .forEachOrdered(System.out::print);
    }
}
reenndigoiolet
        ioletndigoreen