package Test;

import java.util.Collection;
import java.util.function.Function;

public final class NullValidatorB<D> {

    private final D d;

    private final Class<? extends Exception> eClass;

    private final String D_IS_NULL = "Target Object in Validator cannot be null";
    private final String M_IS_NULL = "methodRef in Validator cannot be null";

    private NullValidatorB(D d, Class<? extends Exception> eClass) {
        // static method use only
        this.d = d;
        this.eClass = (eClass == null) ? NullPointerException.class : eClass;
    }

    public static <D> NullValidatorB<D> of(D d, Class<? extends Exception> t) {
        return new NullValidatorB<>(d, t);
    }


    public <U> NullValidatorB<U> call(Function<D, U> methodRef) throws Exception {
        U nextStep = get(methodRef);
        return of(nextStep, eClass);
    }

    private void throwException(String errorMessage) throws Exception {
        throw (Exception) Class.forName(this.eClass.getName()).getConstructor(String.class).newInstance(errorMessage);
    }

    private void throwException(Exception e) throws Exception {
        throw e;
    }

    private void throwException(Exception e, String errorMessage) throws Exception {
        if (e == null) {
            this.throwException(errorMessage);
        } else {
            this.throwException(e);
        }
    }

    private <U> U get(Function<D, U> methodRef) throws Exception {
        if (d == null) {
            this.throwException(D_IS_NULL);
        }
        if (methodRef == null) {
            this.throwException(M_IS_NULL);
        }
        return methodRef.apply(d);
    }


    private String getString(Function<D, String> methodRef, Class<? extends Exception> e) throws Exception {
        if (d == null) {
            this.throwException(D_IS_NULL);
        }
        if (methodRef == null) {
            this.throwException(M_IS_NULL);
        }
        return methodRef.apply(d);
    }

    private Collection<?> getCollection(Function<D, Collection<?>> methodRef, Class<? extends Exception> e) throws Exception {
        if (d == null) {
            this.throwException(D_IS_NULL);
        }
        if (methodRef == null) {
            this.throwException(M_IS_NULL);
        }
        return methodRef.apply(d);
    }

    public <U> NullValidatorB<D> notNull(Function<D, U> methodRef, String errorMessage) throws Exception {
        return this.notNullObject(methodRef, null, errorMessage);
    }

    public <U> NullValidatorB<D> notNull(Function<D, U> methodRef, Exception e) throws Exception {
        return this.notNullObject(methodRef, e, null);
    }


    private <U> NullValidatorB<D> notNullObject(Function<D, U> methodRef, Exception e, String errorMessage) throws Exception {
        U result = get(methodRef);
        if (result == null) {
            this.throwException(e, errorMessage);
        }
        return this;
    }
}
