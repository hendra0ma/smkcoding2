package com.corona.savelive;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/corona/savelive/MyUpdateActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "cekNama", "", "cekPesan", "database", "Lcom/google/firebase/database/DatabaseReference;", "namaBaru", "Landroid/widget/EditText;", "pesanBaru", "update", "Landroid/widget/Button;", "getUpdate", "()Landroid/widget/Button;", "setUpdate", "(Landroid/widget/Button;)V", "viewModel", "Lcom/corona/savelive/viewModel/pesanUpdateViewModel;", "getViewModel", "()Lcom/corona/savelive/viewModel/pesanUpdateViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getData", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MyUpdateActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.EditText namaBaru;
    private android.widget.EditText pesanBaru;
    @org.jetbrains.annotations.NotNull()
    public android.widget.Button update;
    private com.google.firebase.database.DatabaseReference database;
    private com.google.firebase.auth.FirebaseAuth auth;
    private java.lang.String cekNama;
    private java.lang.String cekPesan;
    private final kotlin.Lazy viewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.Button getUpdate() {
        return null;
    }
    
    public final void setUpdate(@org.jetbrains.annotations.NotNull()
    android.widget.Button p0) {
    }
    
    private final com.corona.savelive.viewModel.pesanUpdateViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getData() {
    }
    
    public MyUpdateActivity() {
        super();
    }
}