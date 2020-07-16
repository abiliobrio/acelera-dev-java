package com.challenge.suite;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.Matchers;

public class ChallengeTest extends TableWithIdNameSlugTest
{
    public static final String CHALLENGE = "challenge";
    public static final String ACCELERATION = "acceleration";
    public static final String SUBMISSION = "submission";
    
    public String getTableName() {
        return "challenge";
    }
    
    protected int manyToOnes() {
        return 0;
    }
    
    protected int oneToManys() {
        return 2;
    }
    
    @Test
    public void hasOneToManyAcceleration() {
        final boolean result = this.hasOneToManyWithEntityName("acceleration");
        Assert.assertThat((Object)result, Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasOneToManySubmission() {
        final boolean result = this.hasOneToManyWithEntityName("submission");
        Assert.assertThat((Object)result, Matchers.equalTo((Object)true));
    }
}