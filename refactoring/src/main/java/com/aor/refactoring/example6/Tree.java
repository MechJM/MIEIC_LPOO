package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    public Date plantedAt;
    private Location location;
    private List<Date> appraisalDates;

    public Tree(Date plantedAt, Location location){
        this.plantedAt = plantedAt;
        this.setLocation(location);
        this.appraisalDates = new ArrayList<>();
    }

    public void setLocation(Location location){
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + this.location.toString();
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    private Date getLatestAppraisalDate()
    {
        Date today = new Date();
        Date latestAppraisalDate = today;

        if (this.appraisalDates.size() > 0) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }
        for(Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }
        return latestAppraisalDate;
    }

    public boolean isNextAppraisalOverdue(){
        Date today = new Date();
        Date latestAppraisalDate = getLatestAppraisalDate();

        // Calculate next appraisal date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        final boolean isSaturday = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
        final boolean isSunday   = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;

        if (isSaturday)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (isSunday)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        Date nextAppraisalDate = calendar.getTime();
        // Appraisal is only overdue if its date is in the past
        return nextAppraisalDate.before(today);
    }
}
