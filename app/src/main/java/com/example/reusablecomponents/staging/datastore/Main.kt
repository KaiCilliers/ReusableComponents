package com.example.reusablecomponents.staging.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

// ref: https://proandroiddev.com/is-jetpack-datastore-a-replacement-for-sharedpreferences-efe92d02fcb3
class Main : Fragment() {

    /*
     * Creates a property delegate for a single process DataStore.
     * This should only be called once in a file, and all usages of the DataStore should use a
     * reference to the same Instance.
     */
    val Context.prefsDataStore by preferencesDataStore(
        name = PreferencesNameUser().value()
    )

    suspend fun saveUserLoggedInState(state: Boolean) {
        requireContext().prefsDataStore.edit { preferences ->
            preferences[PreferenceKeys.IS_USER_LOGGED_IN] = state
        }
    }

    suspend fun getUserLoggedInState(): Flow<Boolean> {
        return requireContext().prefsDataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[PreferenceKeys.IS_USER_LOGGED_IN] ?: false
            }
    }
}

