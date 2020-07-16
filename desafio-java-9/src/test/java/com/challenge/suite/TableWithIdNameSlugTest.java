package com.challenge.suite;

import org.junit.Test;
import java.lang.reflect.Field;
import java.util.Optional;
import org.junit.Assert;
import org.hamcrest.Matchers;

public abstract class TableWithIdNameSlugTest extends ClassTest
{
    public static final String NAME = "name";
    public static final String SLUG = "slug";
    
    @Test
    public void hasColumnName() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("name");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnNameNotNull() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("name");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldIsNotNull(field), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnNameSized() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("name");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldHasSize(field, 100), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnSlug() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("slug");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnSlugNotNull() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("slug");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldIsNotNull(field), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnSlugSize() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("slug");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldHasSize(field, 50), Matchers.equalTo((Object)true));
    }
}