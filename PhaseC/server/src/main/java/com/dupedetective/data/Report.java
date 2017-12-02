package com.dupedetective.data;

import com.dupedetective.engine.Model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The ModelReport object
 */
@Document(collection="report")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Report {


    /**
     * @param submissionId submission id
     * @param refFileId reference file id
     * @param similarFileId similar file id
     */
    public Report(String submissionId, String refFileId, String similarFileId) {
        this.submissionId = submissionId;
        this.refFileId = refFileId;
        this.similarFileId = similarFileId;
        models = new ArrayList<>();
    }

    /**
     * Default constructor
     */
    public Report() {
        models = new ArrayList<>();
    }

    /**
     * @return the id of the report
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id of the report
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the reference file id
     */
    public String getRefFileId() {
        return refFileId;
    }

    /**
     * @param refFileId the reference file id
     */
    public void setRefFileId(String refFileId) {
        this.refFileId = refFileId;
    }

    /**
     * @return the similar file id
     */
    public String getSimilarFileId() {
        return similarFileId;
    }

    /**
     * @param similarFileId the similar file id
     */
    public void setSimilarFileId(String similarFileId) {
        this.similarFileId = similarFileId;
    }

    /**
     * @return the submission id
     */
    public String getSubmissionId() {
        return submissionId;
    }

    /**
     * @param submissionId the submission id
     */
    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }


    /**
     * @return overall score of all the models
     */
    public float getOverallScore() {
        return overallScore;
    }

    /**
     * @param overallScore overall score of all the models
     */
    public void setOverallScore(float overallScore) {
        this.overallScore = overallScore;
    }

    /**
     * @return  whether md5 checksum is same or not
     */
    public boolean getMd5Result() {
        return md5Result;
    }

    /**
     * @param md5Result whether md5 checksum is same or not
     */
    public void setMd5Result(boolean md5Result) {
        this.md5Result = md5Result;
    }

    /**
     * @return list of Model Reports in this report
     */
    public List<ModelReport> getModels() {
        return models;
    }

    /**
     * @param models list of Model Reports
     */
    public void setModels(List<ModelReport> models) {
        this.models = models;
    }

    /**
     * Add the given Model report to the list of model reports
     * @param model a model report to add
     */
    public void addModel(ModelReport model) {
        this.models.add(model);
    }

    public void computeScore(Map<Integer, Float> weights) {
        float score = 0;
        float weightSum = 0f;
        for (ModelReport model: models) {
            if (model.getModel() != Model.MD5.getValue()) {
                score += weights.get(model.getModel()) * model.getScore();
                weightSum += weights.get(model.getModel());
            }
        }
        if (weightSum > 0) score /= weightSum;
        this.overallScore = score;
    }

    @Id
    private String id;
    private String submissionId;
    private String refFileId;
    private String similarFileId;
    private float overallScore;
    private boolean md5Result;
    private List<ModelReport> models;
}
