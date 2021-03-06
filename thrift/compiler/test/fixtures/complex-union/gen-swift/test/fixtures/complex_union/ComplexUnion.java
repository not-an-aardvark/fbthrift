/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

package test.fixtures.complex_union;

import com.facebook.swift.codec.*;
import com.facebook.swift.codec.ThriftField.Requiredness;
import com.facebook.swift.codec.ThriftField.Recursiveness;
import java.util.*;

import static com.google.common.base.MoreObjects.toStringHelper;

@ThriftUnion("ComplexUnion")
public final class ComplexUnion
{
    private final Object value;
    private final int id;
    private final String name;


    @ThriftConstructor
    public ComplexUnion(final long intValue) {
        this.value = intValue;
        this.id = 1;
        this.name = "intValue";
    }

    @ThriftConstructor
    public ComplexUnion(final String stringValue) {
        this.value = stringValue;
        this.id = 5;
        this.name = "stringValue";
    }

    @ThriftConstructor
    public ComplexUnion(final List<Long> intListValue) {
        this.value = intListValue;
        this.id = 2;
        this.name = "intListValue";
    }

    @ThriftConstructor
    public ComplexUnion(final List<String> stringListValue) {
        this.value = stringListValue;
        this.id = 3;
        this.name = "stringListValue";
    }

    @ThriftConstructor
    public ComplexUnion(final Map<Short, String> typedefValue) {
        this.value = typedefValue;
        this.id = 9;
        this.name = "typedefValue";
    }

    @ThriftConstructor
    public ComplexUnion(final String stringRef) {
        this.value = stringRef;
        this.id = 14;
        this.name = "stringRef";
    }

    @ThriftField(value=1, name="intValue", requiredness=Requiredness.NONE)
    public long getIntValue() {
        if (this.id != 1) {
            throw new IllegalStateException("Not a intValue element!");
        }
        return (long) value;
    }

    public boolean isSetIntValue() {
        return this.id == 1;
    }

    @ThriftField(value=5, name="stringValue", requiredness=Requiredness.NONE)
    public String getStringValue() {
        if (this.id != 5) {
            throw new IllegalStateException("Not a stringValue element!");
        }
        return (String) value;
    }

    public boolean isSetStringValue() {
        return this.id == 5;
    }

    @ThriftField(value=2, name="intListValue", requiredness=Requiredness.NONE)
    public List<Long> getIntListValue() {
        if (this.id != 2) {
            throw new IllegalStateException("Not a intListValue element!");
        }
        return (List<Long>) value;
    }

    public boolean isSetIntListValue() {
        return this.id == 2;
    }

    @ThriftField(value=3, name="stringListValue", requiredness=Requiredness.NONE)
    public List<String> getStringListValue() {
        if (this.id != 3) {
            throw new IllegalStateException("Not a stringListValue element!");
        }
        return (List<String>) value;
    }

    public boolean isSetStringListValue() {
        return this.id == 3;
    }

    @ThriftField(value=9, name="typedefValue", requiredness=Requiredness.NONE)
    public Map<Short, String> getTypedefValue() {
        if (this.id != 9) {
            throw new IllegalStateException("Not a typedefValue element!");
        }
        return (Map<Short, String>) value;
    }

    public boolean isSetTypedefValue() {
        return this.id == 9;
    }

    @ThriftField(value=14, name="stringRef", requiredness=Requiredness.NONE, idlAnnotations = { @ThriftIdlAnnotation(key = "cpp2.ref", value = "true") })
    public String getStringRef() {
        if (this.id != 14) {
            throw new IllegalStateException("Not a stringRef element!");
        }
        return (String) value;
    }

    public boolean isSetStringRef() {
        return this.id == 14;
    }

    @ThriftUnionId
    public int getThriftId()
    {
        return this.id;
    }

    public String getThriftName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
            .add("value", value)
            .add("id", id)
            .add("name", name)
            .add("type", value == null ? "<null>" : value.getClass().getSimpleName())
            .toString();
    }
}
