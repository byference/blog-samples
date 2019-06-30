package com.github.byference.effective.event;

/**
 * heroes skill event listener
 *
 * @author byference
 * @since 2019-06-30
 */
public class HeroesSkillEventListener implements SkillEventListener {

    @Override
    public void releaseSkill(SkillEvent event) {
        switch (event.getSkillEnum()) {
            case Q:
                System.out.println("释放Q技能");
                break;
            case W:
                System.out.println("释放W技能");
                break;
            case E:
                System.out.println("释放E技能");
                break;
            case R:
                System.out.println("释放R技能");
                break;
            default:
        }

    }

}
