package com.cybage.pojos;

import java.sql.Date;

public class AllBatchInfo {
	
	private int batchId;
	private Date startDate;
	private Date endDate;
	private int batchSize;
	private String sportName;
	private int sportid;
	private int planId;
	private String planName;
	private double fees;
	private int duration;
	private int enrollId;	
	private String mStatus;
	private String username;
	
	
	public AllBatchInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AllBatchInfo(int batchId, Date startDate, Date endDate, int batchSize, String sportName, int sportid,
			int planId, String planName, double fees, int duration) {
		super();
		this.batchId = batchId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.batchSize = batchSize;
		this.sportName = sportName;
		this.sportid = sportid;
		this.planId = planId;
		this.planName = planName;
		this.fees = fees;
		this.duration = duration;
	}
	
	

	

	public AllBatchInfo(int batchId, Date startDate, Date endDate, int batchSize, String sportName, int sportid,
			int planId, String planName, double fees, int duration, int enrollId, String mStatus, String username) {
		super();
		this.batchId = batchId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.batchSize = batchSize;
		this.sportName = sportName;
		this.sportid = sportid;
		this.planId = planId;
		this.planName = planName;
		this.fees = fees;
		this.duration = duration;
		this.enrollId = enrollId;
		this.mStatus = mStatus;
		this.username = username;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getBatchSize() {
		return batchSize;
	}

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public int getSportid() {
		return sportid;
	}

	public void setSportid(int sportid) {
		this.sportid = sportid;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(int enrollId) {
		this.enrollId = enrollId;
	}

	public String getmStatus() {
		return mStatus;
	}

	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AllBatchInfo [batchId=" + batchId + ", startDate=" + startDate + ", endDate=" + endDate + ", batchSize="
				+ batchSize + ", sportName=" + sportName + ", sportid=" + sportid + ", planId=" + planId + ", planName="
				+ planName + ", fees=" + fees + ", duration=" + duration + ", enrollId=" + enrollId + ", mStatus="
				+ mStatus + ", username=" + username + "]";
	}
	
	
	
	

}
