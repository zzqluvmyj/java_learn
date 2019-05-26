public abstract class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected String name;

    public abstract String getDescription();

    public Person(String name){
        this.name=name;
    }

}
