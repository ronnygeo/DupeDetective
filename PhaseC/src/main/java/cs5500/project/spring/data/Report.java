package cs5500.project.spring.data;

import org.mongojack.MongoCollection;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@MongoCollection(name = "reports")
public class Report{
	
	@Id private String id;

	private Integer refFileId;
	private Integer similarFileId;
	private List<ReportItem> items;

	public Report(Integer refFileId, Integer similarFileId) {
		this.refFileId = refFileId;
		this.similarFileId = similarFileId;
		items = new ArrayList<>();
	}

	public Report() {
		items = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ReportItem> getItems() {
		return items;
	}

	public void setItems(List<ReportItem> items) {
		this.items = items;
	}

	public void addItems(List<ReportItem> items) {
		this.items.addAll(items);
	}

	public Integer getRefFileId() {
		return refFileId;
	}

	public void setRefFileId(Integer refFileId) {
		this.refFileId = refFileId;
	}

	public Integer getSimilarFileId() {
		return similarFileId;
	}

	public void setSimilarFileId(Integer similarFileId) {
		this.similarFileId = similarFileId;
	}

}
