package com.github.byference.effective.event;

/**
 * equipment skill event listener
 *
 * @author byference
 * @since 2019-06-30
 */
public class EquipmentSkillEventListener implements SkillEventListener {

    @Override
    public void releaseSkill(SkillEvent event) {
        if (event.getSkillEnum() == SkillEnum.R) {
            System.out.println("终极技能触发装备特效发动");
        }
    }

}
