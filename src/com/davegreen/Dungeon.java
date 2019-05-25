package com.davegreen;

import java.util.*;

/**
 * Created by daveg on 07/07/2017.
 */
public class Dungeon
{
    Random random = new Random();

    // Enemy fields.

    private int maxEnemyHealth;
    private int maxEnemyAttack;
    private List<String> enemy;

    // Player fields.

    private int maxPlayerHealth;
    private int maxPlayerAttack;
    private int numOfHealthPotions;
    private int maxHealthPotionHeal;


    public Dungeon()
    {
        this.maxEnemyHealth = 50;
        this.maxEnemyAttack = 25;
        this.enemy = new ArrayList<>(Arrays.asList("Skeleton", "Werewolf", "Wraith", "Reaper", "Ghoul", "Giant Rat", "Golom", "Undead Knight",
                                    "Shuffling Corpse", "Spectre", "Goblin", "Sparkly Bad Troll"));
        this.maxPlayerHealth = 100;
        this.maxPlayerAttack = 50;
        this.numOfHealthPotions = 3;
        this.maxHealthPotionHeal = 40;
    }

    public static List<String> populateWithRandomEnemy(List<String> list, int howManyEnemies)
    {
        List<String> copy = new LinkedList<>(list);
        Collections.shuffle(copy);
        return copy.subList(0, howManyEnemies);
    }

    public int getMaxEnemyHealth()
    {
        return maxEnemyHealth;
    }

    public void setMaxEnemyHealth(int maxEnemyHealth)
    {
        this.maxEnemyHealth = maxEnemyHealth;
    }

    public int getMaxEnemyAttack()
    {
        return maxEnemyAttack;
    }

    public void setMaxEnemyAttack(int maxEnemyAttack)
    {
        this.maxEnemyAttack = maxEnemyAttack;
    }

    public List<String> getEnemy()
    {
        return enemy;
    }

    public void setEnemy(ArrayList<String> enemy)
    {
        this.enemy = enemy;
    }

    public int getMaxPlayerHealth()
    {
        return maxPlayerHealth;
    }

    public void setMaxPlayerHealth(int maxPlayerHealth)
    {
        this.maxPlayerHealth = maxPlayerHealth;
    }

    public int getMaxPlayerAttack()
    {
        return maxPlayerAttack;
    }

    public void setMaxPlayerAttack(int maxPlayerAttack)
    {
        this.maxPlayerAttack = maxPlayerAttack;
    }

    public int getNumOfHealthPotions()
    {
        return numOfHealthPotions;
    }

    public void setNumOfHealthPotions(int numOfHealthPotions)
    {
        this.numOfHealthPotions = numOfHealthPotions;
    }

    public int getMaxHealthPotionHeal()
    {
        return maxHealthPotionHeal;
    }

    public void setMaxHealthPotionHeal(int maxHealthPotionHeal)
    {
        this.maxHealthPotionHeal = maxHealthPotionHeal;
    }
}
