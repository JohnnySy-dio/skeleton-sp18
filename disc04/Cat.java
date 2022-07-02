
public class Cat extends Animal {
    public Cat(String name, int age){
       
        super(name,age);
        this.noise = "Meow!";
    }
    
    @Override
    public void greet(){
        System.out.println("Cat " + name + " says: " + makeNoise());
    }



    public static void main(String[] args) {
        Cat lily = new Cat("Lily",5);
        lily.greet();
    }
}