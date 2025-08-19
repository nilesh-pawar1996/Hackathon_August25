package com.sunbeam.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackResponseEntity {
	
	  @Column(length = 100, nullable = false, unique = true)
	    private String templateName;

	    // Template created by Admin
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "created_by", nullable = false)
	    private User createdBy;

	    // Template has many questions
	    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<TemplateQuestionEntity> questions;

}
