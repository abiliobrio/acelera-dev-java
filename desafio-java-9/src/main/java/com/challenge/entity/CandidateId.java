package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CandidateId implements Serializable {

  	@ManyToOne
    private User user_id;

    @ManyToOne
    private Acceleration acceleration_id;

    @ManyToOne
    private Company company_id;

}