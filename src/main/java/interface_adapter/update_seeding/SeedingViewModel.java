package interface_adapter.update_seeding;

import interface_adapter.ViewModel;

public class SeedingViewModel extends ViewModel<SeedingState> {
    public SeedingViewModel() {
        super("seeding");
        setState(new SeedingState());
    }
}
