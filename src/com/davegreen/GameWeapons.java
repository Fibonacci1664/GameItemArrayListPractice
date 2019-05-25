package com.davegreen;

import java.util.*;

/**
 * Created by daveg on 07/07/2017.
 */
public class GameWeapons
{
    private int maxDurability;
    private int maxPhysicalAttackValue;
    private int maxMagicalAttackValue;
    private int maxDefenceValue;

    private List<String> gameWeapons = new ArrayList<String>();

    public GameWeapons()
    {
        this.maxDurability = 100;
        this.maxPhysicalAttackValue = 100;
        this.maxMagicalAttackValue = 100;
        this.maxDefenceValue = 100;
        this.gameWeapons = new ArrayList<>(Arrays.asList("Axe", "Sword", "Mace", "Pikestaff", "Spear", "Morning Star", "Club", "Long Bow", "Crossbow", "Dagger"));
    }

    public static List<String> selectRandomWeapon(List<String> list, int howManyWeaponsDrop)
    {
        List<String> copy = new LinkedList<>(list);
        Collections.shuffle(copy);
        return copy.subList(0, howManyWeaponsDrop);
    }

    public List<String> getGameWeapons()
    {
        return gameWeapons;
    }

    public void setGameWeapons(List<String> gameWeapons)
    {
        this.gameWeapons = gameWeapons;
    }

    public int getMaxDurability()
    {
        return maxDurability;
    }

    public void setMaxDurability(int maxDurability)
    {
        this.maxDurability = maxDurability;
    }

    public int getMaxPhysicalAttackValue()
    {
        return maxPhysicalAttackValue;
    }

    public void setMaxPhysicalAttackValue(int maxPhysicalAttackValue)
    {
        this.maxPhysicalAttackValue = maxPhysicalAttackValue;
    }

    public int getMaxMagicalAttackValue()
    {
        return maxMagicalAttackValue;
    }

    public void setMaxMagicalAttackValue(int maxMagicalAttackValue)
    {
        this.maxMagicalAttackValue = maxMagicalAttackValue;
    }

    public int getMaxDefenceValue()
    {
        return maxDefenceValue;
    }

    public void setMaxDefenceValue(int maxDefenceValue)
    {
        this.maxDefenceValue = maxDefenceValue;
    }
}
