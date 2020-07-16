package com.challenge.suite;

import java.lang.annotation.Annotation;
import javax.persistence.Embeddable;
import org.junit.Test;
import java.lang.reflect.Field;
import java.util.Optional;
import org.junit.Assert;
import org.hamcrest.Matchers;
import javax.persistence.EmbeddedId;
import java.util.List;

public abstract class TableWithEmbeddedIdTest extends ClassTest
{
    public abstract List<String> getPrimaryKeys();
    
    @Test
    public void hasEmbeddedId() {
        final Optional<Field> field = (Optional<Field>)this.findFieldAnnotatedBy((Class)EmbeddedId.class);
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void checkEmbeddedIdIsEmbeddable() {
        final Boolean result = this.findFieldAnnotatedBy((Class)EmbeddedId.class).map(f -> f.getType().isAnnotationPresent((Class<? extends Annotation>)Embeddable.class)).orElse(false);
        Assert.assertThat((Object)result, Matchers.equalTo((Object)true));
    }
    
    @Test
    public void checkPrimaryKeys() {
        final Field field = this.findFieldAnnotatedBy((Class)EmbeddedId.class).orElseThrow(() -> new RuntimeException("Not embeddedId"));
        this.getPrimaryKeys().forEach(key -> Assert.assertThat(key, (Object)this.hasFieldWithEntityName((Class)field.getType(), key), Matchers.equalTo((Object)true)));
    }
    
    @Test
    public void checkPrimaryKeysWithManyToOne() {
        final Field field = this.findFieldAnnotatedBy((Class)EmbeddedId.class).orElseThrow(() -> new RuntimeException("Not embeddedId"));
        this.getPrimaryKeys().forEach(key -> Assert.assertThat(key, (Object)this.hasManyToOneWithEntityName((Class)field.getType(), key), Matchers.equalTo((Object)true)));
    }
}