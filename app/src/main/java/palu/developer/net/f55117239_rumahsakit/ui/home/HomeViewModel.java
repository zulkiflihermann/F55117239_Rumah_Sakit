package palu.developer.net.f55117239_rumahsakit.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> mText2;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText2 = new MutableLiveData<>();
        mText.setValue("SISTEM INFORMASI GEOGRAFIS RUMAH SAKIT");
        mText2.setValue("RUMAH SAKIT");

    }

    public LiveData<String> getText() {
        return mText;
    }
}