package cs5500.project.spring.data;

import org.mongojack.Id;

/**
 * An item is part of the report
 */
public class ReportItem {

    /**
     * @param id the id
     * @param refFileId the reference file id
     * @param refOffset the reference file offset
     * @param refLength the reference file length
     * @param similarFildId similar file id
     * @param similarOffset similar file offset
     * @param similarLength similar file length
     * @param score score computed by the model
     * @param model the model used in computation
     */
    public ReportItem(Integer id, Integer refFileId, Integer refOffset, Integer refLength, Integer similarFildId, Integer similarOffset, Integer similarLength, Integer score, Integer model) {
        this.id = id;
        this.refFileId = refFileId;
        this.refOffset = refOffset;
        this.refLength = refLength;
        this.similarFildId = similarFildId;
        this.similarOffset = similarOffset;
        this.similarLength = similarLength;
        this.score = score;
        this.model = model;
    }

    /**
     * Default constructor
     */
    public ReportItem() {}

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the reference file id
     */
    public Integer getRefFileId() {
        return refFileId;
    }

    /**
     * @param refFileId the reference file id
     */
    public void setRefFileId(Integer refFileId) {
        this.refFileId = refFileId;
    }

    /**
     * @return  the reference file offset
     */
    public Integer getRefOffset() {
        return refOffset;
    }

    /**
     * @param refOffset the reference file offset
     */
    public void setRefOffset(Integer refOffset) {
        this.refOffset = refOffset;
    }

    /**
     * @return the reference file length
     */
    public Integer getRefLength() {
        return refLength;
    }

    /**
     * @param refLength the reference file length
     */
    public void setRefLength(Integer refLength) {
        this.refLength = refLength;
    }

    /**
     * @return the similar file id
     */
    public Integer getSimilarFildId() {
        return similarFildId;
    }

    /**
     * @param similarFildId the similar file id
     */
    public void setSimilarFildId(Integer similarFildId) {
        this.similarFildId = similarFildId;
    }

    /**
     * @return the similar file offset
     */
    public Integer getSimilarOffset() {
        return similarOffset;
    }

    /**
     * @param similarOffset the similar file offset
     */
    public void setSimilarOffset(Integer similarOffset) {
        this.similarOffset = similarOffset;
    }

    /**
     * @return the similar file length
     */
    public Integer getSimilarLength() {
        return similarLength;
    }

    /**
     * @param similarLength the similar file length
     */
    public void setSimilarLength(Integer similarLength) {
        this.similarLength = similarLength;
    }

    /**
     * @return score computed by the model
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score score computed by the model
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return the model for the report
     */
    public Integer getModel() {
        return model;
    }

    /**
     * @param model the model used for the report
     */
    public void setModel(Integer model) {
        this.model = model;
    }

    @Id
    private Integer id;
    private Integer refFileId;
    private Integer refOffset;
    private Integer refLength;
    private Integer similarFildId;
    private Integer similarOffset;
    private Integer similarLength;
    private Integer score;
    private Integer model;

}
