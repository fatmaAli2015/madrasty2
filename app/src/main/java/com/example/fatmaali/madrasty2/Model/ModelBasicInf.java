package com.example.fatmaali.madrasty2.Model;

public class ModelBasicInf {
    private long id;
    private String SpinnerLearning;
    private String SpinnerNum;
    private String NameOfAdministration;
    private String SchoolName;
    private String periodFrom;
    private String periodTo;

    public ModelBasicInf() {
    }

    public ModelBasicInf(String spinnerLearning, String spinnerNum,
                         String nameOfAdministration, String schoolName,
                         String periodFrom, String periodTo) {
        SpinnerLearning = spinnerLearning;
        SpinnerNum = spinnerNum;
        NameOfAdministration = nameOfAdministration;
        SchoolName = schoolName;
        this.periodFrom = periodFrom;
        this.periodTo = periodTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpinnerLearning() {
        return SpinnerLearning;
    }

    public void setSpinnerLearning(String spinnerLearning) {
        SpinnerLearning = spinnerLearning;
    }

    public String getSpinnerNum() {
        return SpinnerNum;
    }

    public void setSpinnerNum(String spinnerNum) {
        SpinnerNum = spinnerNum;
    }

    public String getNameOfAdministration() {
        return NameOfAdministration;
    }

    public void setNameOfAdministration(String nameOfAdministration) {
        NameOfAdministration = nameOfAdministration;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(String periodFrom) {
        this.periodFrom = periodFrom;
    }

    public String getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(String periodTo) {
        this.periodTo = periodTo;
    }
}
