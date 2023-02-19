package data.courses;

public enum CoursesTitleData {

    JAVA_QA_PRO(".course-header2__title");

    private String name;

    CoursesTitleData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
