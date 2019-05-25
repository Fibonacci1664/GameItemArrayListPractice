package com.davegreen;

import java.util.*;

public class Main
{
    private static ArrayList playerInventory = new ArrayList<>(Arrays.asList());
    private static int healthPotions = 3;

    public static void main(String[] args)
    {
        // Declaring some variables and creating some objects of other classes that i need.
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Dungeon dungeon = new Dungeon();
        List<String> enemyType = dungeon.getEnemy();        // Gets all the enemy from my enemy ArrayList in the Dungeon class.
        int enemyNumberTotal = dungeon.getEnemy().size();   // Gets the amount of enemy in my enemy ArrayList.

            // Creates an empty arraylist for the players inventory.

        runGame();
        int randomAmountOfEnemy = generateRandomNumberOfEnemy(enemyNumberTotal);   // Generates a random amount of enemy into the dungeon from the total number in the ArrayList.

        // Generates the random enemies that will populate the dungeon based on a method in my Dungeon class and then passes a random amount of said enemy each time also.

        List<String> randomlyPickedEnemy = dungeon.populateWithRandomEnemy(enemyType, randomAmountOfEnemy);

        boolean enemiesLeft = true;
        int playerHealth = dungeon.getMaxPlayerHealth();

        NEWCHOICE:
        while (enemiesLeft)
        {
            System.out.println("\n The enemies in this dungeon are: ");
            System.out.println("\n\t * " + randomlyPickedEnemy);
            System.out.println("\n> Which enemy would you like to confront?");
            String userEnemyChoice = scanner.nextLine();


            // I want to validate the user input from line 31 of the code to reflect that if the user has not selected an enemy that was in the randomly populated list
            // then we stay in the while loop and continue asking until of course the user types in a enemy that was in the randomly populated list, at which
            // point we would of course skip the while loop moving onto the if statements validation, it would be nice also to have ignore case somewhere in there.


            while (!randomlyPickedEnemy.contains(userEnemyChoice))
            {
                System.out.println("\n\t That enemy does not live in this dungeon!");
                System.out.println("\n> Which enemy would you like to confront?");
                userEnemyChoice = scanner.nextLine();
            }

            // For the validation here i realise of course that just using the variable randomlyPickedEnemy in the sout would more than likely return ALL the enemy that
            // were randomly populated and not specifically the enemy that the user had chosen, so at this point i need a way to be able to access exactly what enemy it was
            // that the user had chosen to battle so that the sout statement makes sense but more importantly so i can then direct the code where it needs to go based on any given
            // particular enemy.

            if (randomlyPickedEnemy.contains(userEnemyChoice))
            {
                int randomEnemyHealth = random.nextInt(dungeon.getMaxEnemyHealth() + 1);

                System.out.println("\n You have chosen to battle the " + userEnemyChoice + " which has " + randomEnemyHealth + " health points");
                System.out.println("\n You have " + playerHealth + " health points remaining");

                boolean killedAnEnemy = false;
                int enemyHealth = randomEnemyHealth;


                // Combat Loop.
                while (!killedAnEnemy)
                {
                    // Combat variables.
                    int randomEnemyAttack = random.nextInt(dungeon.getMaxEnemyAttack() + 1);
                    int randomPlayerAttack = random.nextInt(dungeon.getMaxPlayerAttack() + 1);
                    int randomPlayerDefenceValue = random.nextInt(5) + 1;
                    int randomLeftDefenselessValue = random.nextInt(5) + 1;
                    int randomUpperHandValue = random.nextInt(5) + 1;

                    int carelessAttack = (randomPlayerAttack) * (randomUpperHandValue);
                    int enemyHardAttack = (randomEnemyAttack) * (randomLeftDefenselessValue);
                    int playerDefendsAttack = (randomEnemyAttack) / (randomPlayerDefenceValue);

                    int randomHealthPotionHeal = random.nextInt(dungeon.getMaxHealthPotionHeal());

                    System.out.println("\n> What would you like to do: ");
                    System.out.println("\n\t * Press 1 to attack.");
                    System.out.println("\n\t * Press 2 to defend.");
                    System.out.println("\n\t * Press 3 to run away.");
                    System.out.println("\n\t * Press 4 to display health potions.");
                    System.out.println("\n\t * Press 5 to use a health potion.");
                    System.out.println("\n\t * Press 6 to display inventory");

                    int input = scanner.nextInt();

                    switch (input)
                    {
                        case 1:
                            System.out.println("\n You attack the " + userEnemyChoice + " and strike it for " + carelessAttack + " damage points!");
                            System.out.println("\n The " + userEnemyChoice + " hits you back for " + enemyHardAttack + " damage points");
                            enemyHealth -= carelessAttack;
                            playerHealth -= enemyHardAttack;
                            break;
                        case 2:
                            System.out.println("\n You decide that defense is the best option, the " + userEnemyChoice + " attacks you first causing " + playerDefendsAttack + " hit points of damage!");
                            System.out.println("\n You then attack in retaliation and strike the " + userEnemyChoice + " for " + randomPlayerAttack + " hit points of damage");
                            enemyHealth -= randomPlayerAttack;
                            playerHealth -= playerDefendsAttack;
                            break;
                        case 3:
                            System.out.println("\n You realise you are no match for this enemy and so choose to run, the " + userEnemyChoice + " strikes you one final blow" + "\n for " + enemyHardAttack + " hit points as you turn your back and are left defenseless!");
                            playerHealth -= enemyHardAttack;
                            if (playerHealth > 0)
                            {
                                System.out.println("\n You have " + playerHealth + " health points remaining");
                                continue NEWCHOICE;
                            }
                            else if (playerHealth <= 0)
                            {
                                System.out.println("\n The " + userEnemyChoice + " has killed you");
                                System.out.println("########################################");
                                System.out.println("#####           GAME OVER          #####");
                                System.out.println("########################################");
                                System.exit(0);
                            }
                        case 4:
                            System.out.println("You are currently carrying " + healthPotions + " health potions.");
                            break;
                        case 5:
                            int newHealth = playerHealth + randomHealthPotionHeal;
                            if(healthPotions > 0)
                            {
                                if (newHealth > 100)
                                {
                                    System.out.println("You have used a health potion and have healed to the max health of " + dungeon.getMaxPlayerHealth());
                                    playerHealth = dungeon.getMaxPlayerHealth();
                                }
                                else
                                {
                                    playerHealth = newHealth;
                                    System.out.println("You have used a health potion and your health is now: " + playerHealth);
                                }
                                healthPotions --;
                            }
                            else
                            {
                                System.out.println("You do not have any more health potions at the moment.");
                            }
                            break;
                        case 6:
                            System.out.println("\n Your inventory is as follows: ");
                            getPlayerInventory();
                            break;
                    }


                    if (enemyHealth > 0)
                    {
                        System.out.println("\n The " + userEnemyChoice + " has " + enemyHealth + " health points remaining.");
                    }
                    else if (enemyHealth <= 0)
                    {
                        System.out.println("\n You have killed the " + userEnemyChoice);
                        dropChance();
                        randomlyPickedEnemy.remove(userEnemyChoice);

                        if (randomlyPickedEnemy.size() > 0)
                        {
                            //System.out.println("\n There are only " + randomlyPickedEnemy + " left in the dungeon");
                            killedAnEnemy = true;
                        }
                        else
                        {
                            System.out.println("\n There are no enemy left to kill");
                            killedAnEnemy = true;
                            enemiesLeft = false;
                        }
                    }
                    if (playerHealth > 0)
                    {
                        System.out.println("\n You have " + playerHealth + " health points remaining");
                    }
                    else if (playerHealth <= 0)
                    {
                        System.out.println("\n The " + userEnemyChoice + " has killed you");
                        System.out.println("########################################");
                        System.out.println("#####           GAME OVER          #####");
                        System.out.println("########################################");
                        System.exit(0);
                    }
                    else
                    {
                        killedAnEnemy = false;
                    }
                }
            }
        }

        System.out.println("\n You have completed the game!");
    }

