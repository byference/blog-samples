package com.github.byference.effective.event;

import org.junit.Test;

/**
 * @author byference
 * @since 2019-06-30
 */
public class EventTest {


    @Test
    public void skillEventTest() {

        HeroesSkillManager manager = new HeroesSkillManager();
        manager.addListener(new HeroesSkillEventListener());
        manager.addListener(new EquipmentSkillEventListener());
        manager.releaseHeroesSkill(SkillEnum.Q);

        System.out.println();
        manager.releaseHeroesSkill(SkillEnum.R);
    }
}
