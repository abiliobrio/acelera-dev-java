package com.challenge.suite;

import java.lang.annotation.Annotation;
import javax.validation.constraints.Email;
import org.junit.Test;
import java.lang.reflect.Field;
import java.util.Optional;
import org.junit.Assert;
import org.hamcrest.Matchers;

public class UserTest extends TableWithIdTest
{
    public static final String FULLNAME = "fullname";
    public static final String EMAIL = "email";
    public static final String NICKNAME = "nickname";
    public static final String PASSWORD = "password";
    public static final String SUBMISSION = "submission";
    public static final String CANDIDATE = "candidate";
    
    @Override
    protected int manyToOnes() {
        return 0;
    }
    
    @Override
    protected int oneToManys() {
        return 2;
    }
    
    @Override
    public String getTableName() {
        return "user";
    }
    
    @Test
    public void hasColumnFullName() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("fullname");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnFullNameNotNull() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("fullname");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldIsNotNull(field), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnFullNameSize() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("fullname");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldHasSize(field, 100), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnEmail() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("email");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnEmailNotNull() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("email");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldIsNotNull(field), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnEmailSize() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("email");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldHasSize(field, 100), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnEmailWithEmailAnnotation() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("email");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)field.get().isAnnotationPresent((Class<? extends Annotation>)Email.class), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnNickname() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("nickname");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnNicknameNotNull() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("nickname");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldIsNotNull(field), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnNicknameSize() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("nickname");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldHasSize(field, 50), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnPassword() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("password");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnPasswordNotNull() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("password");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldIsNotNull(field), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnPasswordSize() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("password");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldHasSize(field, 255), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasOneToManySubmissions() {
        final boolean result = this.hasOneToManyWithEntityName("submission");
        Assert.assertThat((Object)result, Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasOneToManyCandidates() {
        final boolean result = this.hasOneToManyWithEntityName("candidate");
        Assert.assertThat((Object)result, Matchers.equalTo((Object)true));
    }
}