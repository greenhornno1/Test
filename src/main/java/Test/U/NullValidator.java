package Test.U;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Function;

public final class NullValidator<D> {

    private final D d;
    private final Throwable t;

    private NullValidator(D d, Throwable t) {
        // static method use only
        this.d = d;
        this.t = (t == null) ? new NullPointerException() : t;
    }

    private NullValidator(D d) {
        this.d = d;
        this.t = new NullPointerException();
    }

    /**
     * Static factory method for obtaining a NullSafe instance.
     *
     * @param d   an instance of a data class
     * @param <D> the type of the data class
     * @return a NullSafe&lt;T&gt; instance wrapping an instance of T
     */
    public static <D> NullValidator<D> of(D d, Throwable t) {
        return new NullValidator<>(d, t);
    }

    public static <D> NullValidator<D> ofObj(D d) {
        return new NullValidator<>(d);
    }

    public <U> NullValidator<U> call(Function<D, U> methodRef) throws Throwable {
        U nextStep = get(methodRef);
        return of(nextStep, t);
    }

    private <U> U get(Function<D, U> methodRef) throws Throwable {
        if (methodRef == null) {
            throw t;
        } else if (d == null) {
            throw t;
        } else {
            return methodRef.apply(d);
        }
    }

    private String getString(Function<D, String> methodRef) throws Throwable {
        if (methodRef == null) {
            throw t;
        } else if (d == null) {
            throw t;
        } else {
            return methodRef.apply(d);
        }
    }

    private String getString(Collection<?> collection, Function<Collection<?>, String> methodRef) throws Throwable {
        if (methodRef == null) {
            throw t;
        } else if (collection == null) {
            throw t;
        } else {
            return methodRef.apply(collection);
        }
    }

    private Collection<?> getCollection(Function<D, Collection<?>> methodRef) throws Throwable {
        if (methodRef == null) {
            throw t;
        } else if (d == null) {
            throw t;
        } else {
            return methodRef.apply(d);
        }
    }

    public <U> NullValidator<D> notNull() throws Throwable {
        if (d == null) {
            throw t;
        } else {
            return this;
        }
    }

    /**
     * Throw constructor Throwable if return value from methodRef is null.
     *
     * @param methodRef method of input Object for getting Object
     */
    public <U> NullValidator<D> notNull(Function<D, U> methodRef) throws Throwable {
        U result = get(methodRef);
        if (result == null) {
            throw t;
        } else {
            return this;
        }
    }

    /**
     * Throw Throwable if return value from methodRef is null.
     *
     * @param methodRef method of input Object for getting Object
     * @param t         Customized Throwable
     */
    public <U> NullValidator<D> notNull(Function<D, U> methodRef, Throwable t) throws Throwable {
        U result = get(methodRef);
        if (result == null) {
            if (t == null) {
                throw this.t;
            } else {
                throw t;
            }
        } else {
            return this;
        }
    }

    /**
     * Throw constructor Throwable if String value from methodRef is null or empty.
     *
     * @param methodRef method of input Object for getting String
     */
    public <U> NullValidator<D> notBlank(Function<D, String> methodRef) throws Throwable {
        String result = getString(methodRef);
        if (StringUtils.isBlank(result)) {
            throw t;
        } else {
            return this;
        }
    }

    /**
     * Throw Throwable if String value from methodRef is null or empty.
     *
     * @param methodRef method of input Object for getting String
     * @param t         Customized Throwable
     */
    public <U> NullValidator<D> notBlank(Function<D, String> methodRef, Throwable t) throws Throwable {
        String result = getString(methodRef);
        if (StringUtils.isBlank(result)) {
            if (t == null) {
                throw this.t;
            } else {
                throw t;
            }
        } else {
            return this;
        }
    }

    /**
     * Throw constructor Throwable if collection from methodRef is null or empty.
     *
     * @param methodRef method of input Object for getting Collection
     */
    public <U> NullValidator<D> notEmpty(Function<D, Collection<?>> methodRef) throws Throwable {
        Collection<?> result = getCollection(methodRef);
        if (CollectionUtils.isEmpty(result)) {
            throw t;
        } else {
            return this;
        }
    }

    /**
     * Throw Throwable if collection from methodRef is null or empty.
     *
     * @param methodRef method of input Object for getting Collection
     * @param t         Customized Throwable
     */
    public <U> NullValidator<D> notEmpty(Function<D, Collection<?>> methodRef, Throwable t) throws Throwable {
        Collection<?> result = getCollection(methodRef);
        if (CollectionUtils.isEmpty(result)) {
            if (t == null) {
                throw this.t;
            } else {
                throw t;
            }
        } else {
            return this;
        }
    }

    public Boolean notEmptyEach(Function<D, Collection<?>> collectionMethodRef, Function<Collection<?>, String> methodRef) throws Throwable {
        Collection<?> result = getCollection(collectionMethodRef);
        if (CollectionUtils.isEmpty(result)) {
            throw t;
        }
        Iterator<?> iterator = result.iterator();
        boolean isEmptyString = false;
        while (!isEmptyString && iterator.hasNext()) {
            String stringValue = this.getString(result, methodRef);
            if (StringUtils.isEmpty(stringValue)) {
                isEmptyString = true;
            }
        }
        return isEmptyString;
    }
}
