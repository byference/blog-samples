package com.github.byference.effective.event;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * heroes skill manager
 *
 * @author byference
 * @since 2019-06-30
 */
public class HeroesSkillManager {

    private static Collection<SkillEventListener> listeners = new LinkedHashSet<>();

    public boolean addListener(SkillEventListener listener) {
        return listeners.add(listener);
    }

    public boolean removeListener(SkillEventListener listener) {
        return listeners.remove(listener);
    }

    public void releaseHeroesSkill(SkillEnum skillEnum) {
        notifyListeners(new SkillEvent(this, skillEnum));
    }

    private void notifyListeners(SkillEvent event) {
        listeners.forEach(listener -> listener.releaseSkill(event));
    }

}
