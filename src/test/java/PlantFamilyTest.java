import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantFamilyTest {
    PlantFamily plantFamily = new PlantFamily("Plant", 1,10,1);

    @Test
    void levelUpLevel() {
        plantFamily.levelUp();
        assertEquals(2, plantFamily.getMonsterLevel());
    }

    @Test
    void levelUpHealth() {
        plantFamily.levelUp();
        assertEquals(10, plantFamily.getCurrentHealth());
    }

    @Test
    void testGetMaxCharges() {
        assertEquals(1,plantFamily.getMaxCharges());
    }

    @Test
    void testGetCharges() {
        assertEquals(1,plantFamily.getCharges());
    }

    @Test
    void takeDamagePlant() {
        plantFamily.takeDamage(new Damage(DamageType.PLANT, 6));
        assertEquals(7, plantFamily.getCurrentHealth());
    }

    @Test
    void takeDamageFire() {
        plantFamily.takeDamage(new Damage(DamageType.FIRE, 3));
        assertEquals(4, plantFamily.getCurrentHealth());
    }

    @Test
    void takeDamageNormal() {
        plantFamily.takeDamage(new Damage(DamageType.NORMAL, 3));
        assertEquals(7, plantFamily.getCurrentHealth());
    }

    @Test
    void specialAttackCharged() {
        assertEquals(10, plantFamily.specialAttack().getAmount());
    }

    @Test
    void testSpecialAttackNotCharged() {
        plantFamily.specialAttack();
        assertEquals(0, plantFamily.specialAttack().getAmount());
    }

    @Test
    void specialAttackType() {
        assertEquals(DamageType.PLANT, plantFamily.specialAttack().getType());

    }

    @Test
    void basicAttackType() {

        assertEquals(DamageType.NORMAL, plantFamily.basicAttack().getType());
    }

    @Test
    void testRestCharge() {
        plantFamily.specialAttack();
        plantFamily.rest();
        assertEquals(1, plantFamily.charges);
    }
}