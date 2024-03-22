package dev.verosampedro.aniproject.requests;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import dev.verosampedro.aniproject.users.User;

@Entity
@Table(name = "requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String applicantName;

    @Column(nullable = false)
    private String requestDate;

    @Column(nullable = false)
    private String requestTopic;

    @Column(nullable = false)
    private String requestDescription;

    @ManyToOne
    @JoinColumn(name = "user_id") 
    private User assignedUser;

    public Request() {
    }
    
    public Request(Long id, String applicantName, String requestDate, String requestTopic, String requestDescription) {
        this.id = id;
        this.applicantName = applicantName;
        this.requestDate = requestDate;
        this.requestTopic = requestTopic;
        this.requestDescription = requestDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestTopic() {
        return requestTopic;
    }

    public void setRequestTopic(String requestTopic) {
        this.requestTopic = requestTopic;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public void setRequestDescription(String requestDescription) {
        this.requestDescription = requestDescription;
    } 
}
