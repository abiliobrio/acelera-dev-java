package com.challenge.suite;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CompanyTest extends TableWithIdNameSlugTest
{
    public static final String COMPANY = "company";
    public static final String CANDIDATE = "candidate";
    
    public String getTableName() {
        return "company";
    }
    
    protected int manyToOnes() {
        return 0;
    }
    
    protected int oneToManys() {
        return 1;
    }
    
    @Test
    public void hasOneToManyCandidates() {
        final boolean result = this.hasOneToManyWithEntityName("candidate");
        Assert.assertThat((Object)result, Matchers.equalTo((Object)true));
    }
}