package data.courses;

public enum CoursesSubTitleData {

    JAVA_QA_PRO(".course-header2__subtitle");

    private String name;

    CoursesSubTitleData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}