package learnprogramming.academy.learnjava;

import java.util.ArrayList;

public class Player {
    private String handleName;
    private int lives;
    private int level;
    private int score;
    private Weapon weapon;
    private ArrayList<Loot> inventory;



    public Player()
    {
        this("Unknown Player");
    }

    public Player(String handleName)
    {
        this(handleName, 1);

//        handleName = handle;
//        lives = 3;
//        level = 1;
//        score = 0;

    }

    public Player(String handleName, int startingLevel)
    {
        setHandleName(handleName);
        setLives(3);
        setLevel(startingLevel);
        setScore(0);
        inventory = new ArrayList<>();
    }



    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        if(handleName.length() >3)
        {
            System.out.println("The name " + handleName + " is too short, must be 3 characters or more.");
            return;
        }
        this.handleName = handleName;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setNameAndLevel(String name, int level)
    {
        setHandleName(name);
        setLevel(level);
    }
    private void setDefaultWeapon()
    {
        this.weapon = new Weapon("Sword", 10, 20);
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArrayList<Loot> getInventory() {
        return inventory;
    }

    public void pickUpLoot(Loot newLoot) {
        inventory.add(newLoot);
    }

    public boolean dropLoot(Loot loot) {
        if(this.inventory.contains(loot)) {
            inventory.remove(loot);
            return true;
        }
        return false;
    }

    public void showInventory() {
        for(Loot item : inventory) {
            System.out.println(item.getName());
        }
        System.out.println("======================================");
    }

    public int score()
    {
        int total = 0;
        for(Loot currentLoot : inventory)
        {
            System.out.println(currentLoot.getName() + " is Worth " + currentLoot.getValue());
            total = total + currentLoot.getValue();
        }
        return total;
    }


}


