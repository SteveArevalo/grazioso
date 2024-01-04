
public class Monkey extends RescueAnimal {

    // Monkey-specific attributes
    private double tailLength;
    private double height;
    private double bodyLength;
    private String species;

    // Constructor
    public Monkey(String name, String species, String gender, String age, String weight, 
    		double height, double tailLength, double bodyLength, String acquisitionDate, 
    		String acquisitionCountry, String trainingStatus, boolean reserved, String inServiceCountry) {
    	setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setTailLength(tailLength);
        setBodyLength(bodyLength);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

       }
    
	// Getter and setter methods for monkey-specific attributes
    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(double bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

}
