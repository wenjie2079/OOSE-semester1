import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScorchitileTest {
    Scorchitile scorchitile = new Scorchitile("Smoke", 1, 10, 1);

    @Test
    void basicAttack() {
        assertEquals(20, scorchitile.basicAttack().getAmount());
    }

    @Test
    void testGetName() {
        assertEquals("Smoke", scorchitile.getName());
    }

    @Test
    void testGetMonsterBreed() {
        assertEquals("Scorchitile", scorchitile.getMonsterBreed());
    }

    @Test
    void testGetMonsterLevel() {
        assertEquals(1, scorchitile.getMonsterLevel());
    }

    @Test
    void testGetCurrentHealth() {
        assertEquals(10,scorchitile.getCurrentHealth());
    }

    @Test
    void testGetMaxHealth() {
        assertEquals(10, scorchitile.getMaxHealth());
    }
}