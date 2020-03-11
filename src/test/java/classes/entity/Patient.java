package classes.entity;

public class Patient extends Person {
    private String phoneNumber;
    private int medicalCardNumber;
    private String diagnosis;

    public Patient(long Id, String name, String patronymic, String surname, Address address, String phoneNumber, int medicalCardNumber, String diagnosis) {
        super(Id, name, patronymic, surname, address);
        this.phoneNumber = phoneNumber;
        setMedicalCardNumber(medicalCardNumber);
        this.diagnosis = diagnosis;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public void setMedicalCardNumber(int medicalCardNumber) {
        this.medicalCardNumber = Math.max(medicalCardNumber, 0);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Override
    public String toString() {
        return "{" + super.toString() +
                ", PhoneNumber='" + phoneNumber + '\'' +
                ", MedicalCardNumber=" + medicalCardNumber +
                ", Diagnosis='" + diagnosis + '\'' +
                '}' + '\n';
    }
}