    public static void runGame()
    {
        System.out.println("##################################################");
        System.out.println("#####            DUNGEON CRAWLER             #####");
        System.out.println("##################################################");
    }

    // This is my method to generate a random amount of enemy for the total amount of enemy in my ArrayList.

    public static int generateRandomNumberOfEnemy(int howManyEnemies)
    {
        Random random = new Random();
        int rng = random.nextInt(howManyEnemies) + 1;
        System.out.println("\n There are " + rng + " enemies in this dungeon!");
        return rng;
    }

    public static int dropChance()
    {
        GameWeapons gameWeapons = new GameWeapons();
        List<String> weaponTypes = gameWeapons.getGameWeapons();    // Gets the list of game weapons available.

        Random random = new Random();
        int dropChance = 25;   // Percentage

        if(random.nextInt(100) <= dropChance)
        {
            List<String> weaponDrop = gameWeapons.selectRandomWeapon(weaponTypes, 1);
            System.out.println("\n You have found the " + weaponDrop);
            playerInventory.add(String.valueOf(weaponDrop));
            weaponTypes.remove(weaponDrop);
        }
        else
        {
            System.out.println("\n The enemy did not drop any weapons");
        }

        if(random.nextInt(100) < (dropChance * 2))
        {
            System.out.println("\n You have found a health potion");
            healthPotions ++;
        }
        else
        {
            System.out.println("\n The enemy did not drop any health potions");
        }

        return -1;
    }

    public static List<String> getPlayerInventory()
    {
        if (playerInventory.size() < 0)
        {
            System.out.println("Your inventory is empty!");
        }
        else
        {
            for (int i = 0; i < playerInventory.size(); i ++)
            {
                System.out.println(playerInventory.get(i));
            }
        }

        return null;
    }
}
