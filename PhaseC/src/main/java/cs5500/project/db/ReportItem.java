package cs5500.project.db;

/**
 * An item is part of the report
 */
public class ReportItem {

    /**
     * @param refOffset the reference file offset
     * @param refLength the reference file length
     * @param similarOffset similar file offset
     * @param similarLength similar file length
     * @param model the model used in computation
     * @param score
     */
    public ReportItem(Integer refOffset, Integer refLength, Integer similarOffset, Integer similarLength, Integer model, Float score) {
        this.refOffset = refOffset;
        this.refLength = refLength;
        this.similarOffset = similarOffset;
        this.similarLength = similarLength;
        this.model = model;
        this.score = score;
    }

    /**
     * Default constructor
     */
    public ReportItem() {}

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


    /**
     * @return
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    private Integer refOffset;
    private Integer refLength;
    private Integer similarOffset;
    private Integer similarLength;
    private Integer model;
    private Float score;


}
