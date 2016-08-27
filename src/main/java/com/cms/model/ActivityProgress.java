package com.cms.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "progress_activity")

public class ActivityProgress implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "progress_id")
    private Progress progress;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tc_id")
    private TrainingCenter trainingCenter;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public TrainingCenter getTrainingCenter() {
        return trainingCenter;
    }

    public void setTrainingCenter(TrainingCenter trainingCenter) {
        this.trainingCenter = trainingCenter;
    }
}
