package client.data;

public interface CollectionAble extends Comparable<CollectionAble>, Validatable {

    public int getId();

    public int setId(int ID);

    public boolean validate();

    public int compareTo(CollectionAble city);

    public String getName();


}
