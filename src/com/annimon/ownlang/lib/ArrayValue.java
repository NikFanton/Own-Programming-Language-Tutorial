package com.annimon.ownlang.lib;

import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author aNNiMON
 */
public final class ArrayValue implements Value, Iterable<Value> {
    
    public static ArrayValue add(ArrayValue array, Value value) {
        final int last = array.elements.length;
        final ArrayValue result = new ArrayValue(last + 1);
        System.arraycopy(array.elements, 0, result.elements, 0, last);
        result.elements[last] = value;
        return result;
    }
    
    public static ArrayValue merge(ArrayValue array1, ArrayValue array2) {
        final int length1 = array1.elements.length;
        final int length2 = array2.elements.length;
        final int length = length1 + length2;
        final ArrayValue result = new ArrayValue(length);
        System.arraycopy(array1.elements, 0, result.elements, 0, length1);
        System.arraycopy(array2.elements, 0, result.elements, length1, length2);
        return result;
    }
    
    private final Value[] elements;

    public ArrayValue(int size) {
        this.elements = new Value[size];
    }

    public ArrayValue(Value[] elements) {
        this.elements = new Value[elements.length];
        System.arraycopy(elements, 0, this.elements, 0, elements.length);
    }
    
    public ArrayValue(ArrayValue array) {
        this(array.elements);
    }
    
    public Value get(int index) {
        return elements[index];
    }
    
    public void set(int index, Value value) {
        elements[index] = value;
    }
    
    @Override
    public double asNumber() {
        throw new RuntimeException("Cannot cast array to number");
    }

    @Override
    public String asString() {
        return Arrays.toString(elements);
    }

    @Override
    public Iterator<Value> iterator() {
        return Arrays.asList(elements).iterator();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Arrays.deepHashCode(this.elements);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass())
            return false;
        final ArrayValue other = (ArrayValue) obj;
        return Arrays.deepEquals(this.elements, other.elements);
    }

    @Override
    public String toString() {
        return asString();
    }
}
