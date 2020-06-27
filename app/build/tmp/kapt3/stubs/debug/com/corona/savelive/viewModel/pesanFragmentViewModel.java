package com.corona.savelive.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/corona/savelive/viewModel/pesanFragmentViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "Allpesan", "Landroidx/lifecycle/LiveData;", "", "Lcom/corona/savelive/model/Modelinsert;", "getAllpesan", "()Landroidx/lifecycle/LiveData;", "setAllpesan", "(Landroidx/lifecycle/LiveData;)V", "repository", "Lcom/corona/savelive/repo/PesanRepository;", "getRepository", "()Lcom/corona/savelive/repo/PesanRepository;", "setRepository", "(Lcom/corona/savelive/repo/PesanRepository;)V", "delete", "Lkotlinx/coroutines/Job;", "pesan", "init", "", "context", "Landroid/content/Context;", "insertAll", "app_debug"})
public final class pesanFragmentViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    public com.corona.savelive.repo.PesanRepository repository;
    @org.jetbrains.annotations.NotNull()
    public androidx.lifecycle.LiveData<java.util.List<com.corona.savelive.model.Modelinsert>> Allpesan;
    
    @org.jetbrains.annotations.NotNull()
    public final com.corona.savelive.repo.PesanRepository getRepository() {
        return null;
    }
    
    public final void setRepository(@org.jetbrains.annotations.NotNull()
    com.corona.savelive.repo.PesanRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.corona.savelive.model.Modelinsert>> getAllpesan() {
        return null;
    }
    
    public final void setAllpesan(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.corona.savelive.model.Modelinsert>> p0) {
    }
    
    public final void init(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull()
    com.corona.savelive.model.Modelinsert pesan) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.corona.savelive.model.Modelinsert> pesan) {
        return null;
    }
    
    public pesanFragmentViewModel() {
        super();
    }
}