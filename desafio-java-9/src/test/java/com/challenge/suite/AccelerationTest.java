package com.challenge.suite;

import org.junit.Test;
import org.junit.Assert;
import org.hamcrest.Matchers;

public class AccelerationTest extends TableWithIdNameSlugTest
{
    public static final String ACCELERATION = "acceleration";
    public static final String CHALLENGE = "challenge";
    public static final String CANDIDATE = "candidate";
    
    public String getTableName() {
        return "acceleration";
    }
    
    protected int manyToOnes() {
        return 1;
    }
    
    protected int oneToManys() {
        return 1;
    }
    
    @Test
    public void hasManyToOneChallenge() {
        final Boolean is = this.hasManyToOneWithEntityName("challenge");
        Assert.assertThat((Object)is, Matchers.equalTo((Object)true));
    }
    
    @Test
    public void hasOneToManyCandidates() {
        final boolean result = this.hasOneToManyWithEntityName("candidate");
        Assert.assertThat((Object)result, Matchers.equalTo((Object)true));
    }
}