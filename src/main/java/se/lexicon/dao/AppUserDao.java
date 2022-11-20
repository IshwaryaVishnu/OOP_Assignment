package se.lexicon.dao;

import se.lexicon.model.AppUser;
import java.util.List;

public interface AppUserDao {
     AppUser persist (AppUser appUser);
     AppUser findByUsername(String userName);
     List<AppUser> findAll ();
     void remove (String userName);

}
