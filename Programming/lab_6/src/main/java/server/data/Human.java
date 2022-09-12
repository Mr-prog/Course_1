package server.data;

public class Human implements Validatable {
    private Integer height; //Значение поля должно быть больше 0

    public Human(Integer height) {
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public boolean validate() {
        return (height > 0);
    }
}
