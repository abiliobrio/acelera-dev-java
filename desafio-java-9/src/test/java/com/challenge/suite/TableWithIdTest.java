package com.challenge.suite;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.junit.Test;
import java.lang.reflect.Field;
import java.util.Optional;
import org.junit.Assert;
import org.hamcrest.Matchers;

public abstract class TableWithIdTest extends ClassTest
{
    public static final String ID = "id";
    
    @Test
    public void hasColumnId() {
        final Optional<Field> field = this.findFieldByName("id");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasIdWithAnnotationId() {
        final Optional<Field> field = this.findFieldAnnotatedBy(Id.class);
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasIdWithAnnotationGeneratedValueWithStrategyIdentity() {
        this.verifyIdWithCorretStrategy();
    }
    
    @Test
    public void hasIdWithAnnotationGeneratedValue() {
        final Optional<Field> field = this.findFieldAnnotatedBy(GeneratedValue.class);
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
}