package data.courses;

public enum CoursesFormatData {

    JAVA_QA_PRO(".container__col_2 .course-header2-bottom__item-text");

    private String name;

    CoursesFormatData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}