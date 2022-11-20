package se.lexicon.dao;
import se.lexicon.model.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserDaoCollectionImpl implements AppUserDao{
    private List<AppUser> userStorage;

    public AppUserDaoCollectionImpl() {
        userStorage = new ArrayList<AppUser>();
    }

    @Override
    public AppUser findByUsername(String userName) {
        if (userName == null) throw new IllegalArgumentException("username was null");
        for (AppUser appUser : userStorage)
            if (appUser.getUsername().equalsIgnoreCase(userName)) return appUser;
        return null;
    }

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(userStorage);
    }

    @Override
    public AppUser persist(AppUser appUser) {
        if (appUser == null) throw new IllegalArgumentException("appUser was null");
        AppUser result = findByUsername(appUser.getUsername());
        if (result != null) throw new IllegalArgumentException("username was duplicate");
        userStorage.add(appUser);
        return appUser;
    }

    @Override
    public void remove(String userName) {
        if (userName == null) throw new IllegalArgumentException("username was null");
        AppUser result = findByUsername(userName);
        if (result != null)
            userStorage.remove(result);
        throw new IllegalArgumentException("user is not available in the collection");
    }
}

