package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class SubmissionId implements Serializable {

	@ManyToOne
    private User user_id;

    @ManyToOne
    private Challenge challenge_id;
    
}