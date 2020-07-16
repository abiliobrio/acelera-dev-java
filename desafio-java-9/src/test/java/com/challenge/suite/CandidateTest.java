package com.challenge.suite;

import org.junit.Test;
import java.lang.reflect.Field;
import java.util.Optional;
import org.junit.Assert;
import org.hamcrest.Matchers;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class CandidateTest extends TableWithEmbeddedIdTest
{
    public static final String CANDIDATE = "candidate";
    public static final String USER = "user";
    public static final String ACCELERATION = "acceleration";
    public static final String COMPANY = "company";
    public static final String STATUS = "status";
    
    public String getTableName() {
        return "candidate";
    }
    
    protected int manyToOnes() {
        return 0;
    }
    
    protected int oneToManys() {
        return 0;
    }
    
    public List<String> getPrimaryKeys() {
        return Stream.of(new String[] { "user", "acceleration", "company" }).collect((Collector<? super String, ?, List<String>>)Collectors.toList());
    }
    
    @Test
    public void hasColumnStatus() {
        final Optional<Field> field = (Optional<Field>)this.findByFieldNameOrColumnName("status");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnStatusNotNull() {
        final Optional<Field> field = (Optional<Field>)this.findByFieldNameOrColumnName("status");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldIsNotNull((Optional)field), Matchers.equalTo((Object)true));
    }
}