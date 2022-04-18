package learnprogramming.academy.learnjava;

public class Vampire extends Enemy{
    public Vampire(String name) {
        super(name, 20, 3);

    }

    @Override
    public void takeDamage(int damage)
    {
        super.takeDamage(damage / 2);
    }
}
