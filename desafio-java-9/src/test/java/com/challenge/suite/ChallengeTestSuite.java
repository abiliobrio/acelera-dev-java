package com.challenge.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ AccelerationTest.class, CandidateTest.class, ChallengeTest.class, CompanyTest.class, SubmissionTest.class, UserTest.class })
public class ChallengeTestSuite
{
}