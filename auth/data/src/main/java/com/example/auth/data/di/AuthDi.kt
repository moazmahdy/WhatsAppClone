package com.example.auth.data.di

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.auth.data.repoimpl.AuthRepoImpl
import com.example.auth.domain.repo.AuthRepo
import com.example.auth.domain.usecase.AuthUseCase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthDi {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseFireStore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseApp(): FirebaseApp {
        //FirebaseApp.initializeApp(ApplicationContext() as Context)!!
        return FirebaseApp.getInstance()
    }

    @Provides
    @Singleton
    fun provideAuthRepo(auth: FirebaseAuth): AuthRepo {
        return AuthRepoImpl(auth)
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(authRepo: AuthRepo): AuthUseCase {
        return AuthUseCase(authRepo)
    }
}