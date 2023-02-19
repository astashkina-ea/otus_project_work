package data.courses;

public enum CoursesDurationData {

    JAVA_QA_PRO(".container__col_4 .course-header2-bottom__item-text");

    private String name;

    CoursesDurationData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}