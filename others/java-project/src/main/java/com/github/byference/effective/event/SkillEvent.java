package com.github.byference.effective.event;

import lombok.Getter;
import lombok.Setter;

import java.util.EventObject;

/**
 * 英雄技能事件
 *
 * @author byference
 * @since 2019-06-30
 */
@Getter
@Setter
public class SkillEvent extends EventObject {

    private SkillEnum skillEnum;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @param skillEnum {@link SkillEnum}
     * @throws IllegalArgumentException if source is null.
     */
    public SkillEvent(Object source, SkillEnum skillEnum) {
        super(source);
        this.skillEnum = skillEnum;
    }

}
