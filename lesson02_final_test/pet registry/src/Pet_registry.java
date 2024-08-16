import DB.DataBase;
import view.PetRegistryView;

public class Pet_registry {
    public static void main(String[] args) {
        DataBase.DB();
        new PetRegistryView().start();
    }
}