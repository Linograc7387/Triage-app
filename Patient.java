class Patient {

    String name;

    int severityScore;
    int professionScore;
    int ageScore;
    int genderScore;

    int totalScore;
    int arrivalOrder;

    public Patient(String name, int severity, int profession, int age, int gender, int arrivalOrder) {

        this.name = name;
        this.severityScore = severity;
        this.professionScore = profession;
        this.ageScore = age;
        this.genderScore = gender;

        this.totalScore = severity + profession + age + gender;
        this.arrivalOrder = arrivalOrder;
    }

    public String toString() {
        return name + " | score=" + totalScore + " | arrival=" + arrivalOrder;
    }
}