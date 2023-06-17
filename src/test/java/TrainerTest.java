import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {
    Trainer trainer = new Trainer(new Monster("Rabbit",1,10));

    @Test
    void testConstructorTrainer() {
        assertEquals("Rabbit", trainer.getMonsters()[0].getName());
    }

    @Test
    void testFightLossToHigherLevel() {
        Monster rabbit = new FireFamily("Rabbit", 2, 60, 20);
        Monster scorchititle = new FireFamily("scorchitile", 1, 50, 20);
        Trainer trainer = new Trainer(rabbit);
        trainer.fight(0, scorchititle);
        assertEquals(0, scorchititle.getCurrentHealth());
    }

    @Test
    void testRestTeam() {
        Monster waterRabbit = new WaterFamily("WaterRabbit", 1,10);
        Monster dragonfish = new WaterFamily("Dragonfish",30,100);
        Trainer trainer = new Trainer(waterRabbit);
        trainer.fight(0, dragonfish);
        assertEquals(0, waterRabbit.getCurrentHealth());
    }

    @Test
    void testFightLevelUp() {
        Monster waterRabbit = new WaterFamily("WaterRabbit", 2,100);
        Monster scorchititle = new FireFamily("Scorchitile", 1, 50, 20);
        Trainer trainer = new Trainer(waterRabbit);
        trainer.fight(0, scorchititle);
        assertEquals(3, waterRabbit.getMonsterLevel());
    }

    @Test
    void testFightSeedatopLevel1LossToScorchitileLevel2() {
        Monster seedatops= new PlantFamily("Seedatops", 1,10,0);
        Monster scorchititle = new FireFamily("Scorchitile", 1, 50, 20);
        Trainer trainer = new Trainer(seedatops);
        trainer.fight(0, scorchititle);
        assertEquals(false, seedatops.isConscious());
    }


    @Test
    void testAddMonsterOnlyMax() {
        for(int i = 0; i < 7; i++){
            trainer.addMonster(new Monster("monster" + (i + 2),1,10));
        }
        assertEquals(6,trainer.getNumberOfMonsters());
    }

    @Test
    void testAddMonster() {
        for (int i = 0; i < 6; i++) {
            trainer.addMonster(new Monster("Rabbit" + (i + 2),1,10));
        }
        assertEquals(6, trainer.getNumberOfMonsters());
    }
}