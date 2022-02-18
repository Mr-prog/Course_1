package Things;

public class BuildMaterials extends Materials {

    public BuildMaterials(double size, String name) throws InvalidSizeException {
        super(size, name);
        if (size <= 0) {
            throw new InvalidSizeException("Размер не может быть отрицательным");
        }
    }
}
