package OOPTest.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;

@Component
public class SpringApplicationContextUtils implements ApplicationContextAware, BeanFactoryAware {

    private static ApplicationContext applicationContext = null;

    private static BeanFactory beanFactory;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    /**
     * 获取applicationContext对象
     *
     * @return applicationContext对象
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 根据beanName来查找对象
     *
     * @param beanName beanName
     * @return 根据beanName查找到的对象
     */
    public static <T> T getBeanByName(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 根据beanName和bean类型来查找对象,beanName获取的实例类型必须和beanClazz相匹配
     *
     * @param beanName  beanName
     * @param beanClazz bean类型
     * @return 根据beanName和bean.Class查找到的对象
     */
    public static <T> T getBeanByName(String beanName, Class<T> beanClazz) {
        return applicationContext.getBean(beanName, beanClazz);
    }

    /**
     * 根据bean的class来查找对象
     *
     * @param beanClazz bean类型
     * @return bean的class查找到的对象
     */
    public static <T> T getBeanByClass(Class<T> beanClazz) {
        return (T) applicationContext.getBean(beanClazz);
    }

    /**
     * 根据bean的class来查找所有的对象(包括子类)
     *
     * @param beanClazz bean类型
     * @return 关联map
     */
    public static Map getBeansOfTypeByClass(Class beanClazz) {
        return applicationContext.getBeansOfType(beanClazz);
    }

    public static boolean containsBean(String beanName) {
        return applicationContext.containsBean(beanName);
    }

    /**
     * MessageSource国际化功能
     *
     * @param key 配置属性变量
     * @return 国际化结果字符串
     */
    public static String getMessage(String key) {
        return applicationContext.getMessage(key, null, Locale.getDefault());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        SpringApplicationContextUtils.beanFactory = beanFactory;
    }

    public static BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
