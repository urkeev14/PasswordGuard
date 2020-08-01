package project.passwordguard.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import project.passwordguard.model.CredentialsEntity;
import project.passwordguard.repository.Repository;

public class CredentialsViewModel extends ViewModel {

    private Repository repository;
    private LiveData<List<CredentialsEntity>> credentials;

    public CredentialsViewModel() {
        super();
        repository = Repository.getInstance();
        credentials = new MutableLiveData<>();
        credentials = repository.getCredentials();
    }

    public void insert(CredentialsEntity entity) {
        repository.insert(entity);
    }

    public void update(CredentialsEntity entity) {
        repository.update(entity);
    }

    public void delete(CredentialsEntity entity) {
        repository.delete(entity);
    }

    public LiveData<List<CredentialsEntity>> getCredentials() {
        return credentials;
    }

}