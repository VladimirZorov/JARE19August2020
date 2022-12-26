package vetClinic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Clinic {

    private int capacity;
    private Collection<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove (String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }

    public Pet getOldestPet () {
       return data.stream().max(Comparator.comparing(Pet::getAge)).get();
    }

    public int getCount () {
        return data.size();
    }

    public String getStatistics () {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("The clinic has the following patients:")).append(System.lineSeparator());

        for (Pet pet: data) {
            sb.append(String.format("%s %s", pet.getName(), pet.getOwner())).append(System.lineSeparator());
        }
    return sb.toString().trim();
    }
}
