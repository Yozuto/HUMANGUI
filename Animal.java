public class Animal {
    String name;
    String species;
    String sound;
    int age;

    // Constructor
    public Animal(String name, String species, String sound, int age) {
        this.name = name;
        this.species = species;
        this.sound = sound;
        this.age = age;
    }

    // Method to return animal information as a string
    public String getInfo() {
        return "Name: " + name + "\n" +
               "Species: " + species + "\n" +
               "Age: " + age + " years\n" +
               "Sound: " + sound;
    }

    // Method to simulate the animal making a sound
    public String makeSound() {
        return name + " the " + species + " says: " + sound + "!";
    }
}
