package ferland.hugues.challenge.scabblesets;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class ScrabbleSets {

    public static void main(String[] args) {
        Bag bag = new Bag();

        try {
            System.out.println();
            System.out.println("Lettres présentes");
            outputLettersCount(bag);

            System.out.println();
            System.out.printf("Retrait de tuiles suivantes: %s%n", args[0]);
            args[0].chars().forEach(c -> bag.remove(c));

            System.out.println();
            System.out.println("Lettres restantes");
            outputLettersCount(bag);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void outputLettersCount(Bag bag) {
        bag.letters()
                .stream()
                .collect(groupingBy((c) -> bag.count(c)))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getKey() - e1.getKey())
                .filter(e -> e.getKey() > 0)
                .forEach((e) -> {
                    System.out.printf("%d: %s%n", e.getKey(), e.getValue().stream().sorted().map(o -> o.toString()).collect(joining(", ")));
                });
    }
}
