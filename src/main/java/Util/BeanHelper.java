package Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;

import java.beans.FeatureDescriptor;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class BeanHelper {

    private BeanHelper() {
    }

    /**
     * 指定集合拷贝到指定bean 集合
     *
     * @param targetSupplier 指定bean生成接口
     * @param list           源集合
     * @param <T>            输出bean 类型
     * @param <D>            源bean 类型
     * @return 返回 目标bean 集合
     */
    public static <T, D> List<T> copyPropertiesList(Supplier<T> targetSupplier, List<D> list) {
        if (Objects.isNull(list) || Objects.isNull(targetSupplier)) {
            if (log.isInfoEnabled()) {
                log.info("======集合拷贝失败！！！目标集合或源集合为空。");
            }
            return Collections.emptyList();
        }
        return list.stream().filter(Objects::nonNull).map(d -> BeanHelper.copyForBean(targetSupplier, d)).filter(Objects::nonNull).collect(Collectors.toList());
    }

    /**
     * 源头bean 拷贝到targetSupplier提供的bean
     * example:
     * StoreDto storeDto=BeanUtils.copyForBean(StoreDto::new,storeDo);
     *
     * @param targetSupplier 目标bean 生成器
     * @param source         源bean
     * @param <T>            目标bean 类型
     * @param <D>            源bean 类型
     * @return t
     */
    public static <T, D> T copyForBean(Supplier<T> targetSupplier, D source) {
        if (Objects.isNull(targetSupplier) || Objects.isNull(source)) {
            if (log.isInfoEnabled()) {
                log.info("======bean拷贝失败！！！目标bean或源bean为空。");
            }
            return null;
        }
        T t = targetSupplier.get();
        if (Objects.nonNull(t)) {
            BeanUtils.copyProperties(source, t);
        }
        return t;
    }

    /**
     *
     * @param src
     * @param target
     */
    public static void copyNonNullProperties(Object src, Object target) {
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }

    /**
     *
     * @param source
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors())
                .map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null)
                .toArray(String[]::new);
    }

    @SuppressWarnings("unchecked")
    public static <T> T cloneBean(T t) {
        T newObj = null;
        try {
            Object o = t.getClass().getDeclaredConstructor().newInstance();
            newObj = (T) t.getClass().getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(t, newObj);
            return newObj;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        Assert.notNull(newObj, "clone bean fail!");
        return newObj;
    }

}
