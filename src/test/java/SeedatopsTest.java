import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SeedatopsTest {
    Seedatops seedatops = new Seedatops("Seed", 1, 10, 1);

    @Test
    void testGetName() {
        assertEquals("Seed", seedatops.getName());
    }

    @Test
    void testGetMonsterBreed() {
        assertEquals("Seedatops", seedatops.getMonsterBreed());
    }

    @Test
    void testGetMonsterLevel() {
        assertEquals(1, seedatops.getMonsterLevel());
    }

    @Test
    void testGetCurrentHealth() {
        assertEquals(10, seedatops.getCurrentHealth());
    }

    @Test
    void testGetMaxHealth() {
        assertEquals(10, seedatops.getMaxHealth());
    }

    @Test
    void testBasicAttack() {
        assertEquals(5,seedatops.basicAttack().getAmount());
    }

    @Test
    void testTakeDamage() {
        seedatops.takeDamage(new Damage(DamageType.NORMAL,5));
        assertEquals(5, seedatops.getCurrentHealth());
    }

    @Test
    void testTakeDamageAndBasicAttack() {
        seedatops.takeDamage(new Damage(DamageType.NORMAL, 5));
        seedatops.basicAttack();
        assertEquals(10, seedatops.getCurrentHealth());
    }

}