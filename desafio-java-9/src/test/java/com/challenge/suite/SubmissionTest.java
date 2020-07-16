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

public class SubmissionTest extends TableWithEmbeddedIdTest
{
    public static final String SUBMISSION = "submission";
    public static final String SCORE = "score";
    public static final String CHALLENGE = "challenge";
    public static final String USER = "user";
    
    @Override
    public List<String> getPrimaryKeys() {
        return Stream.of(new String[] { "challenge", "user" }).collect((Collector<? super String, ?, List<String>>)Collectors.toList());
    }
    
    @Override
    protected int manyToOnes() {
        return 0;
    }
    
    @Override
    protected int oneToManys() {
        return 0;
    }
    
    @Override
    public String getTableName() {
        return "submission";
    }
    
    @Test
    public void hasColumnScore() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("score");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasColumnScoreNotNull() {
        final Optional<Field> field = this.findByFieldNameOrColumnName("score");
        Assert.assertThat((Object)field.isPresent(), Matchers.equalTo((Object)true));
        Assert.assertThat((Object)this.fieldIsNotNull(field), Matchers.equalTo((Object)true));
    }
}