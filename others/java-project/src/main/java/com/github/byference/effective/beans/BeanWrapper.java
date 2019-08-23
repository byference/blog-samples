package com.github.byference.effective.beans;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * BeanWrapper
 *
 * @author byference
 * @since 2019-08-23
 */
public class BeanWrapper {


    private Class clazz;

    private Map<String, Object> properties = new HashMap<>();


    public BeanWrapper(Class clazz) {
        this.clazz = clazz;
    }

    public void setPropertyValue(String key, Object value) {
        properties.put(key, value);
    }


    public <T> T getWrappedInstance() {

        T target = null;

        try {

            target = (T) clazz.newInstance();
            if (properties.size() > 0) {
                for (Map.Entry<String, Object> entry : properties.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    setProperties(target, key, value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return target;
    }


    private void setProperties(Object target, String key, Object value) {

        try {
            PropertyDescriptor descriptor = new PropertyDescriptor(key, target.getClass());
            Method writeMethod = descriptor.getWriteMethod();
            writeMethod.invoke(target, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
