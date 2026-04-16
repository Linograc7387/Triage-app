import java.util.ArrayList;

class TriageSystem {

    private ArrayList<Patient> patients = new ArrayList<>();

    private int arrivalCounter = 0;

    private int pointer = -1;

    private int direction = 1; // +1 right, -1 left

    public void addPatient(String name, int severity, int profession, int age, int gender) {

        Patient p = new Patient(name, severity, profession, age, gender, arrivalCounter++);

        int index = binaryInsertIndex(p);

        patients.add(index, p);
    }

    private int binaryInsertIndex(Patient p) {

        int left = 0;
        int right = patients.size() - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            Patient current = patients.get(mid);

            if (p.totalScore < current.totalScore) {
                right = mid - 1;
            }

            else if (p.totalScore > current.totalScore) {
                left = mid + 1;
            }

            else {

                if (p.arrivalOrder < current.arrivalOrder)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }

        return left;
    }

    public void setStartPoint(int index, int direction) {

        if (index < 0 || index >= patients.size()) {
            throw new IllegalArgumentException("Invalid start index");
        }

        if (direction != 1 && direction != -1) {
            throw new IllegalArgumentException("Direction must be 1 or -1");
        }

        this.pointer = index;
        this.direction = direction;
    }

    public Patient treatNext() {

        if (pointer < 0 || pointer >= patients.size()) {
            return null;
        }

        Patient p = patients.get(pointer);

        pointer += direction;

        return p;
    }

    public void printPatients() {

        System.out.println("\n--- TRIAGE LIST ---");

        for (int i = 0; i < patients.size(); i++) {

            if (i == pointer) {
                System.out.println(">> " + i + ": " + patients.get(i));
            } else {
                System.out.println(i + ": " + patients.get(i));
            }
        }
    }

    public int size() {
        return patients.size();
    }
    public void treatOutward(int start) {

        System.out.println("\n--- OUTWARD TREATMENT ORDER ---");

        if (start >= 0 && start < patients.size()) {
            System.out.println("Treating: " + patients.get(start));
        }

        int step = 1;

        while (true) {

            boolean treatedSomeone = false;

            int left = start - step;
            int right = start + step;

            if (left >= 0) {
                System.out.println("Treating: " + patients.get(left));
                treatedSomeone = true;
            }

            if (right < patients.size()) {
                System.out.println("Treating: " + patients.get(right));
                treatedSomeone = true;
            }

            if (!treatedSomeone) {
                break;
            }

            step++;
        }
    }
}