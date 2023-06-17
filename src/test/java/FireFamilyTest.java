import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;

import static org.junit.jupiter.api.Assertions.*;

class FireFamilyTest {
    FireFamily fireFamily = new FireFamily("Hot", 1, 10, 10);

    @Test
    void levelUpHealth() {
        fireFamily.levelUp();
        assertEquals(30,fireFamily.getMaxHealth());
    }

    @Test
    void levelUpLevel() {
        fireFamily.levelUp();
        assertEquals(2,fireFamily.getMonsterLevel());
    }

    @Test
    void testLevelUpFireMana() {
        fireFamily.levelUp();
        assertEquals(22, fireFamily.getMaxFireMana());
    }

    @Test
    void takeDamage() {
        fireFamily.takeDamage(new Damage(DamageType.NORMAL, 5));
        assertEquals(5, fireFamily.getCurrentHealth());
    }

    @Test
    void specialAttackType() {
        assertEquals(DamageType.FIRE, fireFamily.specialAttack().getType());
    }

    @Test
    void specialAttackLessFireMana() {
        assertEquals(10,fireFamily.specialAttack().getAmount());
    }

    @Test
    void specialAttackGreaterFireMana() {
        fireFamily.setFireMana(20);
        assertEquals(15,fireFamily.specialAttack().getAmount());
    }

    @Test
    void basicAttack() {
        assertEquals(10,fireFamily.basicAttack().getAmount());
    }

    @Test
    void rest() {
        fireFamily.takeDamage(new Damage(DamageType.NORMAL,5));
        fireFamily.rest();
        assertEquals(10,fireFamily.getCurrentHealth());
    }

    @Test
    void getFireMana() {
        assertEquals(10, fireFamily.getFireMana());
    }

    @Test
    void getMaxFireMana() {
        assertEquals(10, fireFamily.getMaxFireMana());
    }
    @Test
    void testIsConsciousNoLonger() {
        fireFamily.takeDamage(new Damage(DamageType.NORMAL,10));
        assertEquals(false,fireFamily.isConscious());
    }
}