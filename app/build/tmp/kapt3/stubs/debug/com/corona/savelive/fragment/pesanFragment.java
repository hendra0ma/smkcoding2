package com.corona.savelive.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J(\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0001\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020\u001cH\u0016J\u001a\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006."}, d2 = {"Lcom/corona/savelive/fragment/pesanFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/corona/savelive/adapter/PesanAdapter$dataListener;", "()V", "adapter", "Lcom/corona/savelive/adapter/PesanAdapter;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "dataPesan", "", "Lcom/corona/savelive/model/Modelinsert;", "getDataPesan", "()Ljava/util/List;", "setDataPesan", "(Ljava/util/List;)V", "ref", "Lcom/google/firebase/database/DatabaseReference;", "getRef", "()Lcom/google/firebase/database/DatabaseReference;", "setRef", "(Lcom/google/firebase/database/DatabaseReference;)V", "viewModel", "Lcom/corona/savelive/viewModel/pesanFragmentViewModel;", "getViewModel", "()Lcom/corona/savelive/viewModel/pesanFragmentViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "OnDeleteData", "", "data", "position", "", "getdata", "init", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", "view", "app_debug"})
public final class pesanFragment extends androidx.fragment.app.Fragment implements com.corona.savelive.adapter.PesanAdapter.dataListener {
    @org.jetbrains.annotations.NotNull()
    public com.google.firebase.database.DatabaseReference ref;
    private com.google.firebase.auth.FirebaseAuth auth;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.corona.savelive.model.Modelinsert> dataPesan;
    private final kotlin.Lazy viewModel$delegate = null;
    private com.corona.savelive.adapter.PesanAdapter adapter;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.database.DatabaseReference getRef() {
        return null;
    }
    
    public final void setRef(@org.jetbrains.annotations.NotNull()
    com.google.firebase.database.DatabaseReference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.corona.savelive.model.Modelinsert> getDataPesan() {
        return null;
    }
    
    public final void setDataPesan(@org.jetbrains.annotations.NotNull()
    java.util.List<com.corona.savelive.model.Modelinsert> p0) {
    }
    
    private final com.corona.savelive.viewModel.pesanFragmentViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void init() {
    }
    
    private final void getdata() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void OnDeleteData(@org.jetbrains.annotations.NotNull()
    com.corona.savelive.model.Modelinsert data, int position) {
    }
    
    public pesanFragment() {
        super();
    }
}