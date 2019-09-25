package demo;

public class Main {
    public static void main(String[] args){
        MySpring spring = new MySpring();
        Person person = (Person) spring.getBean("demo.Person");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getSex());
    }
}
