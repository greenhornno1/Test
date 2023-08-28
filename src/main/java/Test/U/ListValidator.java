package Test.U;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.function.Function;

public final class ListValidator<D> {

    private final Collection<D> d;
    private final Exception t;

    private ListValidator(Collection<D> d, Exception t) {
        // static method use only
        this.d = d;
        this.t = (t == null) ? new NullPointerException() : t;
    }


    /**
     * Static factory method for obtaining a NullSafe instance.
     *
     * @param d   an instance of a data class
     * @param <D> the type of the data class
     * @return a NullSafe&lt;T&gt; instance wrapping an instance of T
     */
    public static <D> ListValidator<D> of(Collection<D> d, Exception t) {
        return new ListValidator<>(d, t);
    }

    private String getString(D d, Function<D, String> methodRef) throws Exception {
        if (methodRef == null) {
            throw t;
        } else if (d == null) {
            throw t;
        } else {
            return methodRef.apply(d);
        }
    }

    public <U> ListValidator<D> notEmptyStringEach(Function<D, String> methodRef) throws Exception {
        if (CollectionUtils.isEmpty(this.d)) {
            throw this.t;
        }
        Iterator<D> iterator = this.d.iterator();
        boolean isEmptyString = false;
        while (!isEmptyString && iterator.hasNext()) {
            D currentIterator = iterator.next();
            String currentString = getString(currentIterator, methodRef);
            if (StringUtils.isEmpty(currentString)) {
                isEmptyString = true;
            }
        }
        if (isEmptyString) {
            throw this.t;
        }
        return this;
    }

    public <U> ListValidator<D> notEmptyStringEach(Function<D, String> methodRef, Exception t) throws Exception {
        if (CollectionUtils.isEmpty(this.d)) {
            if (t == null) {
                throw this.t;
            } else {
                throw t;
            }
        }
        Iterator<D> iterator = this.d.iterator();
        boolean isEmptyString = false;
        while (!isEmptyString && iterator.hasNext()) {
            D currentIterator = iterator.next();
            String currentString = getString(currentIterator, methodRef);
            if (StringUtils.isEmpty(currentString)) {
                isEmptyString = true;
            }
        }
        if (isEmptyString) {
            if (t == null) {
                throw this.t;
            } else {
                throw t;
            }
        }
        return this;
    }
}
