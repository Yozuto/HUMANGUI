public class Animal {
    String name;
    String species;
    String sound;
    int age;


    public Animal(String name, String species, String sound, int age) {
        this.name = name;
        this.species = species;
        this.sound = sound;
        this.age = age;
    }

    public String getInfo() {
        return "Name: " + name + "\n" +
               "Species: " + species + "\n" +
               "Age: " + age + " years\n" +
               "Sound: " + sound;
    }

    public String makeSound() {
        return name + " the " + species + " says: " + sound + "!";
    }
}
