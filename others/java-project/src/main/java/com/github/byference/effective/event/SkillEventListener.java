package com.github.byference.effective.event;

import java.util.EventListener;

/**
 * skill event listener
 *
 * @author byference
 * @since 2019-06-30
 */
public interface SkillEventListener extends EventListener {

    /**
     * release skill
     * @param event {@link SkillEventListener}
     */
    void releaseSkill(SkillEvent event);
}
